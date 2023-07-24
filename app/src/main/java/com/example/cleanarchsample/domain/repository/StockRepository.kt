package com.example.cleanarchsample.domain.repository

import com.example.cleanarchsample.data.remote.dto.StockDto

interface StockRepository {

    suspend fun getStock(): List<StockDto>
}