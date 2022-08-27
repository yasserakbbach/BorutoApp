package com.yasserakbbach.borutoapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class HeroApiResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val heroes: List<Hero> = emptyList(),
)
