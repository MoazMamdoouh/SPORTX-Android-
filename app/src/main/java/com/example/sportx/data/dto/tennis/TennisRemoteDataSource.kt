package com.example.sportx.data.dto.tennis

import android.util.Log
import com.example.sportx.data.dto.FixtureDto
import com.example.sportx.data.dto.leagues.LeaguesResponseDto
import com.example.sportx.data.remote.Api
import com.example.sportx.data.remote.RetrofitService
import com.example.sportx.data.remote.SportXRemoteDataSourceX
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TennisRemoteDataSource(
    private val api : Api = RetrofitService.api
) : SportXRemoteDataSourceX {
    override suspend fun getLeagues(sport: String): Flow<LeaguesResponseDto> {
        return try {
            val response = api.getAllFootballLeagues(sport)
            flowOf(response)
        }catch (e : Exception){
            Log.i("TAG", "getLeagues error in tennis ${e.message} ")
            flowOf()
        }
    }

    override suspend fun getFixture(
        sport: String,
        leagueId: Int,
        from: String,
        to: String
    ): Flow<FixtureDto> {
       return try {
           val tennisFixture = api.getTennisFixture(sport ,  from , to , leagueId)
           flowOf(tennisFixture)
       }catch (e : Exception){
           Log.i("TAG", "getFixture tennis error is ${e.message} ")
           flowOf()
       }
    }

    companion object {
        private var INSTANCE: TennisRemoteDataSource? = null
        fun getInstance(
            api: Api
        ): TennisRemoteDataSource {
            return INSTANCE ?: synchronized(this) {
                val temp = TennisRemoteDataSource(api)
                INSTANCE = temp
                temp
            }
        }
    }
}