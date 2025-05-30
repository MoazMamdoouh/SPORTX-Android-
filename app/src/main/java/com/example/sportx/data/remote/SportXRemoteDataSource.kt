package com.example.sportx.data.remote

import android.util.Log
import com.example.sportx.data.dto.leagues.LeaguesResponseDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SportXRemoteDataSource private constructor(
    val api : Api = RetrofitService.api
) {
    suspend fun getSportLeagues(sport : String) : Flow<LeaguesResponseDto>{
        return try {
           val response =  api.getAllFootballLeagues(sport)
            flowOf(response)
        }catch (e : Exception){
            Log.i("TAG", "getSportLeagues error is  ${e.message}")
            return flowOf()
        }
    }

    companion object {
        private var INSTANCE: SportXRemoteDataSource? = null
        fun getInstance(
            api: Api
        ): SportXRemoteDataSource {
            return INSTANCE ?: synchronized(this) {
                val temp = SportXRemoteDataSource(api)
                INSTANCE = temp
                temp
            }
        }
    }

}