package io.butakov.composeAPI.model

sealed class ResponseType{
    data class Success(val data: List<Card>): ResponseType()
    data class Failure(val error: String): ResponseType()
    data class Loading(var loading: Boolean): ResponseType()
}
