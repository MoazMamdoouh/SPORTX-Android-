package com.example.sportx.domain.model.leagues

import com.example.sportx.data.dto.leagues.LeaguesDto


data class SportsResponseModel (
    val leagueName: String,
    val leagueKey: Int,
    val leagueLogo: String?
)

