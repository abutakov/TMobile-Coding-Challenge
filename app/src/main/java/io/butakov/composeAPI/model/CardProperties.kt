package io.butakov.composeAPI.model

data class CardProperties(
    val attributes: Attributes,
    val description: Description,
    val image: Image,
    val title: Title,
    val value: String
)