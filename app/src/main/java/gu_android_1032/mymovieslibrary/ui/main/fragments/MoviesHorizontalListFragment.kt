package gu_android_1032.mymovieslibrary.ui.main.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import gu_android_1032.mymovieslibrary.MainActivity
import gu_android_1032.mymovieslibrary.MoviesMainRouter
import gu_android_1032.mymovieslibrary.R
import gu_android_1032.mymovieslibrary.ResourceProvider
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModel
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModelFactory


class MoviesHorizontalListFragment : Fragment(R.layout.fragment_movies_horizontal_list) {
    companion object {
        fun newInstance() = MoviesMainListFragment()
    }

    private lateinit var viewModel: MoviesMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = MoviesMainViewModelFactory(
            ResourceProvider(requireActivity().application))

        viewModel =
            ViewModelProvider(requireActivity(), factory).get(MoviesMainViewModel::class.java)
    }
}