package com.example.sportx.data.remote

import com.example.sportx.data.dto.fixture.footballAndBasketBall.FootballAndBasketballFixtureDto
import com.example.sportx.data.dto.leagues.LeaguesDto
import com.example.sportx.data.dto.teamOrPlayer.basketBall.BasketballTeamResponseDto
import com.example.sportx.data.dto.teamOrPlayer.football.FootBallTeamResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("/{sport}")
   suspend fun getAllFootballLeagues(
        @Path("sport") sport : String ,
        @Query("met") met : String = "Leagues" ,
        @Query("APIkey") apiKey: String = ApiKey.API_KEY
    ) : LeaguesDto


    @GET("/{sport}")
    suspend fun getFootBallAndBasketBallFixture(
        @Path("sport") sport : String ,
        @Query("from") fromData : String ,
        @Query("to") toData : String,
        @Query("met") met : String = "Leagues" ,
        @Query("APIkey") apiKey: String = ApiKey.API_KEY
    ) : FootballAndBasketballFixtureDto

    @GET("football")
    suspend fun getFootBallTeam(
        @Query("teamId") teamId : Int ,
        @Query("met") met : String = "Teams" ,
        @Query("APIkey") apiKey: String = ApiKey.API_KEY
    ) : FootBallTeamResponseDto

    @GET("basketBall")
    suspend fun getBasketBallTeam(
        @Query("teamId") teamId : Int ,
        @Query("met") met : String = "Teams" ,
        @Query("APIkey") apiKey: String = ApiKey.API_KEY
    ) : BasketballTeamResponseDto
}