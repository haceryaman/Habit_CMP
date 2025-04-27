package com.baitent.habit_compose.domain.repository

import com.baitent.habit_compose.data.models.UserEntity

interface UserRepository {
    suspend fun getRemembered(): UserEntity?

    suspend fun save(user: UserEntity)

    suspend fun clearRememberMe()
}