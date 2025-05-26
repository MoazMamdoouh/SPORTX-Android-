package com.example.sportx.data.remote.football

import android.util.Log
import com.example.sportx.data.dto.leagues.LeaguesDto
import com.example.sportx.data.dto.teamOrPlayer.football.FootBallTeamResponseDto
import com.example.sportx.data.remote.Api
import com.example.sportx.data.remote.RetrofitService
import com.example.sportx.data.remote.SportXRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class FootballRemoteDataSource(
    val api : Api = RetrofitService.api
) : SportXRemoteDataSource {

    override suspend fun getSportLeague(sport: String): Flow<LeaguesDto> {
        return try {
            val response =  api.getAllFootballLeagues(sport)
            flowOf(response)
        }catch (e : Exception){
            Log.i("TAG", "getSportLeagues error is  ${e.message}")
            return flowOf()
        }
    }

    override suspend fun getSportFixture(
        sport: String,
        fromData: String,
        toData: String
    ): Flow<FixtureFootballAndBasketBallResponse> {
        return try {
            val fixtureResponse
            = api.getFootBallAndBasketBallFixture(
                sport , fromData , toData
            )
            flowOf(fixtureResponse)
        }catch (e : Exception){
            Log.i("TAG", "getSportFixture in football error is ${e.message} ")
            flowOf()
        }
    }

    override suspend fun getSportTeamOrPlayer(teamOrPlayerId: Int): Flow<FootBallTeamResponseDto> {
       return try {
           val footBallTeamResponse = api.getFootBallTeam(teamOrPlayerId)
           flowOf(footBallTeamResponse)
       }catch (e : Exception){
           Log.i("TAG", "getSportTeamOrPlayer football remote data source error ${e.message} ")
           flowOf()
       }
    }

}