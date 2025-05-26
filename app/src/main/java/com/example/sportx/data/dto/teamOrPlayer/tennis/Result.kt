package com.example.sportx.data.dto.teamOrPlayer.tennis

data class Result(
    val player_bday: String,
    val player_country: String,
    val player_key: Int,
    val player_logo: String,
    val player_name: String,
    val stats: List<Stat>,
    val tournaments: List<Tournament>
)