package com.example.sportx.domain.useCase

import com.example.sportx.domain.model.leagues.SportsResponseModel
import kotlinx.coroutines.flow.Flow

interface SportXRepo {
    suspend fun getSportLeagues(sport: String): List<SportsResponseModel>
    suspend fun getLatestSportFixtureMatches(sport: String) : Flow<Any>
}