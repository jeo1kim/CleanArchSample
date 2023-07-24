package com.example.cleanarchsample.data.repository

import com.example.cleanarchsample.data.remote.StockApi
import com.example.cleanarchsample.data.remote.dto.StockDto
import com.example.cleanarchsample.domain.repository.StockRepository
import javax.inject.Inject


class StockRepositoryImpl @Inject constructor(
    val api: StockApi
) : StockRepository {
    override suspend fun getStock(): List<StockDto> {
        return api.getStocks()
    }
}
