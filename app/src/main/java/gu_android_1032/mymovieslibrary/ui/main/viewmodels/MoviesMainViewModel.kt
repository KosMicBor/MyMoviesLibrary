package gu_android_1032.mymovieslibrary.ui.main.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gu_android_1032.mymovieslibrary.AppState
import gu_android_1032.mymovieslibrary.ResourceProvider
import gu_android_1032.mymovieslibrary.domain.Movie
import gu_android_1032.mymovieslibrary.domain.MoviesRepositoryImpl

class MoviesMainViewModel(
    private val resourceProvider: ResourceProvider, // добавлен в проект для тренировки
    private val moviesLiveData: MutableLiveData<AppState> = MutableLiveData()

) : ViewModel() {

    private val repository = MoviesRepositoryImpl()

    fun getMoviesLiveData() = moviesLiveData

    fun getMoviesLiveDataList(){
        val moviesList = repository.getTestMovies()
        moviesLiveData.postValue(AppState.Success(moviesList))
    }
}