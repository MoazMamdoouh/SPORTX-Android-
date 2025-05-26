package com.example.sportx.domain.model.fixture.basketball

data class BasketballFixtureResponseModel(
    val event_key: Int,
    val event_date: String,
    val event_time: String,
    val event_home_team: String,
    val home_team_key: Int,
    val event_away_team: String,
    val away_team_key: Int,
    val event_final_result: String,
    val country_name: String,
    val league_name: String,
    val league_key: Int,
    val home_team_logo: String,
    val away_team_logo: String,
)
