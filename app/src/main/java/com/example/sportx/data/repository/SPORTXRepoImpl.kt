package com.example.sportx.data.repository

import android.util.Log
import com.example.sportx.data.remote.DateGenerator
import com.example.sportx.data.remote.factory.RemoteDataSourceFactory
import com.example.sportx.data.remote.mappers.mapToModelList
import com.example.sportx.domain.model.leagues.SportsResponseModel
import com.example.sportx.domain.useCase.SportXRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class SPORTXRepoImpl private constructor(
   private val remoteDataSourceFactory: RemoteDataSourceFactory ,

): SportXRepo {

    override suspend fun getSportLeagues(sport: String): List<SportsResponseModel> {
        val league = remoteDataSourceFactory.createRemoteDataSource(sport)
        return try {
               val response =  league.getSportLeague(sport)
                   .map {
                           dto -> dto.mapToModelList()
                   }
                   .catch { e -> Log.e("TAG", "Mapping failed: ${e.message}") }
                   .first()
                Log.i("TAG", "getSportLeagues remote response size ${response.size} ")
                response
            }catch (e : Exception){
                println(e.message)
                return emptyList()
            }
    }

    override suspend fun getLatestSportFixtureMatches(
        sport: String
    ): Flow<Any> {
        val fixtures = remoteDataSourceFactory.createRemoteDataSource(sport)
        val fixturesResponse : Any
        return try {
            fixturesResponse =  fixtures.getSportFixture(sport , DateGenerator.fromInPast() , DateGenerator.toInPast())
            fixturesResponse
        }catch (e : Exception){
            Log.i("TAG", "getFootBallAndBasketBallFixture in repo error is ${e.message} ")
            flowOf()
        }
    }

    companion object {
        private var INSTANCE: SPORTXRepoImpl? = null
        fun getInstance(
            remoteDataSourceFactory: RemoteDataSourceFactory
        ): SPORTXRepoImpl {
            return INSTANCE ?: synchronized(this) {
                val temp = SPORTXRepoImpl(remoteDataSourceFactory)
                INSTANCE = temp
                temp
            }
        }
    }
}