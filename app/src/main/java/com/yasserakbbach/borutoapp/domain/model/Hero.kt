package com.yasserakbbach.borutoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yasserakbbach.borutoapp.util.Constants.BORUTO_BASE_URL
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "hero_table")
data class Hero(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val rating: Double,
    val power: Int,
    val month: String,
    val day: String,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>,
) {
    val imageUrl: String
        get() = "$BORUTO_BASE_URL${image}"

    val formattedRating: String
        get() = "($rating)"
}
