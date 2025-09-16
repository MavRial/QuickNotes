package com.example.quicknotes.data.remote.dto

data class BackupRequest(
    val userId: String,
    val notes: List<NoteDto>
)