package com.example.sportx.data.dto.fixture

data class FootballOrBasketBallFixtureResponseDto(
    val result: List<Result>,
    val success: Int
) : FixtureDto