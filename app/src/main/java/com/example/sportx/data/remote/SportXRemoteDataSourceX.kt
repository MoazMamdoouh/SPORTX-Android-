package com.example.sportx.data.remote

import com.example.sportx.data.dto.fixture.FixtureDto
import com.example.sportx.data.dto.leagues.LeaguesResponseDto
import kotlinx.coroutines.flow.Flow

interface SportXRemoteDataSourceX {
    suspend fun getLeagues(sport : String) : Flow<LeaguesResponseDto>
    suspend fun getFixture(sport : String , leagueId : Int) : Flow<FixtureDto>
}