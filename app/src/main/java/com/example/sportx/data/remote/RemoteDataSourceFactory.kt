package com.example.sportx.data.remote


interface RemoteDataSourceFactory {
    fun createRemoteDataSourceInstance(sport : String) : SportXRemoteDataSourceX
}