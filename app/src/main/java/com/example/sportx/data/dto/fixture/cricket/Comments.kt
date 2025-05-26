package com.example.sportx.data.dto.fixture.cricket

import com.google.gson.annotations.SerializedName

data class Comments(
    @SerializedName("Gloucestershire 2INN")
    val gloucestershire2INN: List<Gloucestershire2INN>,

    @SerializedName("Somerset 1INN")
    val somerset1INN: List<Somerset1INN>
)
