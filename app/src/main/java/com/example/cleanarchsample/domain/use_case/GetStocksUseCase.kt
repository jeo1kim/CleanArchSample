package com.example.cleanarchsample.domain.use_case

import com.example.cleanarchsample.common.Resource
import com.example.cleanarchsample.data.remote.dto.StockDto
import com.example.cleanarchsample.domain.repository.StockRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetStocksUseCase @Inject constructor(
    val repository: StockRepository
) {

    operator fun invoke(): Flow<Resource<List<StockDto>>> = flow {

        try {

            emit(Resource.Loading())

            val stocks = repository.getStock()

            emit(Resource.Success(stocks))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage))
        }
    }

}