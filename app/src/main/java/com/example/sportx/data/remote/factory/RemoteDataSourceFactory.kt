package com.example.sportx.data.remote.factory

import com.example.sportx.data.remote.Api
import com.example.sportx.data.remote.SportXRemoteDataSource
import com.example.sportx.data.remote.basketBall.BasketBallRemoteDataSource
import com.example.sportx.data.remote.cricket.CricketRemoteDataSource
import com.example.sportx.data.remote.football.FootballRemoteDataSource
import com.example.sportx.data.remote.tennIs.TennisRemoteDataSource

class RemoteDataSourceFactory {

    fun createRemoteDataSource(type : String) : SportXRemoteDataSource{
        when(type){
            "football" -> return FootballRemoteDataSource()
            "basketBall" -> return BasketBallRemoteDataSource()
            "cricket" -> return CricketRemoteDataSource()
            "tennis" -> return TennisRemoteDataSource()
            else -> return FootballRemoteDataSource()
        }
    }
}