package com.example.quicknotes.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: String,
    val displayName: String = "",
    val email: String = "",
    val photoUrl: String? = null
)