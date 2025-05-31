package com.example.sportx.data.mapper

import com.example.sportx.data.dto.TennisFixtureResponseDto
import com.example.sportx.domain.model.fixture.TennisFixtureResponseModel


fun TennisFixtureResponseDto.mapTennisFixtureDtoToModel() : List<TennisFixtureResponseModel> {
    return result.mapNotNull {dto ->
        TennisFixtureResponseModel(
            event_date = dto.event_date ,
            event_final_result = dto.event_final_result ,
            event_first_player = dto.event_first_player ,
            event_first_player_logo = dto.event_first_player_logo ,
            event_second_player = dto.event_second_player ,
            event_second_player_logo = dto.event_second_player_logo ,
            league_key = dto.league_key
        )
    }
}