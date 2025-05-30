package com.example.sportx.domain.model.fixture

data class FootballAndBasketballFixtureModel(
    val away_team_logo: String,
    val home_team_logo: String,
    val event_home_team: String ,
    val event_away_team: String ,
    val event_date: String,
    val event_time: String ,
    val event_final_result: String
) : FixtureModel
