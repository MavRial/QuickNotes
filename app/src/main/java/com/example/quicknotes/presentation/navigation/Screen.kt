package com.example.quicknotes.presentation.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Notes : Screen("notes")
    object NoteDetail : Screen("note_detail/{noteId}") {
        fun createRoute(noteId: String) = "note_detail/$noteId"
    }

}