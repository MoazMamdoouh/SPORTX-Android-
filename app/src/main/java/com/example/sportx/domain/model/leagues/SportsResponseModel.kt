package com.example.sportx.domain.model.leagues

import android.util.Log
import com.example.sportx.data.dto.leagues.SportsResponseDto

data class SportsResponseModel(
    val league_key: Int,
    val league_logo: String,
    val league_name: String
)

fun SportsResponseDto.mapSportsDtoToModel() : List<SportsResponseModel> {
    Log.i("TAG", "Inside mapSportsDtoToModel, result size: ${result?.size}")
    return result?.mapNotNull { dto ->
        Log.i("TAG", "Mapping item: $dto")
        try {
            SportsResponseModel(
                league_key = dto.league_key ?: 0 ,
                league_name = dto.league_name ?: "",
                league_logo = dto.league_logo ?: ""
            )
        } catch (e: Exception) {
            Log.e("TAG", "Error mapping item: ${e.message}", e)
            null
        }
    } ?: emptyList()
}