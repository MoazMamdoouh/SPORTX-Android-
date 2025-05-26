package com.example.sportx.data.remote.basketBall

import android.util.Log
import com.example.sportx.data.dto.fixture.footballAndBasketBall.FootballAndBasketballFixtureDto
import com.example.sportx.data.dto.leagues.LeaguesDto
import com.example.sportx.data.dto.teamOrPlayer.basketBall.BasketballTeamResponseDto
import com.example.sportx.data.remote.Api
import com.example.sportx.data.remote.RetrofitService
import com.example.sportx.data.remote.SportXRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class BasketBallRemoteDataSource(
    private val api : Api = RetrofitService.api
) : SportXRemoteDataSource{
    override suspend fun getSportLeague(sport: String): Flow<LeaguesDto> {
        return try {
            val response =  api.getAllFootballLeagues(sport)
            flowOf(response)
        }catch (e : Exception){
            Log.i("TAG", "getSportLeagues basketBall error is  ${e.message}")
            return flowOf()
        }
    }

    override suspend fun getSportFixture(
        sport: String,
        fromData: String,
        toData: String
    ): Flow<FootballAndBasketballFixtureDto> {
        return try {
            val fixtureResponse
                    = api.getFootBallAndBasketBallFixture(
                sport , fromData , toData
            )
            flowOf(fixtureResponse)
        }catch (e : Exception){
            Log.i("TAG", "getSportFixture in basketBall error is ${e.message} ")
            flowOf()
        }
    }

    override suspend fun getSportTeamOrPlayer(teamOrPlayerId: Int): Flow<BasketballTeamResponseDto> {
        return try {
            val basketBallResponse = api.getBasketBallTeam(teamOrPlayerId)
            flowOf(basketBallResponse)
        }catch (e : Exception){
            Log.i("TAG", "getSportTeamOrPlayer in basketBall error is ${e.message} ")
            flowOf()
        }
    }
}