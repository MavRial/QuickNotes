package com.example.quicknotes.domain.useCase.noteRepo

import com.example.quicknotes.domain.repository.NoteRepository
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(userId: String) = repository.getNotes(userId)
}