package com.example.kotlinmvvmflow.presentation.movielist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.kotlinmvvmflow.presentation.nav.Navigator
import com.example.kotlinmvvmflow.ui.theme.KotlinMVVMFlowTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinMVVMFlowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting(name = "acitivity Opened")
                    Navigator().appNavigator()

                    /*val viewModel: MovieListViewModel by viewModels()
                    val mState by viewModel.mState.collectAsState()
                    when (mState) {
                        is HomeMListViewState.ErrorResponse -> {
                            Greeting(name = "Error")
                        }

                        HomeMListViewState.Init -> Greeting(name = "Init")
                        is HomeMListViewState.IsLoading -> Greeting(name = "Loading")
                        is HomeMListViewState.ShowToast -> Greeting(name = "ShowToast")
                        is HomeMListViewState.SuccessResponse -> {
//                            val movieList =(mState as HomeMListViewState.SuccessResponse).MList
                            //MovieGridUI(movieList = movies)
//                            Navigator().appNavigator()
//                            val navController = rememberNavController()
//                            navController.navigate(Screen.Screen1.route)

                        }

                    }*/

                }
            }
        }
    }
}