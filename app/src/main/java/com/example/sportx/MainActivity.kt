package com.example.sportx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.sportx.data.remote.RetrofitService
import com.example.sportx.data.remote.SportXRemoteDataSource
import com.example.sportx.data.repository.SPORTXRepoImpl
import com.example.sportx.domain.use_case.SportXUseCaseImpl
import com.example.sportx.presentation.home.HomeScreen
import com.example.sportx.presentation.leagues.LeaguesFactory
import com.example.sportx.presentation.leagues.LeaguesScreen
import com.example.sportx.presentation.leagues.LeaguesViewModel
import com.example.sportx.presentation.routes.HomeScreen
import com.example.sportx.presentation.routes.LeaguesScreen
import com.example.sportx.presentation.tab_row.TabRowFunction

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()


        setContent {
            TabRowFunction()
        }
    }
}
