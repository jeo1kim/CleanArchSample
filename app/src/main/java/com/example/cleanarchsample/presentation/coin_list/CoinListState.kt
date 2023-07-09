package com.example.cleanarchsample.presentation.coin_list

import com.example.cleanarchsample.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<Coin> = emptyList()
)
