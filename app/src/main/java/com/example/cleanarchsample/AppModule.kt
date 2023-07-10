package com.example.cleanarchsample

import com.example.cleanarchsample.common.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * depedency injection module
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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