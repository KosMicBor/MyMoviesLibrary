package gu_android_1032.mymovieslibrary

import android.os.Bundle
import android.os.Parcelable
import gu_android_1032.mymovieslibrary.ui.main.fragments.MovieDetailsFragment
import gu_android_1032.mymovieslibrary.ui.main.fragments.MoviesFavoritesFragment
import gu_android_1032.mymovieslibrary.ui.main.fragments.MoviesMainListFragment
import gu_android_1032.mymovieslibrary.ui.main.fragments.MoviesRatingsFragment
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


class MoviesMainRouter(private val activity: MainActivity) {

    fun openMainList(bundle: Bundle){
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_main_list_container, MoviesMainListFragment.newInstance(bundle))
            .commit()
    }

    fun openMovieDetails(){
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_main_list_container, MovieDetailsFragment())
            .addToBackStack("MovieDetailsFragment")
            .commit()
    }

    fun openMoviesFavorites(){
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_main_list_container, MoviesFavoritesFragment())
            .addToBackStack("MoviesFavoritesFragment")
            .commit()
    }

    fun openMoviesRatings(){
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_main_list_container, MoviesRatingsFragment())
            .addToBackStack("MoviesRatingsFragment")
            .commit()
    }
}