package com.example.sportx.data.repository

import android.util.Log
import com.example.sportx.data.dto.fixture.FixtureFootballAndBasketBallResponse
import com.example.sportx.data.remote.SportXRemoteDataSource
import com.example.sportx.domain.model.leagues.SportsResponseModel
import com.example.sportx.domain.model.leagues.mapToModelList
import com.example.sportx.domain.useCase.SportXRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class SPORTXRepoImpl private constructor(
   private val sportXRemoteDataSource : SportXRemoteDataSource
): SportXRepo {
    override suspend fun getSportLeagues(sport: String): List<SportsResponseModel> {
            return try {
               val response =  sportXRemoteDataSource.getSportLeagues(sport)
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

    override suspend fun getFootBallAndBasketBallFixture(
        sport: String
    ): Flow<FixtureFootballAndBasketBallResponse> {
        return try {
            val fixturesResponse
            = sportXRemoteDataSource.getFootBallAndBasketBallFixture(sport , "2025-05-01" , "2025-05-28")
            fixturesResponse
        }catch (e : Exception){
            Log.i("TAG", "getFootBallAndBasketBallFixture in repo error is ${e.message} ")
            flowOf()
        }
    }

    companion object {
        private var INSTANCE: SPORTXRepoImpl? = null
        fun getInstance(
            sportXRemoteDataSource : SportXRemoteDataSource
        ): SPORTXRepoImpl {
            return INSTANCE ?: synchronized(this) {
                val temp = SPORTXRepoImpl(sportXRemoteDataSource)
                INSTANCE = temp
                temp
            }
        }
    }
}