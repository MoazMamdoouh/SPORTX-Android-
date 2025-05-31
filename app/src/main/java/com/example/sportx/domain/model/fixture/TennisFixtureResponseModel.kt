package com.example.sportx.domain.model.fixture

data class TennisFixtureResponseModel(
    val event_date: String,
    val event_final_result: String,
    val event_first_player: String,
    val event_first_player_logo: String,
    val league_key: Int,
    val event_second_player: String,
    val event_second_player_logo: String,

) : FixtureModel
