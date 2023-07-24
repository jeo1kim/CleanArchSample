package com.example.cleanarchsample.data.remote

import com.example.cleanarchsample.data.remote.dto.StockDto
import retrofit2.http.GET

interface StockApi {

    @GET("/dns-mcdaid/b248c852b743ad960616bac50409f0f0/raw/6921812bfb76c1bea7868385adf62b7f447048ce/instruments.json")
    suspend fun getStocks(): List<StockDto>
}