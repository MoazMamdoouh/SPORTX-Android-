package com.example.sportx.presentation.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sportx.R
import com.example.sportx.presentation.routes.LeaguesScreen


@Composable
fun HomeScreen(navController: NavHostController) {
    SportsRow(navController)
}
@Composable
fun SportsRow(navController: NavHostController) {

    Column {
        Row(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 20.dp)) {
            SportCard(R.drawable.fotball , "football" , navController)
            SportCard(R.drawable.basket_ball, "basketball", navController)
        }
        Row(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(vertical = 20.dp)) {
            SportCard(R.drawable.cricket, "cricket", navController)
            SportCard(R.drawable.tennis, "tennis", navController)
        }
    }
}

@Composable
fun SportCard(@DrawableRes imageRes: Int, sportName: String, navController: NavHostController) {
    val configuration = LocalConfiguration.current
    val screenHeight = (configuration.screenHeightDp.dp) / 3
    val screenWidth = (configuration.screenWidthDp.dp) / 2

    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .padding(vertical = 10.dp)
            .width(screenWidth)
            .height(screenHeight),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
        , onClick = {
            navController.navigate(LeaguesScreen(sportName))
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = "Sport image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f))
            )

            Text(
                text = sportName,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp)
            )
        }
    }
}

