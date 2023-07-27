package com.example.rvsample.data

import com.example.rvsample.data.remote.model.CoinDetailsDto
import com.example.rvsample.data.remote.model.CoinDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailsDto


    companion object {
        private const val BASE_URL = "https://api.coinpaprika.com/"

        private var retrofit: CoinApi? = null
        fun getInstance(): CoinApi {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CoinApi::class.java)
            }

            return retrofit!!
        }
    }

}