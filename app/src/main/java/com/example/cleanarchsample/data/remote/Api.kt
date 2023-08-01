package com.example.cleanarchsample.data.remote

import com.example.cleanarchsample.common.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("/v1/coins")
    suspend fun getCoins(): List<Int>

//    @GET("/v1/coins/{coinId}")
//    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailsDto


    companion object {
        private var retrofit: Api? = null
        fun getInstance(): Api {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(Api::class.java)
            }

            return retrofit!!
        }
    }
}