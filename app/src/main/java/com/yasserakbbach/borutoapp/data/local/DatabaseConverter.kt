package com.yasserakbbach.borutoapp.data.local

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class DatabaseConverter {

    @TypeConverter
    fun convertListToJsonString(items: List<String>): String =
        Json.encodeToString(items)

    @TypeConverter
    fun convertJsonStringToList(json: String): List<String> =
        Json.decodeFromString(json)
}