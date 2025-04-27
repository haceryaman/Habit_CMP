package com.baitent.habit_compose.data.models

data class UserEntity(
    val email: String,
    val userName: String?,
    val firstName: String?,
    val lastName: String?,
    val avatarUrl: String?,
    val isRememberMe: Boolean
)