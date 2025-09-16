package com.example.quicknotes.data.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.quicknotes.data.local.entity.NoteEntity

interface NoteDao {

    @Query("SELECT * FROM notes WHERE userId = :userId ORDER BY lastModified DESC")
    suspend fun getNotes(userId: String): List<NoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inset(note: NoteEntity): Long

    @Update
    suspend fun update(note: NoteEntity)

    @Delete
    suspend fun delete(note: NoteEntity)

    @Query("DELETE FROM notes WHERE userId = :userId")
    suspend fun deleteAllForUser(userId: String)
}