package com.example.sportx.data.football

import android.util.Log
import com.example.sportx.data.dto.fixture.FixtureDto
import com.example.sportx.data.dto.fixture.FootballOrBasketBallFixtureResponseDto
import com.example.sportx.data.dto.leagues.LeaguesResponseDto
import com.example.sportx.data.remote.Api
import com.example.sportx.data.remote.RetrofitService
import com.example.sportx.data.remote.SportXRemoteDataSourceX
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FootballRemoteDataSource (
    private val api: Api = RetrofitService.api
)  : SportXRemoteDataSourceX{
    override suspend fun getLeagues(sport: String): Flow<LeaguesResponseDto> {
        return try {
            val response =  api.getAllFootballLeagues(sport)
            flowOf(response)
        }catch (e : Exception){
            Log.i("TAG", "getSportLeagues error is  ${e.message}")
            return flowOf()
        }
    }

    override suspend fun getFixture(sport: String , leagueId :Int): Flow<FixtureDto> {
        return try {
            val fixture = api.getSportFixture(
                sport,
                "2025-05-2",
                "2025-05-15" ,
                leagueId
            )
            flowOf(fixture)
        }catch (e : Exception){
            Log.i("TAG", "getFixture for football error ${e.message} ")
            flowOf()
        }
    }
    companion object {
        private var INSTANCE: FootballRemoteDataSource? = null
        fun getInstance(
            api: Api
        ): FootballRemoteDataSource {
            return INSTANCE ?: synchronized(this) {
                val temp = FootballRemoteDataSource(api)
                INSTANCE = temp
                temp
            }
        }
    }
}