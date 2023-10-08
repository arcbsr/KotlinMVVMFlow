package com.example.kotlinmvvmflow.remot

import com.example.kotlinmvvmflow.model.movie.Search
import com.example.kotlinmvvmflow.api.connectivity.MovieApiService
import com.example.kotlinmvvmflow.api.connectivity.NoConnectivityException
import com.example.kotlinmvvmflow.api.models.ResponseWrapper
import com.example.kotlinmvvmflow.di.IoDispatcher
import com.example.kotlinmvvmflow.model.movie.detail.DetailRoot
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieDataSource @Inject constructor(private val apiService: MovieApiService,@IoDispatcher private val ioDispatcher: CoroutineDispatcher){

    suspend fun getMovieList(): ResponseWrapper<List<Search>>{
        return safeApiCall(apiCall = {
            apiService.getmovieList().Search
        })
    }
    suspend fun getMovieDetail(id:String): ResponseWrapper<DetailRoot>{
        return safeApiCall(apiCall = {
            apiService.getMovieDetail(id)
        })
    }
    private suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResponseWrapper<T> {
        return withContext(ioDispatcher) {
            try {
                ResponseWrapper.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is NoConnectivityException -> ResponseWrapper.NetworkError
                    is IOException -> ResponseWrapper.NetworkError
                    is HttpException -> {
                        val code = throwable.code()
                        val msg = throwable.message()
                        val errorMsg = if (msg.isNullOrEmpty()) {
                            throwable.response()?.errorBody()?.toString()
                        } else {
                            msg
                        }
                        ResponseWrapper.GenericError(code, errorMsg)
                    }
                    else -> {
                        ResponseWrapper.GenericError(null, null)
                    }
                }
            }
        }
    }


    companion object {
        private const val TAG = "ClearScoreDataSource"
    }
}