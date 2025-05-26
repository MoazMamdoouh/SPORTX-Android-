package com.example.sportx.data.remote

import com.example.sportx.data.dto.leagues.LeaguesDto
import kotlinx.coroutines.flow.Flow

interface SportXRemoteDataSource{

    suspend fun getSportLeague(sport : String ) : Flow<LeaguesDto>
    suspend fun getSportFixture(sport : String , fromData : String , toData : String ) : Flow<Any>
    suspend fun getSportTeamOrPlayer(teamOrPlayerId: Int) : Flow<Any>
}