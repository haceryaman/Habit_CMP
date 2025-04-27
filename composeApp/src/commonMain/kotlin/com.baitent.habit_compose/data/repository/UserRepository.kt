package com.baitent.habit_compose.data.repository

import com.baitent.habit_compose.data.models.UserEntity
import com.baitent.habit_compose.data.source.locale.dao.UserDao


class UserRepository(private val dao: UserDao) {
    suspend fun getRemembered(): UserEntity? =
        dao.getRememberedUser()

    suspend fun save(user: UserEntity) =
        dao.upsert(user)

    suspend fun clearRememberMe() =
        dao.clearRememberMe()
}
