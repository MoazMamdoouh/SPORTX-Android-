package com.example.sportx.data.dto.fixture.cricket

import com.google.gson.annotations.SerializedName

data class Extra(
    @SerializedName("Gloucestershire 2 INN")
    val gloucestershire2INN: Gloucestershire2INNX,

    @SerializedName("Somerset 1 INN")
    val somerset1INN: Somerset1INNX
)
