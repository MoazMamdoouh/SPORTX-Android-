package com.example.sportx.data.remote

import com.example.sportx.data.dto.fixture.FixtureDto
import com.example.sportx.data.dto.fixture.FootballOrBasketBallFixtureResponseDto
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
    suspend fun getSportFixture(
        @Path("sport") sport : String ,
        @Query("from") fromData : String ,
        @Query("to") toData : String,
        @Query("league_id") leagueId : Int ,
        @Query("met") met : String = "Fixtures" ,
        @Query("APIkey") apiKey: String = ApiKey.API_KEY
    ) : FootballOrBasketBallFixtureResponseDto
}