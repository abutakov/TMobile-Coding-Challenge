package com.example.composelist

import com.example.composelist.model.Cards
import com.example.composelist.network.CardRetrofitService
import com.google.gson.Gson
import java.lang.Exception

class TestNetworkService : CardRetrofitService {

    lateinit var data: Cards
    override suspend fun getCardsAsync(): Cards {

        val iS = javaClass.classLoader.getResourceAsStream("json_response.json")
        try {
            val byteArray = ByteArray(iS.available())
            iS.read(byteArray)
            val jsonValue = String(byteArray)
            data = Gson().fromJson<Cards>(jsonValue, Cards::class.java)
        } catch (e: Exception) {
            println(e.localizedMessage)
        }
        return data
    }

}