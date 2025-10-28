package com.example.quicknotes.domain.useCase.userRepo

import com.example.quicknotes.domain.repository.UserRepository
import javax.inject.Inject

class SignOutUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke() = repository.signOut()
}