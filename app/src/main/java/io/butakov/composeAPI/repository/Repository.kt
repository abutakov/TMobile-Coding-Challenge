package io.butakov.composeAPI.repository

import io.butakov.composeAPI.network.CardRetrofitService

open class Repository(val apiService: CardRetrofitService) {
    open suspend fun getCards() = apiService.getCardsAsync()
}