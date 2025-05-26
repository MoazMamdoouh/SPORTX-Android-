package com.example.sportx.data.dto.fixture.cricket

import com.google.gson.annotations.SerializedName

data class Scorecard(
    @SerializedName("Gloucestershire 2 INN")
    val gloucestershire2INN: List<Gloucestershire2INNXX>,

    @SerializedName("Somerset 1 INN")
    val somerset1INN: List<Somerset1INNXX>
)
