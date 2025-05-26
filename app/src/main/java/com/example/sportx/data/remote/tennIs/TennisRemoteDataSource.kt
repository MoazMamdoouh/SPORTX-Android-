package com.example.sportx.data.remote.tennIs

import com.example.sportx.data.dto.fixture.tennis.TennisFixtureDto
import com.example.sportx.data.dto.leagues.LeaguesDto
import com.example.sportx.data.dto.teamOrPlayer.tennis.TennisPlayerResponseDto
import com.example.sportx.data.remote.Api
import com.example.sportx.data.remote.RetrofitService
import com.example.sportx.data.remote.SportXRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TennisRemoteDataSource(
    val api : Api = RetrofitService.api
) : SportXRemoteDataSource {
    override suspend fun getSportLeague(sport: String): Flow<LeaguesDto> {
       return flowOf()
    }

    override suspend fun getSportFixture(
        sport: String,
        fromData: String,
        toData: String
    ): Flow<TennisFixtureDto> {
        return flowOf()
    }

    override suspend fun getSportTeamOrPlayer(teamOrPlayerId: Int): Flow<TennisPlayerResponseDto> {
        return flowOf()
    }
}