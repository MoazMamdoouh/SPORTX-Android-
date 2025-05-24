package com.example.sportx.presentation.fixtures

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportx.data.dto.fixture.FixtureFootballAndBasketBallResponse
import com.example.sportx.domain.useCase.SportXUseCase
import com.example.sportx.utilities.UiStateResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FixtureViewModel(
    private val sportXUseCase: SportXUseCase
) : ViewModel() {

     private val _upComingMatches : MutableStateFlow<UiStateResult<FixtureFootballAndBasketBallResponse>>
     = MutableStateFlow(UiStateResult.Loading)

    val upComingMatches = _upComingMatches.asStateFlow()

    fun getUpComingMatches(sport : String){
        viewModelScope.launch {
            try {
                val upComingMatchesResponse
                = sportXUseCase.getFootBallAndBasketBallFixture(sport)
                _upComingMatches.collect(_upComingMatches)
            }catch (e : Exception){
                Log.i("TAG", "getUpComingMatches in view model error is ${e.message} ")
            }
        }
    }
}