package io.butakov.composeAPI

import io.butakov.composeAPI.repository.Repository

class TestRepo(apiService: TestNetworkService) : Repository(apiService) {
    override suspend fun getCards() = apiService.getCardsAsync()
}