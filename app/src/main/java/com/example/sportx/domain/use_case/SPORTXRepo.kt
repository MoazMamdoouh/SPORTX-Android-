package com.example.sportx.domain.use_case

import com.example.sportx.domain.model.fixture.FixtureModel
import com.example.sportx.domain.model.leagues.LeaguesResponseModel

interface SPORTXRepo {

    suspend fun getSportLeagues(sport : String) : List<LeaguesResponseModel>
    suspend fun getSportFixture(sport : String , leagueId : Int) : List<FixtureModel>
}