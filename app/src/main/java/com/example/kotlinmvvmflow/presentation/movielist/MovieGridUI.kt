package com.example.kotlinmvvmflow.presentation.movielist

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.kotlinmvvmflow.model.movie.Search
import com.example.kotlinmvvmflow.presentation.nav.Screen
import com.example.kotlinmvvmflow.ui.theme.KotlinMVVMFlowTheme

@Composable
fun MovieGridUI(
    navController: NavHostController,
    movies: List<Search>,
    navigateUp: () -> Unit
) {

    createMovieList(navController = navController, movies = movies,navigateUp)
}

@Composable
fun createMovieList(
    navController: NavHostController,
    movies: List<Search>,
    navigateUp: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Button(
            onClick = { navigateUp.invoke() },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Close")
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(movies) { movie ->
                MovieItem(movie, navController)
            }
        }

    }
}

@Composable
fun MovieItem(movie: Search, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                val bundle = Bundle()
                bundle.putString("param2", "Value2")
                navController.navigate(Screen.Screen2.createRoute(movie.imdbID.toString()))

            }
            .fillMaxWidth(0.5f),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Image(
                painter = rememberImagePainter(movie.Poster),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(140.dp)
                    .height(100.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))


            movie.Year?.let {
                Text(
                    text = it,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.Gray
                    ),
                )
            }
            movie.Title?.let {
                Text(
                    text = it,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinMVVMFlowTheme {
        Greeting("Android")
    }
}





