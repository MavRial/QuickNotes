package com.example.quicknotes.domain.repository

import com.example.quicknotes.domain.model.User

interface UserRepository {
    suspend fun signInWithGoogle(idToken: String): Result<User>
    suspend fun getCurrentUser(): Result<User?>
    suspend fun signOut(): Result<Unit>
}