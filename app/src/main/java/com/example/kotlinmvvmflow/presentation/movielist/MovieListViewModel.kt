package com.example.kotlinmvvmflow.presentation.movielist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinmvvmflow.api.models.ResponseWrapper
import com.example.kotlinmvvmflow.model.movie.GetMovieUseCase
import com.example.kotlinmvvmflow.model.movie.Search
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val getMovieUseCase: GetMovieUseCase) :
    ViewModel() {
    private val _state = MutableStateFlow<HomeMListViewState>(HomeMListViewState.Init)
    val mState: MutableStateFlow<HomeMListViewState> = _state
//    var movieList: List<Search> = emptyList()
fun onEvent(event: MListEvent) {
    Log.w("MList onEvent", "Clicked")
    when (event) {
        is MListEvent.LoadData -> {
             fetchData()
        }

        else -> {}
    }
}

    public fun fetchData() {
        viewModelScope.launch {
            getMovieUseCase.execute().onStart {
                _state.value = HomeMListViewState.IsLoading(true)
            }
                .catch {
                    _state.value = HomeMListViewState.IsLoading(false)
                }
                .collect {
                    _state.value = HomeMListViewState.IsLoading(false)
                    when (it) {
                        is ResponseWrapper.NetworkError -> {
                            Log.w("Data found", "No Internet")
                        }

                        is ResponseWrapper.GenericError -> {
                            it.error?.let { msg ->
                                _state.value = HomeMListViewState.IsLoading(false)
                                Log.w("Data found", it.code.toString())
                                _state.value = HomeMListViewState.ErrorResponse(it.code.toString())
                            }
                        }

                        is ResponseWrapper.Success -> {
                            _state.value = HomeMListViewState.IsLoading(false)
                            Log.w("Data found", it.value.size.toString())
//                            movieList = it.value
                            _state.value = HomeMListViewState.SuccessResponse(it.value)
                        }
                    }

                }
        }
    }
}
sealed class MListEvent {
    object LoadData : MListEvent()

}
sealed class HomeMListViewState {
    object Init : HomeMListViewState()
    data class IsLoading(val isLoading: Boolean) : HomeMListViewState()
    data class ShowToast(val message: String) : HomeMListViewState()
    data class SuccessResponse(val MList: List<Search>) : HomeMListViewState()
    data class ErrorResponse(val message: String) : HomeMListViewState()
}