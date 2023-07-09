package com.example.cleanarchsample.data.repository

import com.example.cleanarchsample.data.remote.CoinApi
import com.example.cleanarchsample.data.remote.dto.CoinDto
import com.example.cleanarchsample.data.remote.dto.CoinDetailsDto
import com.example.cleanarchsample.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        return api.getCoinById(coinId)
    }

}