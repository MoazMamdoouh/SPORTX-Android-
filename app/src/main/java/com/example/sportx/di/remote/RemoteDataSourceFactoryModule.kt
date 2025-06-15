package com.example.sportx.di.remote

import com.example.sportx.data.remote.RemoteDataSourceFactory
import com.example.sportx.data.remote.RemoteDataSourceFactoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceFactoryModule {

    @Binds
    @Singleton
    abstract fun bindFactory(impl: RemoteDataSourceFactoryImpl): RemoteDataSourceFactory
}