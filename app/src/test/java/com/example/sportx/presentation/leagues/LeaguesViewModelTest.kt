package com.example.sportx.presentation.leagues

import androidx.compose.runtime.collectAsState
import com.example.sportx.data.repo.FakeSportXRepo
import com.example.sportx.domain.use_case.SPORTXRepo
import com.example.sportx.utilities.UiStateResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`

class LeaguesViewModelTest{

    lateinit var leaguesViewModel : LeaguesViewModel
    lateinit var repo : SPORTXRepo

    @Before
    fun setUp(){
        repo = FakeSportXRepo()
        leaguesViewModel = LeaguesViewModel(repo)
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `get sport leagues for football and return success`() = runTest {
        //given

        //when
         leaguesViewModel.getSportLeagues("football")
        advanceUntilIdle()
        val expected = UiStateResult.Success((repo as FakeSportXRepo).footballLeague)
        val actual = leaguesViewModel.leagues.value
        //then
        assertThat(actual , `is`(expected))
    }
}