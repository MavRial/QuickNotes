package com.example.quicknotes.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quicknotes.data.local.dao.NoteDao
import com.example.quicknotes.data.local.dao.UserDao
import com.example.quicknotes.data.local.entity.NoteEntity
import com.example.quicknotes.data.local.entity.UserEntity

@Database(entities = [NoteEntity::class, UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun userDao(): UserDao
}

