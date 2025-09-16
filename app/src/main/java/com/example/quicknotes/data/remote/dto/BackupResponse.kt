package com.example.quicknotes.data.remote.dto

data class BackupResponse(
    val userId: String,
    val notes: List<NoteDto>
)