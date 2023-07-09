package com.example.cleanarchsample.presentation.coin_details

import com.example.cleanarchsample.domain.model.CoinDetails

data class CoinDetailState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: CoinDetails? = null
)
