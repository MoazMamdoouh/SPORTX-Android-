package com.example.sportx.data.dto

import com.example.sportx.data.dto.fixture.tennis.Result

data class TennisFixtureResponseDto(
    val result: List<Result>,
    val success: Int
) : FixtureDto