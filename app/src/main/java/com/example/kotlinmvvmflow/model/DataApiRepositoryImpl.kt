package com.example.kotlinmvvmflow.model

import android.util.Log
import com.example.kotlinmvvmflow.model.movie.Search
import com.example.kotlinmvvmflow.api.models.ResponseWrapper
import com.example.kotlinmvvmflow.model.movie.detail.DetailRoot
import com.example.kotlinmvvmflow.remot.MovieDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataApiRepositoryImpl  @Inject constructor(private val remoteDataSource: MovieDataSource): DataApiRepository {

    override suspend fun getMovieListResponse(): Flow<ResponseWrapper<List<Search>>> {
        return flow {
            Log.e(TAG, "I'm working in thread ${Thread.currentThread().name}")
            emit(remoteDataSource.getMovieList())
        }
    }

    override suspend fun getMovieDetail(id:String): Flow<ResponseWrapper<DetailRoot>> {
        return flow {
            Log.e(TAG, "I'm working in thread ${Thread.currentThread().name}")
            emit(remoteDataSource.getMovieDetail(id))
        }
    }

    companion object{
        private const val TAG = "DataApiRepository"
    }
}