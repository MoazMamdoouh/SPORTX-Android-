package com.example.sportx.data.remote

import android.util.Log
import com.example.sportx.data.dto.leagues.LeaguesDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class LeaguesRemoteDataSource private constructor(
    val api : Api = RetrofitService.api
) {
    suspend fun getSportLeagues(sport : String) : Flow<LeaguesDto>{
        return try {
           val response =  api.getAllFootballLeagues(sport)
            flowOf(response)
        }catch (e : Exception){
            Log.i("TAG", "getSportLeagues error is  ${e.message}")
            return flowOf()
        }
    }

    suspend fun getFootBallAndBasketBallFixture(sport: String , fromData : String , toData : String) : Flow<FixtureFootballAndBasketBallResponse>{
        return  try {
            val fixtureResponse
            = api.getFootBallAndBasketBallFixture(sport , fromData , toData )
            flowOf(fixtureResponse)
        }catch (e : Exception){
            Log.i("TAG", "getFootBallAndBasketBallFixture error is ${e.message} ")
            flowOf()
        }
    }

    companion object {
        private var INSTANCE: LeaguesRemoteDataSource? = null
        fun getInstance(
            api: Api
        ): LeaguesRemoteDataSource {
            return INSTANCE ?: synchronized(this) {
                val temp = LeaguesRemoteDataSource(api)
                INSTANCE = temp
                temp
            }
        }
    }

}