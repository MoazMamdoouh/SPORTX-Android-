package com.example.sportx.presentation.factory

import androidx.lifecycle.ViewModel
import com.example.sportx.domain.use_case.SportXUseCase
import com.example.sportx.presentation.leagues.LeaguesViewModel

class SportXFactory() {

    fun viewModelCreationFactory(type: String, useCase: SportXUseCase): ViewModel {
        when (type) {
             "leagues" -> return LeaguesViewModel(useCase)
            else -> return LeaguesViewModel(useCase)
        }
    }
}