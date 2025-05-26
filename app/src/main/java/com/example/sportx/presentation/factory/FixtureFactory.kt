package com.example.sportx.presentation.factory

import androidx.lifecycle.ViewModel
import com.example.sportx.domain.useCase.SportXRepo
import com.example.sportx.presentation.fixtures.FixtureViewModel

class FixtureFactory : SportXFactory {
    override fun createViewModel(sportXRepo: SportXRepo): ViewModel {
        return FixtureViewModel(sportXRepo)
    }
}