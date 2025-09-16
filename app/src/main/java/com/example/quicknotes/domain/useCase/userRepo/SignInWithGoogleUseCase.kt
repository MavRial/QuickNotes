package com.example.quicknotes.domain.useCase.userRepo

import com.example.quicknotes.domain.repository.UserRepository
import javax.inject.Inject

class SignInWithGoogleUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(idToken: String) = repository.signInWithGoogle(idToken)
}