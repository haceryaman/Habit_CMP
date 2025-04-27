package com.baitent.habit_compose.data.source.locale.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.baitent.habit_compose.data.models.UserEntity

import androidx.room.*

@Dao
interface UserDao {
    /** Return the one user flagged “remember me” (or null) */
    @Query("SELECT * FROM users_table WHERE isRememberMe = 1 LIMIT 1")
    suspend fun getRememberedUser(): UserEntity?

    /** Insert or update a user row */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(user: UserEntity)

    /** Clear any existing “remember me” flags */
    @Query("UPDATE users_table SET isRememberMe = 0 WHERE isRememberMe = 1")
    suspend fun clearRememberMe()
}

