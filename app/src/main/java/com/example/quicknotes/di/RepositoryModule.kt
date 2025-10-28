package com.example.quicknotes.di

import com.example.quicknotes.data.local.dao.NoteDao
import com.example.quicknotes.data.repository.NoteRepositoryImpl
import com.example.quicknotes.data.repository.UserRepositoryImpl
import com.example.quicknotes.domain.repository.NoteRepository
import com.example.quicknotes.domain.repository.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNoteRepository(
        noteDao: NoteDao,
        firestore: FirebaseFirestore,
    ): NoteRepository = NoteRepositoryImpl(noteDao,firestore)

    @Provides
    @Singleton
    fun provideUserRepository(
        auth: FirebaseAuth
    ): UserRepository = UserRepositoryImpl(auth)

}