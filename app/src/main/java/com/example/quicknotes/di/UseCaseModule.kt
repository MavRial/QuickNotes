package com.example.quicknotes.di

import com.example.quicknotes.domain.repository.NoteRepository
import com.example.quicknotes.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

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
    fun provideDeleteNoteUseCase(noteRepository: NoteRepository) =
        DeleteNoteUseCase(noteRepository)

    @Provides
    fun provideSignInUseCase(userRepository: UserRepository) =
        SignInUseCase(userRepository)

    @Provides
    fun provideSignOutUseCase(userRepository: UserRepository) =
        SignOutUseCase(userRepository)
}