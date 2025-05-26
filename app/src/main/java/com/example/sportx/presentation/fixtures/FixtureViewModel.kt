package com.example.sportx.presentation.fixtures

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportx.domain.useCase.SportXRepo
import com.example.sportx.utilities.UiStateResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FixtureViewModel(
    private val sportXRepo: SportXRepo
) : ViewModel() {

     private val _upComingMatches : MutableStateFlow<UiStateResult<Any>>
     = MutableStateFlow(UiStateResult.Loading)

    val upComingMatches = _upComingMatches.asStateFlow()

    fun getUpComingMatches(sport : String){
        viewModelScope.launch {
            try {
                val upComingMatchesResponse
                = sportXRepo.getLatestSportFixtureMatches(sport)
                _upComingMatches.emit(UiStateResult.Success(upComingMatchesResponse))
            }catch (e : Exception){
                Log.i("TAG", "getUpComingMatches in view model error is ${e.message} ")
            }
        }
    }
}