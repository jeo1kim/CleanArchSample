package com.example.cleanarchsample.domain.repository

import com.example.cleanarchsample.data.remote.dto.CoinDto
import com.example.cleanarchsample.data.remote.dto.CoinDetailsDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailsDto
}