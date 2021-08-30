package io.butakov.ComposeAPI.repository

import io.butakov.ComposeAPI.network.CardRetrofitService

open class Repository(val apiService: CardRetrofitService) {
    open suspend fun getCards() = apiService.getCardsAsync()
}