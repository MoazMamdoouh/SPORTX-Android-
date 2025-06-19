package com.example.sportx.presentation.fixtures

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.sportx.domain.model.fixture.FixtureModel
import com.example.sportx.domain.use_case.SPORTXRepo
import com.example.sportx.utilities.UiStateResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixtureViewModel @Inject constructor (
    private val sportXRepo: SPORTXRepo
) : ViewModel(){
    private val _sportsFixture
    : MutableStateFlow<UiStateResult<List<FixtureModel>>>
    = MutableStateFlow(UiStateResult.Loading)

    val sportsFixture = _sportsFixture.asStateFlow()

    fun getFootballFixture(leagueId : Int , sport : String ) {
        viewModelScope.launch {
            try {
                val fixtureResponse
                = sportXRepo.getSportFixture(sport , leagueId)
                _sportsFixture.emit(UiStateResult.Success(fixtureResponse))
            }catch (e : Exception){
                Log.i("TAG", "getFootballFixture in view model error in football ${e.message} ")
            }
        }
    }
}
