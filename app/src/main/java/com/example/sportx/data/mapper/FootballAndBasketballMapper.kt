package com.example.sportx.data.mapper

import android.util.Log
import com.example.sportx.data.dto.FootballOrBasketBallFixtureResponseDto
import com.example.sportx.domain.model.fixture.FootballAndBasketballFixtureModel


fun FootballOrBasketBallFixtureResponseDto.mapFootballAndBasketballFixtureDtoToModel()
: List<FootballAndBasketballFixtureModel>{

    return result.mapNotNull { dto ->
        try {
            FootballAndBasketballFixtureModel(
                away_team_logo = dto.away_team_logo ,
                home_team_logo = dto.home_team_logo,
                event_away_team = dto.event_away_team ,
                event_home_team = dto.event_home_team ,
                event_date = dto.event_date ,
                event_time = dto.event_time ,
                event_final_result = dto.event_final_result
            )
        }catch (e : Exception){
            Log.i("TAG", " error in mapFootballAndBasketballFixtureDtoToModel ")
            null
        }
    }
}