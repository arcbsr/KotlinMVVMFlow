package com.example.kotlinmvvmflow.model.movie

import com.example.kotlinmvvmflow.api.models.ResponseWrapper
import com.example.kotlinmvvmflow.model.DataApiRepository
import com.example.kotlinmvvmflow.model.movie.detail.DetailRoot
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetMovieUseCase  @Inject constructor(private val repository : DataApiRepository) {
    suspend fun execute():Flow<ResponseWrapper<List<Search>>>{
        return repository.getMovieListResponse().map {
            when(it){
                is ResponseWrapper.Success -> {
                    ResponseWrapper.Success(it.value)
                }
                is ResponseWrapper.GenericError -> {
                    ResponseWrapper.GenericError(it.code,it.error)
                }
                is ResponseWrapper.NetworkError -> {
                    ResponseWrapper.NetworkError
                }
            }

        }
    }
    suspend fun executeDetail(mId:String):Flow<ResponseWrapper<DetailRoot>>{
        return repository.getMovieDetail(mId).map {
            when(it){
                is ResponseWrapper.Success -> {
                    ResponseWrapper.Success(it.value)
                }
                is ResponseWrapper.GenericError -> {
                    ResponseWrapper.GenericError(it.code,it.error)
                }
                is ResponseWrapper.NetworkError -> {
                    ResponseWrapper.NetworkError
                }
            }

        }
    }
}