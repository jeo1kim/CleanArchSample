package com.example.cleanarchsample.presentation.list_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rvsample.data.remote.model.CoinDto
import com.example.rvsample.data.repository.CoinRepository
import kotlinx.coroutines.launch

class MainViewModel constructor(
    val coinRepository: CoinRepository = CoinRepository()
) : ViewModel() {


    private val _coins: MutableLiveData<List<CoinDto>> = MutableLiveData(listOf())
    val coin = _coins


    fun getCoins() {
        viewModelScope.launch {
            coinRepository.getCoins().collect {
                _coins.value = it
            }
        }
    }
}