package com.example.quicknotes.domain.useCase.noteRepo

import com.example.quicknotes.domain.model.Note
import com.example.quicknotes.domain.repository.NoteRepository
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) = repository.updateNote(note)
}