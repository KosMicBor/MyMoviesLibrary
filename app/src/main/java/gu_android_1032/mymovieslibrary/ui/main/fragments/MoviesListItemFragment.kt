package gu_android_1032.mymovieslibrary.ui.main.fragments

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import gu_android_1032.mymovieslibrary.MainActivity
import gu_android_1032.mymovieslibrary.MoviesMainRouter
import gu_android_1032.mymovieslibrary.R
import gu_android_1032.mymovieslibrary.ResourceProvider
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModel
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModelFactory

class MoviesListItemFragment : Fragment(R.layout.fragment_movies_list_item) {
    companion object {
        fun newInstance() = MoviesMainListFragment()
    }

    private val viewModel: MoviesMainViewModel by viewModels {
        MoviesMainViewModelFactory(
            ResourceProvider(requireActivity().application))
    }
}