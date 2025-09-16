package com.example.quicknotes.data.mapper

import com.example.quicknotes.data.local.entity.UserEntity
import com.example.quicknotes.data.remote.dto.UserDto
import com.example.quicknotes.domain.model.User

// ENTITY to DOMAIN
fun UserEntity.toDomain() = User(
    id = id,
    displayName = displayName,
    email = email,
    photoUrl = photoUrl
)

//DTO to DOMAIN
fun UserDto.toDomain() = User(
    id = id ?: "",
    displayName = displayName ?: "",
    email = email ?: "",
    photoUrl = photoUrl
)

// DOMAIN to ENTITY
fun User.toEntity() = UserEntity(
    id = id,
    displayName = displayName,
    email = email,
    photoUrl = photoUrl
)

// DOMAIN to DTO
fun User.toDto() = UserDto(
    id = if (id.isEmpty()) null else id,
    displayName = displayName,
    email = email,
    photoUrl = photoUrl
)