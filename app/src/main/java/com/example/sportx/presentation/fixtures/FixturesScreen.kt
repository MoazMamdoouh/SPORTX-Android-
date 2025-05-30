package com.example.sportx.presentation.fixtures

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.sportx.domain.model.fixture.FootballAndBasketballFixtureModel
import com.example.sportx.utilities.UiStateResult


@Composable
fun FixtureScreen(fixtureViewModel: FixtureViewModel , leagueId : Int) {
    Log.i("fixture", " in FixtureScreen ")
    val footballFixture = fixtureViewModel.footballFixture.collectAsStateWithLifecycle().value

    LaunchedEffect(Unit) {
        fixtureViewModel.getFootballFixture(leagueId)
    }
    when(footballFixture){
        is UiStateResult.Failure -> {
            Log.i("fixture", "FixtureScreen: fail ")
        }
        UiStateResult.Loading -> {
            Log.i("fixture", "FixtureScreen loading ")
        }
        is UiStateResult.Success -> {
            Log.i("fixture", "FixtureScreen success ")
            Row {
                UpComingMatches(footballFixture.response)
            }
        }
    }

}
@Composable
fun UpComingMatches(response: List<FootballAndBasketballFixtureModel>) {

    LazyRow {
        itemsIndexed(response){ _ , matches ->
            UpComingMatchesCard(matches)
        }
    }
}
@Composable
fun UpComingMatchesCard(matches: FootballAndBasketballFixtureModel) {

    Log.i("fixture", "UpComingMatchesCard: ")
    Text(matches.event_final_result)

}
@Composable
fun LatestMatches() {
    LazyColumn {

    }
}

@Composable
fun LatestMatchesCard(){

}

