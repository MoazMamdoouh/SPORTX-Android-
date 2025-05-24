package com.example.sportx.presentation.factory

import androidx.lifecycle.ViewModel
import com.example.sportx.domain.useCase.SportXUseCase
import com.example.sportx.presentation.leagues.LeaguesViewModel

class LeaguesFactory() : SportXFactory {

    override fun createViewModel(sportXUseCase: SportXUseCase): ViewModel {
         return LeaguesViewModel(sportXUseCase)
    }
}