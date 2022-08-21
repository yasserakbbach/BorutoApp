package com.yasserakbbach.borutoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hero_remote_key_table")
data class HeroRemoteKey(
    @PrimaryKey val id: Int,
    val prevKey: Int?,
    val nextKey: Int?,
)