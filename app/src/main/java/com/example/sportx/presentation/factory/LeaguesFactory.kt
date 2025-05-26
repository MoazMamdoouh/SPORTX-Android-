package com.example.sportx.presentation.factory

import androidx.lifecycle.ViewModel
import com.example.sportx.domain.useCase.SportXRepo
import com.example.sportx.presentation.leagues.LeaguesViewModel
import com.example.sportx.presentation.routes.FixtureScreen

class LeaguesFactory() : SportXFactory {


    override fun createViewModel(sportXRepo: SportXRepo): ViewModel {
         return LeaguesViewModel(sportXRepo)
    }
}