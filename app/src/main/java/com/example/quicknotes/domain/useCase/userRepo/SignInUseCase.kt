package com.example.quicknotes.domain.useCase.userRepo

import com.example.quicknotes.domain.repository.UserRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(email: String, password: String) = repository.signIn(email, password)
}