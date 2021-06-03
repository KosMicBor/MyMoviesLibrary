package gu_android_1032.mymovieslibrary.ui.main.fragments

import android.os.Bundle

import android.view.View

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar

import gu_android_1032.mymovieslibrary.R
import gu_android_1032.mymovieslibrary.ResourceProvider
import gu_android_1032.mymovieslibrary.databinding.FragmentMovieDetailsBinding
import gu_android_1032.mymovieslibrary.domain.Movie
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModel
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModelFactory


class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    companion object {

        const val BUNDLE_EXTRA = "movie"

        fun newInstance(bundle: Bundle): MovieDetailsFragment {
            return MovieDetailsFragment().apply {
                arguments = bundle
            }
        }
    }

    private val viewModel: MoviesMainViewModel by viewModels {
        MoviesMainViewModelFactory(ResourceProvider(requireActivity().application))
    }

    private var binding: FragmentMovieDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.showIsLoadSnackBar(R.string.details_loaded_message)

        arguments?.getParcelable<Movie>(BUNDLE_EXTRA)?.let { movie ->
            binding = FragmentMovieDetailsBinding.bind(view).apply {
                movieDetailsLocalTitle.text = movie.localTitle
                movieDetailsTitle.text = movie.originalTitle
            }
        }
    }

    private fun View.showIsLoadSnackBar(
        textId: Int,
        length: Int = Snackbar.LENGTH_SHORT
    ) {
        Snackbar.make(this, getString(textId), length).show()
    }

    private fun View.snackBarWithTextGetter(
        text: String,
        length: Int = Snackbar.LENGTH_SHORT
    ) {
        Snackbar.make(this, text, length).show()
    }
}