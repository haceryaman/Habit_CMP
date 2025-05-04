package com.baitent.habit_compose.domain.repository

import com.baitent.habit_compose.data.models.UserEntity
import kotlinx.coroutines.flow.StateFlow

interface UserRepository {

    val currentUser: StateFlow<UserEntity?>

    suspend fun getRemembered(): UserEntity?

    suspend fun save(user: UserEntity)

    suspend fun clearRememberMe()
}