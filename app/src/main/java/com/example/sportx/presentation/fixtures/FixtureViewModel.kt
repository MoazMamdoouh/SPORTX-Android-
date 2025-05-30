package com.example.sportx.presentation.fixtures

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.sportx.domain.model.fixture.FootballAndBasketballFixtureModel
import com.example.sportx.domain.use_case.SPORTXRepo
import com.example.sportx.utilities.UiStateResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FixtureViewModel (
    private val sportXRepo: SPORTXRepo
) : ViewModel(){
    private val _footballFixture
    : MutableStateFlow<UiStateResult<List<FootballAndBasketballFixtureModel>>>
    = MutableStateFlow(UiStateResult.Loading)

    val footballFixture = _footballFixture.asStateFlow()

    fun getFootballFixture(leagueId : Int) {
        viewModelScope.launch {
            try {
                val fixtureResponse
                = sportXRepo.getSportFixture("football" , leagueId) as List<FootballAndBasketballFixtureModel>
                _footballFixture.emit(UiStateResult.Success(fixtureResponse))
            }catch (e : Exception){
                Log.i("TAG", "getFootballFixture in view model error in football ${e.message} ")
            }
        }
    }
}

class FixtureFactory(val  sportXRepo : SPORTXRepo ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FixtureViewModel(sportXRepo) as T
    }
}