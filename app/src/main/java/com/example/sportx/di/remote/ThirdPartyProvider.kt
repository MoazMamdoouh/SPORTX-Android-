package com.example.sportx.di.remote

import com.example.sportx.data.remote.Api
import com.example.sportx.data.remote.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
class ThirdPartyProvider {

    @Provides
    fun retrofitBuilderProvider() : Retrofit {
        return RetrofitService.retrofit
    }

    @Provides
    fun apiProvider() : Api {
        return RetrofitService.api
    }
}