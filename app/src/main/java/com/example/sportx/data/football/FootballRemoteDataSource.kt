package com.example.sportx.data.football

import android.util.Log
import com.example.sportx.data.dto.FixtureDto
import com.example.sportx.data.dto.leagues.LeaguesResponseDto
import com.example.sportx.data.remote.Api
import com.example.sportx.data.remote.RetrofitService
import com.example.sportx.data.remote.SportXRemoteDataSourceX
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class FootballRemoteDataSource @Inject constructor (
     val api: Api
)  : SportXRemoteDataSourceX{
    override suspend fun getLeagues(sport: String): Flow<LeaguesResponseDto> {
        return try {
            val response =  api.getAllFootballLeagues(sport)
            flowOf(response)
        }catch (e : Exception){
            Log.i("TAG", "getSportLeagues error is  ${e.message}")
            return flowOf()
        }
    }

    override suspend fun getFixture(sport: String , leagueId :Int , from : String , to : String ): Flow<FixtureDto> {
        return try {
            val fixture = api.getFootballAndBasketballFixture(
                sport,
                from,
                to ,
                leagueId
            )
            flowOf(fixture)
        }catch (e : Exception){
            Log.i("TAG", "getFixture for football error ${e.message} ")
            flowOf()
        }
    }
}