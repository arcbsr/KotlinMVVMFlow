package com.example.kotlinmvvmflow.api.connectivity

import com.example.kotlinmvvmflow.model.movie.MovieRootModel
import com.example.kotlinmvvmflow.model.movie.detail.DetailRoot
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    @Headers("Content-Type: application/json", "X-RapidAPI-Key: b078ca1d25msh1bec2361bbd41f0p145551jsn71edee6c08b7", "X-RapidAPI-Host: movie-database-alternative.p.rapidapi.com")
    @GET("?s=endgame&r=json&page=1")
    suspend fun getmovieList(): MovieRootModel

    @Headers("Content-Type: application/json", "X-RapidAPI-Key: b078ca1d25msh1bec2361bbd41f0p145551jsn71edee6c08b7", "X-RapidAPI-Host: movie-database-alternative.p.rapidapi.com")
//    @GET("?r=json&i=tt4154796")
    @GET("?r=json")
    suspend fun getMovieDetail(@Query("i") id: String): DetailRoot
}