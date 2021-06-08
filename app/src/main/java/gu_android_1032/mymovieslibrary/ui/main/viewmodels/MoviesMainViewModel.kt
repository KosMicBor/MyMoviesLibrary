package gu_android_1032.mymovieslibrary.ui.main.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gu_android_1032.mymovieslibrary.AppState
import gu_android_1032.mymovieslibrary.R
import gu_android_1032.mymovieslibrary.ResourceProvider
import gu_android_1032.mymovieslibrary.domain.MoviesRepositoryImpl
import gu_android_1032.mymovieslibrary.domain.responses.Movie
import java.util.concurrent.Executors

class MoviesMainViewModel(
    private val resourceProvider: ResourceProvider, // добавлен в проект для тренировки
) : ViewModel() {

    private val repository = MoviesRepositoryImpl()
    private val executor = Executors.newSingleThreadExecutor()

    private val _loadingLiveData = MutableLiveData(false)
    private val _errorLiveData = MutableLiveData<String?>()
    private val _moviesListLiveData = MutableLiveData<List<Movie>>()
    private val _movieLiveData = MutableLiveData<Movie?>()
    private lateinit var moviesList: List<Movie>

    val loadingLiveData: LiveData<Boolean> = _loadingLiveData
    val errorLiveData: LiveData<String?> = _errorLiveData
    val moviesListLiveData: LiveData<List<Movie>> = _moviesListLiveData
    val movieLiveData: LiveData<Movie?> = _movieLiveData

    fun getMoviesLiveDataList(){

        _loadingLiveData.value = true

        repository.getMoviesList(executor) {
            when (it) {
                is AppState.Success -> {
                    moviesList = it.moviesData
                    _moviesListLiveData.value = moviesList

                    _errorLiveData.value = null
                }

                is AppState.Error -> {
                    _errorLiveData.value = resourceProvider.getString(R.string.main_list_loading_error_message)
                }
            }

            _loadingLiveData.value = false
        }
    }
}