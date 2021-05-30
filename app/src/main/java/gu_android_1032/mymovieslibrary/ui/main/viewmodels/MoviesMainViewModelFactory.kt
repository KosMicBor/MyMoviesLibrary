package gu_android_1032.mymovieslibrary.ui.main.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import gu_android_1032.mymovieslibrary.MoviesMainRouter
import gu_android_1032.mymovieslibrary.ResourceProvider

class MoviesMainViewModelFactory(
    private val resourceProvider: ResourceProvider) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MoviesMainViewModel(resourceProvider) as T
}
