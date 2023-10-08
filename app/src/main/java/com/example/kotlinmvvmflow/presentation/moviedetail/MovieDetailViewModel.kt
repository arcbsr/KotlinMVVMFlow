package com.example.kotlinmvvmflow.presentation.moviedetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinmvvmflow.api.models.ResponseWrapper
import com.example.kotlinmvvmflow.model.movie.GetMovieUseCase
import com.example.kotlinmvvmflow.model.movie.detail.DetailRoot
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val getMovieUseCase: GetMovieUseCase) :
    ViewModel() {
    private val _state = MutableStateFlow<HomeDetailViewState>(HomeDetailViewState.Init)
    val mState = _state

    public fun fetchData(mId:String) {
        viewModelScope.launch {
            getMovieUseCase.executeDetail(mId).onStart {
                _state.value = HomeDetailViewState.IsLoading(false)
            }
                .catch {
                    _state.value = HomeDetailViewState.IsLoading(false)
                }
                .collect {
                    _state.value = HomeDetailViewState.IsLoading(false)
                    when (it) {
                        is ResponseWrapper.NetworkError -> {
                            Log.w("Data found", "No Internet")
                        }

                        is ResponseWrapper.GenericError -> {
                            it.error?.let { msg ->
                                Log.w("Data found", it.code.toString())
                                _state.value = HomeDetailViewState.ErrorResponse(it.code.toString())
                            }
                        }

                        is ResponseWrapper.Success -> {
                            _state.value = HomeDetailViewState.SuccessResponse(it.value)
                        }
                    }

                }
        }
    }
}

sealed class HomeDetailViewState {
    object Init : HomeDetailViewState()
    data class IsLoading(val isLoading: Boolean) : HomeDetailViewState()
    data class ShowToast(val message: String) : HomeDetailViewState()
    data class SuccessResponse(val detail: DetailRoot) : HomeDetailViewState()
    data class ErrorResponse(val message: String) : HomeDetailViewState()
}