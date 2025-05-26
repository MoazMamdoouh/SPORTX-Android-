package com.example.sportx.presentation.fixtures

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.sportx.R
import com.example.sportx.utilities.UiStateResult


@Composable
fun FixtureScreen(fixtureViewModel : FixtureViewModel , sportType : String ){
   Row {
       Text("Up Coming Matches" , fontSize = 32.sp , fontWeight = FontWeight.Bold)
       UpComingMatches(fixtureViewModel , sportType)
   }
}
@Composable
fun UpComingMatches(fixtureViewModel: FixtureViewModel, sportType: String) {
    val upComingMatches
    = fixtureViewModel.upComingMatches.collectAsStateWithLifecycle().value

    fixtureViewModel.getUpComingMatches(sportType)

    when (upComingMatches){
        is UiStateResult.Failure -> {
            Log.i("TAG", "UpComingMatches: in screen fail  ")
        }
        UiStateResult.Loading -> {
            Log.i("TAG", "UpComingMatches: in screen loading  ")
        }
        is UiStateResult.Success -> {
            LazyColumn {
                itemsIndexed(upComingMatches.response){ _,  match ->
                    UpComingMatchesCard(match)
                }
            }
        }
    }
}
@Composable
fun UpComingMatchesCard(match: Result) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(vertical = 10.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Row {
            AsyncImage(
                model = match.home_team_logo ,
                contentDescription = "logo" ,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Fit ,
                placeholder = painterResource(id = R.drawable.broken_image),
                error = painterResource(id = R.drawable.broken_image)
            )
            Spacer(Modifier.width(20.dp))
            AsyncImage(
                model = match.home_team_logo ,
                contentDescription = "logo" ,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Fit ,
                placeholder = painterResource(id = R.drawable.broken_image),
                error = painterResource(id = R.drawable.broken_image)
            )
        }
    }

}
@Composable
fun LatestMatches() {
    LazyColumn {

    }
}

@Composable
fun LatestMatchesCard(){

}

