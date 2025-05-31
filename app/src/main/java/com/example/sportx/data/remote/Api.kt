package com.example.sportx.data.remote

import com.example.sportx.data.dto.FootballOrBasketBallFixtureResponseDto
import com.example.sportx.data.dto.TennisFixtureResponseDto
import com.example.sportx.data.dto.leagues.LeaguesResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("/{sport}")
   suspend fun getAllFootballLeagues(
        @Path("sport") sport : String ,
        @Query("met") met : String = "Leagues" ,
        @Query("APIkey") apiKey: String = ApiKey.API_KEY
    ) : LeaguesResponseDto


    @GET("/{sport}")
    suspend fun getFootballAndBasketballFixture(
        @Path("sport") sport : String ,
        @Query("from") fromData : String ,
        @Query("to") toData : String,
        @Query("leagueId") leagueId : Int ,
        @Query("met") met : String = "Fixtures" ,
        @Query("APIkey") apiKey: String = ApiKey.API_KEY
    ) : FootballOrBasketBallFixtureResponseDto

    @GET("/{sport}")
    suspend fun getTennisFixture(
        @Path("sport") sport : String ,
        @Query("from") fromData : String ,
        @Query("to") toData : String,
        @Query("leagueId") leagueId : Int ,
        @Query("met") met : String = "Fixtures" ,
        @Query("APIkey") apiKey: String = ApiKey.API_KEY
    ) : TennisFixtureResponseDto
}