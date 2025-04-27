package com.baitent.habit_compose.database

import androidx.room.RoomDatabase
import com.baitent.habit_compose.data.source.locale.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO


fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
    return builder
        .addMigrations()
        //.setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
