package com.example.cleanarchsample.data.remote.dto

data class StockDto(
    val current_price: Double,
    val description: String,
    val id: String,
    val instrument_type: String,
    val name: String,
    val previous_price: Double,
    val ticker: String
)