package com.example.cleanarchsample.presentation

import com.example.cleanarchsample.data.remote.dto.StockDto

data class StockListState(
    val data: List<StockDto> = emptyList()
)
