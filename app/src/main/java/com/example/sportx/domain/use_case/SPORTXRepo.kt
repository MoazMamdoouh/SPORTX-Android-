package com.example.sportx.domain.use_case

import com.example.sportx.domain.model.leagues.SportsResponseModel

interface SPORTXRepo {

    suspend fun getSportLeagues(sport : String) : List<SportsResponseModel>
}