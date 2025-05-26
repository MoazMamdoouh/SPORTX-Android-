package com.example.sportx.data.dto.fixture.footballAndBasketBall

data class AwayTeam(
    val coaches: List<Coache>,
    val missing_players: List<Any>,
    val starting_lineups: List<StartingLineup>,
    val substitutes: List<Substitute>
)