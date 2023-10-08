package com.example.kotlinmvvmflow.presentation.moviedetail


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kotlinmvvmflow.model.movie.detail.DetailRoot


@Composable
fun MovieDetailScreen(movie: DetailRoot) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            model = ImageRequest.Builder(context = context).data(movie.Poster)
                .build(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(248.dp)
                .clip(MaterialTheme.shapes.large),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = movie.Title.toString(), style = TextStyle(
                fontSize = 24.sp, fontWeight = FontWeight.Bold
            ), modifier = Modifier.padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {

            // Movie Overview
            Text(
                text = "Overview",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text(
                text = movie.Plot.toString(),
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Actors: ${movie.Actors.toString()}",
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Language: ${movie.Language.toString()}",
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            // Movie Release Date
            Text(
                text = "Release Date: ${movie.Released.toString()}",
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Movie Rating
            Text(
                text = "Rating: ${movie.Ratings[0].Value}",
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Other details as needed
        }
    }
}