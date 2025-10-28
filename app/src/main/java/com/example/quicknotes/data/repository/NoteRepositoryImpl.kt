package com.example.quicknotes.data.repository

import com.example.quicknotes.data.local.dao.NoteDao
import com.example.quicknotes.data.mapper.toDomain
import com.example.quicknotes.data.mapper.toDto
import com.example.quicknotes.data.mapper.toEntity
import com.example.quicknotes.data.remote.dto.NoteDto
import com.example.quicknotes.domain.model.Note
import com.example.quicknotes.domain.repository.NoteRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlin.jvm.java

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao,
    private val firestore: FirebaseFirestore
) : NoteRepository {

    override suspend fun getNotes(userId: String): Result<List<Note>> = runCatching {

        val localNotes = noteDao.getNotes(userId).map { it.toDomain() }

        val remoteNotes = firestore.collection("notes")
            .whereEqualTo("userId", userId)
            .get()
            .await()
            .documents
            .mapNotNull { it.toObject(NoteDto::class.java)?.toDomain() }

        val localIds = localNotes.map { it.id }.toSet()
        remoteNotes.filter { it.id !in localIds }
            .forEach { noteDao.insert(it.toEntity()) }

        noteDao.getNotes(userId).map { it.toDomain() }
    }

    override suspend fun insertNote(note: Note): Result<Unit> = runCatching {
        val id = noteDao.insert(note.toEntity())

        firestore.collection("notes")
            .document(id.toString())
            .set(note.toDto())
            .await()
    }

    override suspend fun updateNote(note: Note): Result<Unit> = runCatching {
        noteDao.update(note.toEntity())

        firestore.collection("notes")
            .document(note.id)
            .set(note.toDto())
            .await()
    }

    override suspend fun deleteNote(note: Note): Result<Unit> = runCatching {
        noteDao.delete(note.toEntity())

        firestore.collection("notes")
            .document(note.id)
            .delete()
            .await()
    }

    override suspend fun deleteAllNotesForUser(userId: String): Result<Unit> = runCatching {

        noteDao.deleteAllForUser(userId)

        val notesSnapshot = firestore.collection("notes")
            .whereEqualTo("userId", userId)
            .get()
            .await()

        val batch = firestore.batch()
        notesSnapshot.documents.forEach { doc -> batch.delete(doc.reference) }
        batch.commit().await()
    }
}