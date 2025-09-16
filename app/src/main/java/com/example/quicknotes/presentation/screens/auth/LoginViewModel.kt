package com.example.quicknotes.presentation.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quicknotes.domain.repository.UserRepository
import com.example.quicknotes.domain.useCase.userRepo.SignInWithGoogleUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val signInWithGoogleUseCase: SignInWithGoogleUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUIState>(LoginUIState.Initial)
    val uiState: StateFlow<LoginUIState> = _uiState

    init {
        checkCurrentUser()
    }

    private fun checkCurrentUser(){
        viewModelScope.launch {
            val currentUser = userRepository.getCurrentUser()
            if (currentUser.isSuccess && currentUser.getOrNull() != null){
                _uiState.value = LoginUIState.LoggedIn
            }
        }
    }

    fun loginWithGoogle(idToken: String){
        viewModelScope.launch {
            _uiState.value = LoginUIState.Loading
            val result = signInWithGoogleUseCase(idToken)
            _uiState.value = if (result.isSuccess){
                LoginUIState.LoggedIn
            }else {
                LoginUIState.Error(result.exceptionOrNull()?.message ?: "Unknown error")

            }
        }
    }

    fun reset(){
        _uiState.value = LoginUIState.Initial
    }

    fun signOut(){
        viewModelScope.launch {
            userRepository.signOut()
            _uiState.value = LoginUIState.Initial
        }
    }

    fun onGoogleSignInClicked() {
        _uiState.value = LoginUIState.Loading

        viewModelScope.launch {
            delay(1000)
            _uiState.value = LoginUIState.LoggedIn
        }
    }
}