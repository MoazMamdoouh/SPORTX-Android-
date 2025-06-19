package com.example.sportx.di.remote

import com.example.sportx.data.remote.SportXRemoteDataSourceX
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class SportXRemoteDataSourceModule {


    @Binds
    @Singleton
    @FootballRemoteDataSource
    abstract fun footballRemoteDataSource(
        footballRemoteDataSource: com.example.sportx.data.football.FootballRemoteDataSource
    ): SportXRemoteDataSourceX

    @Binds
    @Singleton
    @BasketballRemoteDataSource
    abstract fun basketballRemoteDataSource(
        basketballRemoteDataSource: com.example.sportx.data.basketball.BasketballRemoteDataSource
    ): SportXRemoteDataSourceX


    //abstract fun cricketRemoteDataSource(): SportXRemoteDataSourceX
    //abstract fun tennisRemoteDataSource(): SportXRemoteDataSourceX
}