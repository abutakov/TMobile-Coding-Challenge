package io.butakov.composeAPI.network

import io.butakov.composeAPI.model.CardResponse
import io.butakov.composeAPI.util.Constants.Companion.EP
import io.butakov.composeAPI.util.Constants.Companion.URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CardRetrofitService {
    @GET(EP)
    suspend fun getCardsAsync(): CardResponse

    companion object{
        val cardService = getClient().create(CardRetrofitService::class.java)

        private fun getClient() = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}