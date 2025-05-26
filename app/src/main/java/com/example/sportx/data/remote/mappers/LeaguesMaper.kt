package com.example.sportx.data.remote.mappers

import com.example.sportx.data.dto.leagues.LeaguesDto
import com.example.sportx.domain.model.leagues.SportsResponseModel

fun LeaguesDto.mapToModelList(): List<SportsResponseModel> {
    return result.map { dto ->
        SportsResponseModel(
            leagueName = dto.league_name,
            leagueKey = dto.league_key,
            leagueLogo = dto.league_logo
        )
    }
}