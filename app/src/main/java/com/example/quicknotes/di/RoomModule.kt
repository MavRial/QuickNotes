package com.example.quicknotes.di

import android.app.Application
import androidx.room.Room
import com.example.quicknotes.data.local.dao.NoteDao
import com.example.quicknotes.data.local.dao.UserDao
import com.example.quicknotes.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "quicknotes.db")
            .fallbackToDestructiveMigration(false)
            .build()

    @Provides
    fun provideNoteDao(db: AppDatabase): NoteDao = db.noteDao()

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()
}