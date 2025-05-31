package com.example.sportx.presentation.leagues

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.sportx.R
import com.example.sportx.domain.model.leagues.LeaguesResponseModel
import com.example.sportx.presentation.routes.FixtureScreen
import com.example.sportx.utilities.UiStateResult


@Composable

fun LeaguesScreen(leaguesViewModel: LeaguesViewModel , sportType : String , navController : NavController) {
    SportsLeaguesList(leaguesViewModel , sportType , navController)
}

@Composable
fun SportsLeaguesList(
    leaguesViewModel: LeaguesViewModel,
    sportType: String,
    navController: NavController
) {
    leaguesViewModel.getSportLeagues(sportType)
    val leagues = leaguesViewModel.leagues.collectAsStateWithLifecycle().value

    when(leagues){
        is UiStateResult.Failure -> {
            Log.i("TAG", "SportsLeaguesList: in failure case  ")
        }
        UiStateResult.Loading -> {
            Log.i("TAG", "SportsLeaguesList: in loading case  ")
        }
        is UiStateResult.Success -> {
            LazyColumn {
                itemsIndexed(leagues.response){ _ , league ->
                    LeagueCard(league , navController , sportType)
                }
            }
        }
    }

}
@Composable
fun LeagueCard(league: LeaguesResponseModel, navController: NavController, sportType: String) {
    Log.i("id", "cricket id ${league.league_key} ")
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(vertical = 10.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White) ,
        onClick = {
            navController.navigate(FixtureScreen(sportType,league.league_key ))
        }
    ){
        Row {
            AsyncImage(
                model = league.league_logo ,
                contentDescription = "logo" ,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Fit ,
                placeholder = painterResource(id = R.drawable.broken_image),
                error = painterResource(id = R.drawable.broken_image)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = league.league_name , fontWeight = FontWeight.Bold , fontSize = 25.sp
                , modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize()
            , textAlign = TextAlign.Center)
        }
    }
}
