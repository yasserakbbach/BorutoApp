package com.yasserakbbach.borutoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hero_remote_keys_table")
data class HeroRemoteKeys(
    @PrimaryKey val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
)