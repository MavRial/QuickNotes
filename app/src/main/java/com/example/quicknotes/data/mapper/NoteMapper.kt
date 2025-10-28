package com.example.quicknotes.data.mapper

import com.example.quicknotes.data.local.entity.NoteEntity
import com.example.quicknotes.data.remote.dto.NoteDto
import com.example.quicknotes.domain.model.Note

// ENTITY to DOMAIN
fun NoteEntity.toDomain() = Note(
    id = id.toString(),
    usedId = userId,
    title = title,
    content = content,
    lastModified = lastModified
)

// DTO to DOMAIN
fun NoteDto.toDomain() = Note(
    id = id ?: "",
    usedId = userId ?: "",
    title = title ?: "",
    content = content ?: "",
    lastModified = lastModified ?: System.currentTimeMillis()
)

// DOMAIN to ENTITY
fun Note.toEntity() = NoteEntity(
    id = if (id.isEmpty()) 0L else id.toLong(),
    userId = usedId,
    title = title,
    content = content,
    lastModified = lastModified
)

// DOMAIN to DTO
fun Note.toDto() = NoteDto(
    id = if (id.isEmpty()) null else id,
    userId = usedId,
    title = title,
    content = content,
    lastModified = lastModified
)