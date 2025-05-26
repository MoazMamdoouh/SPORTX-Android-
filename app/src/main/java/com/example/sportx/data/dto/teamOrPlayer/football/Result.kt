package com.example.sportx.data.dto.teamOrPlayer.football

data class Result(
    val coaches: List<Coache>,
    val players: List<Player>,
    val team_key: Int,
    val team_logo: String,
    val team_name: String
)