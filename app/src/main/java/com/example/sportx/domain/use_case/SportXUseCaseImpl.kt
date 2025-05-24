package com.example.sportx.domain.use_case


import com.example.sportx.domain.model.leagues.SportsResponseModel

class SportXUseCaseImpl(
    val sportXRepo : SPORTXRepo
) : SportXUseCase {
    override suspend fun getSportLeagues(sport: String): List<SportsResponseModel> {
        return  try {
             sportXRepo.getSportLeagues(sport)
        }catch (e : Exception){
            println(e.message)
            emptyList()
        }
    }
}