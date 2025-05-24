package com.example.sportx.presentation.leagues

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.sportx.domain.model.leagues.SportsResponseModel
import com.example.sportx.domain.use_case.SportXUseCase
import com.example.sportx.utilities.UiStateResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LeaguesViewModel(
    private val sportXUseCase : SportXUseCase
) : ViewModel() {

    private val _leagues : MutableStateFlow<UiStateResult<List<SportsResponseModel>>>
            = MutableStateFlow(UiStateResult.Loading)
    val leagues = _leagues.asStateFlow()

    fun getSportLeagues(sport : String){
        viewModelScope.launch {
           try {
               val response = sportXUseCase.getSportLeagues(sport)
               _leagues.emit(UiStateResult.Success(response))
           }catch (e : Exception){
               Log.i("TAG", "getSportLeagues in view model ${e.message} ")
               _leagues.emit(UiStateResult.Failure(e))
           }
        }
    }
}

class LeaguesFactory(val sportXUseCase : SportXUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LeaguesViewModel(sportXUseCase) as T
    }
}