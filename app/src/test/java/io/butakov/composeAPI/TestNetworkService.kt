package io.butakov.composeAPI

import io.butakov.composeAPI.model.CardResponse
import io.butakov.composeAPI.network.CardRetrofitService
import com.google.gson.Gson
import java.lang.Exception

class TestNetworkService : CardRetrofitService {

    lateinit var data: CardResponse
    override suspend fun getCardsAsync(): CardResponse {

        val iS = javaClass.classLoader.getResourceAsStream("json_response.json")
        try {
            val byteArray = ByteArray(iS.available())
            iS.read(byteArray)
            val jsonValue = String(byteArray)
            data = Gson().fromJson<CardResponse>(jsonValue, CardResponse::class.java)
        } catch (e: Exception) {
            println(e.localizedMessage)
        }
        return data
    }

}