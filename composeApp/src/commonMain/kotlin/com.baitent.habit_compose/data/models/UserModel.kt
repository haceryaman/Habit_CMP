package com.baitent.habit_compose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class UserEntity(
    @PrimaryKey val email: String,      // use email as primary key (one row per user)
    val userName: String,
    val firstName: String?,
    val lastName: String?,
    val avatarUrl: String?,
    val isRememberMe: Boolean
)