package com.example.sportx.presentation.factory

import androidx.lifecycle.ViewModel
import com.example.sportx.domain.useCase.SportXRepo

interface SportXFactory {
    fun createViewModel(sportXRepo: SportXRepo) : ViewModel
}