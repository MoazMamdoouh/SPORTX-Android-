package com.example.sportx.domain.useCase

import android.util.Log
import com.example.sportx.data.dto.fixture.FixtureFootballAndBasketBallResponse
import com.example.sportx.domain.model.leagues.SportsResponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SportXUseCaseImpl(
    private val sportXRepo: SportXRepo
) : SportXUseCase {
    override suspend fun getSportLeagues(sport: String): List<SportsResponseModel> {
            return try {
               val leaguesResponse =  sportXRepo.getSportLeagues(sport)
                leaguesResponse
            }catch (e : Exception){
                Log.i("TAG", "getSportLeagues use case error is ${e.message} ")
                emptyList()
            }
    }

    override suspend fun getFootBallAndBasketBallFixture(
        sport: String,
    ): Flow<FixtureFootballAndBasketBallResponse> {
        return try {
            val fixturesResponse = sportXRepo.getFootBallAndBasketBallFixture(sport)
            fixturesResponse
        }catch (e : Exception){
            Log.i("TAG", "getFootBallAndBasketBallFixture in useCase error is ${e.message} ")
            flowOf()
        }
    }
}