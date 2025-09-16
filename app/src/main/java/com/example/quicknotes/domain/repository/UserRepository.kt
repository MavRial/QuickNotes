package com.example.quicknotes.domain.repository

import com.example.quicknotes.domain.model.User

interface UserRepository {
    suspend fun signIn(email: String, password: String): Result<User>
    suspend fun signOut(): Result<Unit>
    suspend fun getCurrentUser(): Result<User?>
}