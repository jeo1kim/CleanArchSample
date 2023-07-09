package com.example.cleanarchsample.domain.use_case.get_coins

import com.example.cleanarchsample.common.Resource
import com.example.cleanarchsample.data.remote.dto.toCoin
import com.example.cleanarchsample.domain.model.Coin
import com.example.cleanarchsample.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try{
            emit(Resource.Loading<List<Coin>>())

            val coins = repository.getCoins().map { it.toCoin() }

            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "error"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>( "network error"))
        }
    }
}