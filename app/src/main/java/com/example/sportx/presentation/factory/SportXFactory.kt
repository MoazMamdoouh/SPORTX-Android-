package com.example.sportx.presentation.factory

import androidx.lifecycle.ViewModel
import com.example.sportx.domain.useCase.SportXUseCase

interface SportXFactory {
    fun createViewModel(sportXUseCase: SportXUseCase) : ViewModel
}