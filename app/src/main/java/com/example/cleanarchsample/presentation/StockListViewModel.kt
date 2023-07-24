package com.example.cleanarchsample.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchsample.common.Resource
import com.example.cleanarchsample.data.remote.dto.StockDto
import com.example.cleanarchsample.data.repository.StockRepositoryImpl
import com.example.cleanarchsample.domain.use_case.GetStocksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import retrofit2.HttpException
import javax.inject.Inject


@HiltViewModel
class StockListViewModel @Inject constructor(
    val stocksUseCase: GetStocksUseCase,
    val repositoryImpl: StockRepositoryImpl
) : ViewModel() {



    private val _state = mutableStateOf(StockListState())
    val state: State<StockListState> = _state


    init {
        getStocks()
    }

    fun getStocks() {
        stocksUseCase().onEach {

            when(it) {
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    _state.value = StockListState(data = it.data ?: emptyList())
                }
            }

        }.launchIn(viewModelScope)

    }
}