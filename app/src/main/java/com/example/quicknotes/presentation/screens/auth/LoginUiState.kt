package com.example.quicknotes.presentation.screens.auth

sealed class LoginUIState {
    object Initial : LoginUIState()
    object Loading : LoginUIState()
    data class Error(val message: String) : LoginUIState()
    object LoggedIn : LoginUIState()
}