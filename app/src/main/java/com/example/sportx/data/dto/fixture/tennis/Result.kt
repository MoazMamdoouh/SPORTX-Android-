package com.example.sportx.data.dto.fixture.tennis

data class Result(
    val country_name: String,
    val event_date: String,
    val event_final_result: String,
    val event_first_player: String,
    val event_first_player_logo: String,
    val event_game_result: String,
    val event_key: Int,
    val event_live: String,
    val event_qualification: String,
    val event_second_player: String,
    val event_second_player_logo: String,
    val event_serve: Any,
    val event_status: String,
    val event_time: String,
    val event_winner: String,
    val first_player_key: Int,
    val league_key: Int,
    val league_name: String,
    val league_round: String,
    val league_season: String,
    val pointbypoint: List<Any>,
    val scores: List<Score>,
    val second_player_key: Int,
    val statistics: List<Any>
)