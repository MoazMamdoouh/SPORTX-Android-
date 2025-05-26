package com.example.sportx.data.remote.cricket

import com.example.sportx.data.dto.fixture.cricket.CricketFixturesDto
import com.example.sportx.data.dto.leagues.LeaguesDto
import com.example.sportx.data.dto.teamOrPlayer.cricket.CricketTeamResponseDto
import com.example.sportx.data.remote.Api
import com.example.sportx.data.remote.RetrofitService
import com.example.sportx.data.remote.SportXRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CricketRemoteDataSource(
    val api : Api = RetrofitService.api
) : SportXRemoteDataSource {
    override suspend fun getSportLeague(sport: String): Flow<LeaguesDto> {
        return flowOf()
    }

    override suspend fun getSportFixture(
        sport: String,
        fromData: String,
        toData: String
    ): Flow<CricketFixturesDto> {
        return flowOf()
    }

    override suspend fun getSportTeamOrPlayer(teamOrPlayerId: Int): Flow<CricketTeamResponseDto> {
        return flowOf()
    }
}