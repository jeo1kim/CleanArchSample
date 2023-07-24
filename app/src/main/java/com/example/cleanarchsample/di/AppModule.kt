package com.example.cleanarchsample.di

import com.example.cleanarchsample.common.Constants.BASE_URL
import com.example.cleanarchsample.data.remote.StockApi
import com.example.cleanarchsample.data.repository.StockRepositoryImpl
import com.example.cleanarchsample.domain.repository.StockRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * depedency injection module
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideStockApi(): StockApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(StockApi::class.java)

    @Provides
    @Singleton
    fun provideStockRepository(api: StockApi): StockRepository = StockRepositoryImpl(api)

//    @Provides
//    @Singleton
//    fun provideCoinApi(): CoinApi = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(CoinApi::class.java)
//
//    @Provides
//    @Singleton
//    fun provideCoinRepository(api: CoinApi): CoinRepository = CoinRepositoryImpl(api)

}