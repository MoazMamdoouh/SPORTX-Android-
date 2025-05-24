package com.example.sportx.domain.useCase

import com.example.sportx.data.dto.fixture.FixtureFootballAndBasketBallResponse
import com.example.sportx.domain.model.leagues.SportsResponseModel
import kotlinx.coroutines.flow.Flow

interface SportXUseCase {
    suspend fun getSportLeagues(sport: String): List<SportsResponseModel>
    suspend fun getFootBallAndBasketBallFixture(
        sport: String, ): Flow<FixtureFootballAndBasketBallResponse>
}