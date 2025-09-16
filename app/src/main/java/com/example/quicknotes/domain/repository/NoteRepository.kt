package com.example.quicknotes.domain.repository

import com.example.quicknotes.domain.model.Note

interface NoteRepository {
    suspend fun getNotes(userId: String): Result<List<Note>>
    suspend fun insertNote(note: Note): Result<Unit>
    suspend fun updateNote(note: Note): Result<Unit>
    suspend fun deleteNote(note: Note): Result<Unit>
    suspend fun deleteAllNotesForUser(userId: String): Result<Unit>
}