package com.example.cleanarchsample.data.remote.dto

import com.example.cleanarchsample.domain.model.Coin

data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoin() = Coin(id, is_active, name, rank, symbol)

