package com.example.kotlinmvvmflow.model

import com.example.kotlinmvvmflow.model.movie.Search
import com.example.kotlinmvvmflow.api.models.ResponseWrapper
import com.example.kotlinmvvmflow.model.movie.detail.DetailRoot
import kotlinx.coroutines.flow.Flow


interface DataApiRepository {
    suspend fun getMovieListResponse(): Flow<ResponseWrapper<List<Search>>>
    suspend fun getMovieDetail(mId:String): Flow<ResponseWrapper<DetailRoot>>
}