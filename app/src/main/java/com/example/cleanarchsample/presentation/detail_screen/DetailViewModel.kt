package com.example.cleanarchsample.presentation.detail_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rvsample.data.remote.model.CoinDetailsDto
import com.example.rvsample.data.repository.CoinRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailViewModel constructor(
    val coinRepository: CoinRepository = CoinRepository()
) : ViewModel() {

    private val _coinDetail = MutableLiveData<CoinDetailsDto>()
    val coinDetail: LiveData<CoinDetailsDto> = _coinDetail


    fun getCoinDetail(coinId: String) {
        viewModelScope.launch {
            coinRepository.getCoinDetails(coinId).collect {
                _coinDetail.value = it
            }
        }
    }

}