package com.example.sportx.data.remote.mappers

import com.example.sportx.data.dto.fixture.footballAndBasketBall.FootballAndBasketballFixtureDto
import com.example.sportx.domain.model.fixture.basketball.BasketballFixtureResponseModel
import com.example.sportx.domain.model.fixture.football.FootballFixtureResponseModel


fun FootballAndBasketballFixtureDto.mapFootballFixtureDtoToModel(): List<FootballFixtureResponseModel> {
    return result.map { dto ->
        FootballFixtureResponseModel(
            event_key = dto.event_key,
            event_date = dto.event_date,
            event_time = dto.event_time,
            event_home_team = dto.event_home_team,
            home_team_key = dto.home_team_key,
            event_away_team = dto.event_away_team,
            away_team_key = dto.away_team_key,
            event_final_result = dto.event_final_result,
            country_name = dto.country_name,
            league_name = dto.league_name,
            league_key = dto.league_key,
            home_team_logo = dto.home_team_logo,
            away_team_logo = dto.away_team_logo
        )
    }
}

fun FootballAndBasketballFixtureDto.mapBasketballFixtureDtoToModel(): List<BasketballFixtureResponseModel> {
    return result.map { dto ->
        BasketballFixtureResponseModel(
            event_key = dto.event_key,
            event_date = dto.event_date,
            event_time = dto.event_time,
            event_home_team = dto.event_home_team,
            home_team_key = dto.home_team_key,
            event_away_team = dto.event_away_team,
            away_team_key = dto.away_team_key,
            event_final_result = dto.event_final_result,
            country_name = dto.country_name,
            league_name = dto.league_name,
            league_key = dto.league_key,
            home_team_logo = dto.home_team_logo,
            away_team_logo = dto.away_team_logo
        )
    }
}