package com.yasserakbbach.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yasserakbbach.borutoapp.data.local.dao.HeroDao
import com.yasserakbbach.borutoapp.data.local.dao.HeroRemoteKeysDao
import com.yasserakbbach.borutoapp.domain.model.Hero
import com.yasserakbbach.borutoapp.domain.model.HeroRemoteKeys

@Database(
    entities = [Hero::class, HeroRemoteKeys::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao
}