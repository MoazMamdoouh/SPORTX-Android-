package com.example.sportx.data.remote

import com.example.sportx.di.remote.BasketballRemoteDataSource
import com.example.sportx.di.remote.FootballRemoteDataSource
import javax.inject.Inject

class RemoteDataSourceFactoryImpl @Inject constructor(
    @FootballRemoteDataSource private val football : SportXRemoteDataSourceX ,
    @BasketballRemoteDataSource private val basketball : SportXRemoteDataSourceX
) : RemoteDataSourceFactory {

    override fun createRemoteDataSourceInstance(sport: String): SportXRemoteDataSourceX {
       return when(sport) {
           "football" -> football
           "basketball" -> basketball
           else -> {
                throw IllegalArgumentException("Unsupported sport: $sport")
           }
        }
    }
}