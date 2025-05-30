package com.example.sportx.presentation.leagues

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.sportx.domain.model.leagues.LeaguesResponseModel
import com.example.sportx.domain.use_case.SPORTXRepo
import com.example.sportx.utilities.UiStateResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LeaguesViewModel(
    private val sportXRepo : SPORTXRepo
) : ViewModel() {

    private val _leagues : MutableStateFlow<UiStateResult<List<LeaguesResponseModel>>>
            = MutableStateFlow(UiStateResult.Loading)
    val leagues = _leagues.asStateFlow()

    fun getSportLeagues(sport : String){
        viewModelScope.launch {
           try {
               val response = sportXRepo.getSportLeagues(sport)
               _leagues.emit(UiStateResult.Success(response))
           }catch (e : Exception){
               Log.i("TAG", "getSportLeagues in view model ${e.message} ")
               _leagues.emit(UiStateResult.Failure(e))
           }
        }
    }
}


class LeaguesFactory(val  sportXRepo : SPORTXRepo ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LeaguesViewModel(sportXRepo) as T
    }
}