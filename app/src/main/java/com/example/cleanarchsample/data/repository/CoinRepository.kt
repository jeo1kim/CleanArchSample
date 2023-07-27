package com.example.rvsample.data.repository

import android.util.Log
import com.example.rvsample.data.remote.model.CoinDto
import com.example.rvsample.data.CoinApi
import com.example.rvsample.data.remote.model.CoinDetailsDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class CoinRepository constructor(
    val api: CoinApi = CoinApi.getInstance()
){

    suspend fun getCoins(): Flow<List<CoinDto>> = flow {

        try {
            val coins = api.getCoins()
            emit(coins)
        } catch (e: HttpException) {
            Log.e("CoinRepository", "getCoins error")
        }
    }

    suspend fun getCoinDetails(coinId: String): Flow<CoinDetailsDto> = flow {
        try {
            val coinDetails = api.getCoinById(coinId)
            emit(coinDetails)
        } catch (e: HttpException) {
            Log.e("CoinRepository", "getCoinDetails error")
        }
    }
}