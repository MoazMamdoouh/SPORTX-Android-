package com.example.sportx.presentation.fixtures

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.sportx.R
import com.example.sportx.domain.model.fixture.FootballAndBasketballFixtureModel
import com.example.sportx.domain.model.fixture.TennisFixtureResponseModel
import com.example.sportx.utilities.UiStateResult


@Composable
fun FixtureScreen(
    leagueId: Int, sport: String,
    footballFixtureViewModel: FixtureViewModel = viewModel(),
    basketballFixtureViewModel: FixtureViewModel = viewModel(),
    tennisFixtureViewModel: FixtureViewModel = viewModel(),
) {

    val fixture = footballFixtureViewModel.sportsFixture.collectAsStateWithLifecycle().value


    LaunchedEffect(Unit) {
        when (sport) {
            "football" -> {
                footballFixtureViewModel.getFootballFixture(leagueId, sport)
            }

            "basketball" -> {
                basketballFixtureViewModel.getFootballFixture(leagueId, sport)
            }

            "tennis" -> {
                tennisFixtureViewModel.getFootballFixture(leagueId, sport)
            }
        }

    }
    when (sport) {
        "football" -> {
            fixture as UiStateResult<List<FootballAndBasketballFixtureModel>>
            FootballAndBasketballFixture(fixture)
        }

        "basketball" -> {
            fixture as UiStateResult<List<FootballAndBasketballFixtureModel>>
            FootballAndBasketballFixture(fixture)
        }

        "tennis" -> {
            fixture as UiStateResult<List<TennisFixtureResponseModel>>
            TennisFixture(fixture)
        }
    }

}

@Composable
fun FootballAndBasketballFixture(fixture: UiStateResult<List<FootballAndBasketballFixtureModel>>) {
    when (fixture) {
        is UiStateResult.Failure -> {
            Log.i("fixture", "FixtureScreen: fail ")
        }

        UiStateResult.Loading -> {
            Log.i("fixture", "FixtureScreen loading ")
        }

        is UiStateResult.Success -> {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    "Up Coming Matches",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(15.dp)
                )
                UpComingMatches(fixture.response)
                Text(
                    " Finished Matches",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(15.dp)
                )
                FinishedMatches(fixture.response)
            }
        }
    }
}

@Composable
fun FinishedMatches(response: List<FootballAndBasketballFixtureModel>) {
    LazyColumn {
        itemsIndexed(response) { _, match ->
            FinishedMatchesCard(match)
        }
    }
}

@Composable
fun FinishedMatchesCard(matches: FootballAndBasketballFixtureModel) {

    Log.i("status", " statues ${matches.event_final_result} ")
    if (matches.event_final_result != "_") {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .padding(vertical = 10.dp)
                .height(200.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            onClick = {
            }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    AsyncImage(
                        model = matches.home_team_logo,
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(15.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Fit,
                        placeholder = painterResource(id = R.drawable.broken_image),
                        error = painterResource(id = R.drawable.broken_image)
                    )
                    Text(
                        text = matches.event_home_team,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .padding(15.dp)
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center
                    )
                }
                Column {
                    Text(
                        matches.event_final_result,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        matches.event_date,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center
                    )
                }
                Column {
                    AsyncImage(
                        model = matches.away_team_logo,
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(15.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Fit,
                        placeholder = painterResource(id = R.drawable.broken_image),
                        error = painterResource(id = R.drawable.broken_image)
                    )
                    Text(
                        matches.event_away_team,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center
                    )
                }
            }

        }
    }
}


@Composable
fun UpComingMatches(response: List<FootballAndBasketballFixtureModel>) {

    LazyRow {
        itemsIndexed(response) { _, matches ->
            UpComingMatchesCard(matches)
        }
    }
}

@Composable
fun UpComingMatchesCard(matches: FootballAndBasketballFixtureModel) {

    Log.i("status", " statues ${matches.event_final_result} ")
    if (matches.event_final_result == "_") {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .padding(vertical = 10.dp)
                .height(200.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            onClick = {
            }
        ) {
            Column {
                Row {
                    AsyncImage(
                        model = matches.home_team_logo,
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(15.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Fit,
                        placeholder = painterResource(id = R.drawable.broken_image),
                        error = painterResource(id = R.drawable.broken_image)
                    )
                    Text(
                        text = "VS",
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        modifier = Modifier
                            .padding(15.dp)
                            .align(Alignment.CenterVertically),
                        textAlign = TextAlign.Center
                    )
                    AsyncImage(
                        model = matches.away_team_logo,
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(15.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Fit,
                        placeholder = painterResource(id = R.drawable.broken_image),
                        error = painterResource(id = R.drawable.broken_image)
                    )
                }
                Text(
                    matches.event_date,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center
                )
                Text(
                    matches.event_time,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center
                )

            }
        }
    }
}


@Composable
fun TennisFixture(fixture: UiStateResult<List<TennisFixtureResponseModel>>) {
    when (fixture) {
        is UiStateResult.Failure -> {
            Log.i("fixture", "FixtureScreen: fail ")
        }

        UiStateResult.Loading -> {
            Log.i("fixture", "FixtureScreen loading ")
        }

        is UiStateResult.Success -> {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    "Up Coming Matches",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(15.dp)
                )
                TennisUpComingMatches(fixture.response)
                Text(
                    " Finished Matches",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(15.dp)
                )
                TennisFinishedMatches(fixture.response)
            }
        }
    }
}

@Composable
fun TennisFinishedMatches(response: List<TennisFixtureResponseModel>) {
    LazyColumn {
        itemsIndexed(response) { _, match ->
            TennisFinishedMatchesCard(match)
        }
    }
}

@Composable
fun TennisFinishedMatchesCard(match: TennisFixtureResponseModel) {

    Log.i("status", " statues ${match.event_final_result} ")
    if (match.event_final_result != "_") {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .padding(vertical = 10.dp)
                .height(200.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            onClick = {
            }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    AsyncImage(
                        model = match.event_first_player_logo,
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(15.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Fit,
                        placeholder = painterResource(id = R.drawable.broken_image),
                        error = painterResource(id = R.drawable.broken_image)
                    )
                    Text(
                        text = match.event_first_player,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .padding(15.dp)
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center
                    )
                }
                Column {
                    Text(
                        match.event_final_result,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        match.event_date,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center
                    )
                }
                Column {
                    AsyncImage(
                        model = match.event_second_player_logo,
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(15.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Fit,
                        placeholder = painterResource(id = R.drawable.broken_image),
                        error = painterResource(id = R.drawable.broken_image)
                    )
                    Text(
                        match.event_second_player,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center
                    )
                }
            }

        }
    }
}


@Composable
fun TennisUpComingMatches(response: List<TennisFixtureResponseModel>) {

    LazyRow {
        itemsIndexed(response) { _, matches ->
            TennisUpComingMatchesCard(matches)
        }
    }
}

@Composable
fun TennisUpComingMatchesCard(matches: TennisFixtureResponseModel) {

    Log.i("status", " statues ${matches.event_final_result} ")
    if (matches.event_final_result == "_") {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .padding(vertical = 10.dp)
                .height(200.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            onClick = {
            }
        ) {
            Column {
                Row {
                    AsyncImage(
                        model = matches.event_first_player_logo,
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(15.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Fit,
                        placeholder = painterResource(id = R.drawable.broken_image),
                        error = painterResource(id = R.drawable.broken_image)
                    )
                    Text(
                        text = "VS",
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        modifier = Modifier
                            .padding(15.dp)
                            .align(Alignment.CenterVertically),
                        textAlign = TextAlign.Center
                    )
                    AsyncImage(
                        model = matches.event_second_player_logo,
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(15.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Fit,
                        placeholder = painterResource(id = R.drawable.broken_image),
                        error = painterResource(id = R.drawable.broken_image)
                    )
                }
                Text(
                    matches.event_date,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center
                )

            }
        }
    }
}

