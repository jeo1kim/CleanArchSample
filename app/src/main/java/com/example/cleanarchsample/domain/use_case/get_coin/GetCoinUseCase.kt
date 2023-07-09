package com.example.cleanarchsample.domain.use_case.get_coin

import com.example.cleanarchsample.common.Resource
import com.example.cleanarchsample.data.remote.dto.toCoinDetail
import com.example.cleanarchsample.domain.model.CoinDetails
import com.example.cleanarchsample.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try{
            emit(Resource.Loading<CoinDetails>())

            val coin = repository.getCoinById(coinId).toCoinDetail()

            emit(Resource.Success<CoinDetails>(coin))

        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetails>(e.localizedMessage ?: "error"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetails>( "network error"))
        }
    }
}