package com.baitent.habit_compose.database

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Room
import com.baitent.habit_compose.data.source.locale.database.AppDatabase


fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("habit_room.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}