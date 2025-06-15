package com.example.sportx.data.repository

import DateUtil
import android.util.Log
import com.example.sportx.data.dto.FootballOrBasketBallFixtureResponseDto
import com.example.sportx.data.dto.TennisFixtureResponseDto
import com.example.sportx.data.mapper.mapFootballAndBasketballFixtureDtoToModel
import com.example.sportx.data.mapper.mapSportsDtoToModel
import com.example.sportx.data.mapper.mapTennisFixtureDtoToModel
import com.example.sportx.data.remote.RemoteDataSourceFactory
import com.example.sportx.data.remote.SportXRemoteDataSourceX
import com.example.sportx.domain.model.fixture.FixtureModel
import com.example.sportx.domain.model.leagues.LeaguesResponseModel
import com.example.sportx.domain.use_case.SPORTXRepo
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SPORTXRepoImpl @Inject constructor(
    private val remoteDataSourceFactory: RemoteDataSourceFactory
): SPORTXRepo {

    override suspend fun getSportLeagues(sport: String): List<LeaguesResponseModel> {
            return try {
               val dataSource = remoteDataSourceFactory.createRemoteDataSourceInstance(sport)
               val leagues =  dataSource.getLeagues(sport).map {
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
            val dataSource = remoteDataSourceFactory.createRemoteDataSourceInstance(sport)
            dataSource.getFixture(sport, leagueId , DateUtil.getDate7DaysAgo() , DateUtil.getDateIn7Days()).first().let { fixtureDto ->
                when (fixtureDto) {
                    is FootballOrBasketBallFixtureResponseDto -> {
                        fixtureDto.mapFootballAndBasketballFixtureDtoToModel()
                    }
                    is TennisFixtureResponseDto -> {
                        fixtureDto.mapTennisFixtureDtoToModel()
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

}