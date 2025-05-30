package com.example.sportx.data.repository

import android.util.Log
import com.example.sportx.data.dto.fixture.FootballOrBasketBallFixtureResponseDto
import com.example.sportx.data.mapper.mapFootballAndBasketballFixtureDtoToModel
import com.example.sportx.data.mapper.mapSportsDtoToModel
import com.example.sportx.data.remote.SportXRemoteDataSource
import com.example.sportx.data.remote.SportXRemoteDataSourceX
import com.example.sportx.domain.model.fixture.FixtureModel
import com.example.sportx.domain.model.fixture.FootballAndBasketballFixtureModel
import com.example.sportx.domain.model.leagues.LeaguesResponseModel
import com.example.sportx.domain.use_case.SPORTXRepo
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class SPORTXRepoImpl private constructor(
   private val sportXRemoteDataSource : SportXRemoteDataSourceX
): SPORTXRepo {
    override suspend fun getSportLeagues(sport: String): List<LeaguesResponseModel> {
            return try {
               val leagues =  sportXRemoteDataSource.getLeagues(sport).map {
                           dto -> dto.mapSportsDtoToModel()
                   }.first()
                leagues
            }catch (e : Exception){
                println(e.message)
                return emptyList()
            }
    }

    override suspend fun getSportFixture(sport: String, leagueId: Int): List<FixtureModel> {
        return try {
            sportXRemoteDataSource.getFixture(sport, leagueId).first().let { fixtureDto ->
                when (fixtureDto) {
                    is FootballOrBasketBallFixtureResponseDto -> {
                        fixtureDto.mapFootballAndBasketballFixtureDtoToModel()
                    }
                    else -> {
                        Log.i("TAG", "Unknown DTO type: ${fixtureDto::class.simpleName}")
                        emptyList()
                    }
                }
            }
        } catch (e: Exception) {
            Log.i("TAG", "getSportFixture for $sport error is ${e.message}")
            emptyList()
        }
    }



    companion object {
        private var INSTANCE: SPORTXRepoImpl? = null
        fun getInstance(
            sportXRemoteDataSource : SportXRemoteDataSourceX
        ): SPORTXRepoImpl {
            return INSTANCE ?: synchronized(this) {
                val temp = SPORTXRepoImpl(sportXRemoteDataSource)
                INSTANCE = temp
                temp
            }
        }
    }
}