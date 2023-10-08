package com.example.kotlinmvvmflow.presentation.nav

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinmvvmflow.presentation.moviedetail.HomeDetailViewState
import com.example.kotlinmvvmflow.presentation.moviedetail.MovieDetailScreen
import com.example.kotlinmvvmflow.presentation.movielist.HomeMListViewState
import com.example.kotlinmvvmflow.presentation.movielist.MListEvent
import com.example.kotlinmvvmflow.presentation.moviedetail.MovieDetailViewModel
import com.example.kotlinmvvmflow.presentation.movielist.Greeting
import com.example.kotlinmvvmflow.presentation.movielist.MovieGridUI
import com.example.kotlinmvvmflow.presentation.movielist.MovieListViewModel


class Navigator() {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun appNavigator() {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Screen.Screen1.route
        ) {
            composable(Screen.Screen1.route) {
                val viewModel: MovieListViewModel = hiltViewModel()
                val mstate = viewModel.mState.collectAsState().value
                when (mstate) {
                    is HomeMListViewState.ErrorResponse -> {
                        com.example.kotlinmvvmflow.Greeting(name = "Error")
                    }

                    HomeMListViewState.Init -> {
                        viewModel.onEvent(MListEvent.LoadData)
                        Button(
                            onClick = {},
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(text = "Load Data")
                        }

                    }

                    is HomeMListViewState.IsLoading -> com.example.kotlinmvvmflow.Greeting(name = "Loading")
                    is HomeMListViewState.ShowToast -> com.example.kotlinmvvmflow.Greeting(name = "ShowToast")
                    is HomeMListViewState.SuccessResponse -> {
                        MovieGridUI(
                            navController = navController,
                            movies = mstate.MList,
                            navigateUp = {
//                        navController.navigate(Screen.Screen2.createRoute("adsdsds"))
//                        viewModel.onEvent(MListEvent.LoadData)
                            })
                    }

                    else -> {}
                }

            }
            composable(Screen.Screen2.route) {
                val arg = it.arguments?.getString("mid")
                val viewModel: MovieDetailViewModel = hiltViewModel()
                when (val state = viewModel.mState.collectAsState().value) {
                    is HomeDetailViewState.ErrorResponse -> {
                        com.example.kotlinmvvmflow.Greeting(name = "Error")
                    }
                    is HomeDetailViewState.Init -> {
                        viewModel.fetchData(arg.toString())
                    }
                    is HomeDetailViewState.IsLoading -> ""
                    is HomeDetailViewState.ShowToast -> com.example.kotlinmvvmflow.Greeting(name = "ShowToast")
                    is HomeDetailViewState.SuccessResponse -> {
//                        Greeting(name = state.detail.Plot.toString())
                        MovieDetailScreen(movie = state.detail)
                    }
                }

//                Log.w("My arg:>>", arg.toString())
//                Greeting(name = "$arg")
            }
        }
    }


}