package com.example.sportx.data.repository

import com.example.sportx.data.remote.SportXRemoteDataSource
import com.example.sportx.domain.model.leagues.SportsResponseModel
import com.example.sportx.domain.model.leagues.mapSportsDtoToModel
import com.example.sportx.domain.use_case.SPORTXRepo
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class SPORTXRepoImpl private constructor(
   private val sportXRemoteDataSource : SportXRemoteDataSource
): SPORTXRepo {
    override suspend fun getSportLeagues(sport: String): List<SportsResponseModel> {
            return try {
               val response =  sportXRemoteDataSource.getSportLeagues(sport).map {
                           dto -> dto.mapSportsDtoToModel()
                   }.first()
                response
            }catch (e : Exception){
                println(e.message)
                return emptyList()
            }
    }

    companion object {
        private var INSTANCE: SPORTXRepoImpl? = null
        fun getInstance(
            sportXRemoteDataSource : SportXRemoteDataSource
        ): SPORTXRepoImpl {
            return INSTANCE ?: synchronized(this) {
                val temp = SPORTXRepoImpl(sportXRemoteDataSource)
                INSTANCE = temp
                temp
            }
        }
    }
}