package com.example.sportx.data.mapper

import android.util.Log
import com.example.sportx.data.dto.leagues.LeaguesResponseDto
import com.example.sportx.domain.model.leagues.LeaguesResponseModel


fun LeaguesResponseDto.mapSportsDtoToModel() : List<LeaguesResponseModel> {
    Log.i("TAG", "Inside mapSportsDtoToModel, result size: ${result.size}")
    return result.mapNotNull { dto ->
        Log.i("TAG", "Mapping item: $dto")
        try {
            LeaguesResponseModel(
                league_key = dto.league_key ,
                league_name = dto.league_name ,
                league_logo = dto.league_logo ?:"" ,

                )
        } catch (e: Exception) {
            Log.e("TAG", "Error mapping item: ${e.message}", e)
            null
        }
    }
}