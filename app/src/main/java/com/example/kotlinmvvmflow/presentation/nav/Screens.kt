package com.example.kotlinmvvmflow.presentation.nav

sealed class Screen(val route: String) {
    object Screen1 : Screen("Home")
    object Screen2 : Screen("Detail/{mid}"){
        fun createRoute(mid: String) = "Detail/$mid"
    }
}