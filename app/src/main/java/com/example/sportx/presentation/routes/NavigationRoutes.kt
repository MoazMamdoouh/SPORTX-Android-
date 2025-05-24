package com.example.sportx.presentation.routes

import kotlinx.serialization.Serializable


@Serializable
data object HomeScreen

@Serializable
data class LeaguesScreen (
        val sportType : String
        )