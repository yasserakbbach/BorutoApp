package com.yasserakbbach.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yasserakbbach.borutoapp.data.local.dao.HeroDao
import com.yasserakbbach.borutoapp.domain.model.Hero

@Database(
    entities = [Hero::class],
    version = 1,
)
abstract class BorutoDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
}