package com.example.sportx.data.repo

import com.example.sportx.domain.model.fixture.FixtureModel
import com.example.sportx.domain.model.fixture.FootballAndBasketballFixtureModel
import com.example.sportx.domain.model.leagues.LeaguesResponseModel
import com.example.sportx.domain.use_case.SPORTXRepo

class FakeSportXRepo : SPORTXRepo {

    val footballLeague  = listOf(
        LeaguesResponseModel(1 , "logo1" , "league1") ,
        LeaguesResponseModel(2 , "logo2" , "league2") ,
        )
    val basketballLeague = listOf(
        LeaguesResponseModel(1 , "logo1" , "league1") ,
        LeaguesResponseModel(2 , "logo2" , "league2") ,
    )

    val footballFixture = mutableListOf<FootballAndBasketballFixtureModel>()
    val basketballFixture = mutableListOf<FootballAndBasketballFixtureModel>()

    override suspend fun getSportLeagues(sport: String): List<LeaguesResponseModel> {
       return when(sport){
           "football" -> footballLeague
           "basketball" -> basketballLeague
           else -> emptyList()
       }
    }

    override suspend fun getSportFixture(sport: String, leagueId: Int): List<FixtureModel> {
        return when(sport){
            "football" -> footballFixture
            "basketball" -> basketballFixture
            else -> emptyList()
        }
    }
}