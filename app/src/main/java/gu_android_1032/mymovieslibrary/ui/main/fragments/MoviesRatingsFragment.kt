package gu_android_1032.mymovieslibrary.ui.main.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import gu_android_1032.mymovieslibrary.R
import gu_android_1032.mymovieslibrary.ResourceProvider
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModel
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModelFactory

class MoviesRatingsFragment : Fragment(R.layout.fragment_movies_ratings) {
    companion object {
        fun newInstance() = MoviesMainListFragment()
    }

    private val viewModel: MoviesMainViewModel by viewModels {
        MoviesMainViewModelFactory(ResourceProvider(requireActivity().application))
    }
}