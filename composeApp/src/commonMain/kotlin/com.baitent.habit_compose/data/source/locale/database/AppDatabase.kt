package com.baitent.habit_compose.data.source.locale.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.baitent.habit_compose.data.models.UserEntity
import com.baitent.habit_compose.data.source.locale.dao.UserDao


@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
