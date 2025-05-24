package com.example.sportx.domain.model.leagues

import com.example.sportx.data.dto.leagues.SportsResponseDto


data class SportsResponseModel (
    val leagueName: String,
    val leagueKey: Int,
    val leagueLogo: String?
)

fun SportsResponseDto.mapToModelList(): List<SportsResponseModel> {
    return result.map { dto ->
        SportsResponseModel(
            leagueName = dto.league_name,
            leagueKey = dto.league_key,
            leagueLogo = dto.league_logo
        )
    }
}