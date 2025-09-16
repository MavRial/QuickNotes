package com.example.quicknotes.domain.repository

import com.example.quicknotes.domain.model.User

interface UserRepository {
    suspend fun loginWithGoogle(token: String): Result<User>
    suspend fun getCurrentUser(): Result<User?>
    suspend fun logout(): Result<Unit>
}