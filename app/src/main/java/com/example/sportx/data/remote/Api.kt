package com.example.sportx.data.remote

import com.example.sportx.data.dto.fixture.FixtureFootballAndBasketBallResponse
import com.example.sportx.data.dto.leagues.SportsResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("/{sport}")
   suspend fun getAllFootballLeagues(
        @Path("sport") sport : String ,
        @Query("met") met : String = "Leagues" ,
        @Query("APIkey") apiKey: String = ApiKey.API_KEY
    ) : SportsResponseDto


    @GET("/{sport}")
    suspend fun getFootBallAndBasketBallFixture(
        @Path("sport") sport : String ,
        @Query("from") fromData : String ,
        @Query("to") toData : String,
        @Query("met") met : String = "Leagues" ,
        @Query("APIkey") apiKey: String = ApiKey.API_KEY
    ) : FixtureFootballAndBasketBallResponse
}