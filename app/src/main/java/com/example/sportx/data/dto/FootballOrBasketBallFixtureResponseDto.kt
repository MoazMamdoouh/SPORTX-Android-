package com.example.sportx.data.dto

import com.example.sportx.data.dto.fixture.footballAndBasketball.Result

data class FootballOrBasketBallFixtureResponseDto(
    val result: List<Result>,
    val success: Int
) : FixtureDto