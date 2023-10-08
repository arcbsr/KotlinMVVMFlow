package com.example.kotlinmvvmflow

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinmvvmflow.presentation.movielist.MovieListActivity
import com.example.kotlinmvvmflow.ui.theme.KotlinMVVMFlowTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinMVVMFlowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(name = "I am starting")
                    SplashScreen(this)
                }
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
@Composable
fun SplashScreen(activity: ComponentActivity) {

    LaunchedEffect(key1 = true) {
        // Simulate a delay (e.g., 2 seconds)
        delay(2000)
        val intent = Intent(activity, MovieListActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    // Your splash screen layout here...
}

