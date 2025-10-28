package com.example.quicknotes.di

import com.example.quicknotes.domain.repository.NoteRepository
import com.example.quicknotes.domain.repository.UserRepository
import com.example.quicknotes.domain.useCase.noteRepo.AddNoteUseCase
import com.example.quicknotes.domain.useCase.noteRepo.DeleteAllNotesUseCase
import com.example.quicknotes.domain.useCase.noteRepo.GetNotesUseCase
import com.example.quicknotes.domain.useCase.noteRepo.UpdateNoteUseCase
import com.example.quicknotes.domain.useCase.userRepo.SignInWithGoogleUseCase
import com.example.quicknotes.domain.useCase.userRepo.SignOutUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    // NoteRepository
    @Provides
    fun provideGetNotesUseCase(noteRepository: NoteRepository) =
        GetNotesUseCase(noteRepository)

    @Provides
    fun provideAddNoteUseCase(noteRepository: NoteRepository) =
        AddNoteUseCase(noteRepository)

    @Provides
    fun provideUpdateNoteUseCase(noteRepository: NoteRepository) =
        UpdateNoteUseCase(noteRepository)

    @Provides
    fun provideDeleteAllNotesUseCase(noteRepository: NoteRepository) =
        DeleteAllNotesUseCase(noteRepository)

    // UserRepository
    @Provides
    fun provideSignInUseCase(userRepository: UserRepository) =
        SignInWithGoogleUseCase(userRepository)

    @Provides
    fun provideSignOutUseCase(userRepository: UserRepository) =
        SignOutUseCase(userRepository)
}