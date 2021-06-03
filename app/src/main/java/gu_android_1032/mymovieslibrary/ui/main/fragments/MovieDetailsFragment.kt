package gu_android_1032.mymovieslibrary.ui.main.fragments

import android.os.Bundle

import android.view.View

import androidx.fragment.app.Fragment

import gu_android_1032.mymovieslibrary.R

import gu_android_1032.mymovieslibrary.databinding.FragmentMovieDetailsBinding
import gu_android_1032.mymovieslibrary.domain.responses.Movie



class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    companion object {

        const val BUNDLE_EXTRA = "movie"

        fun newInstance(bundle: Bundle): MovieDetailsFragment {
            return MovieDetailsFragment().apply {
                arguments = bundle
            }
        }
    }

    private var binding: FragmentMovieDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        arguments?.getParcelable<Movie>(BUNDLE_EXTRA)?.let { movie ->
            binding = FragmentMovieDetailsBinding.bind(view).apply {
                movieDetailsLocalTitle.text = movie.title
                movieDetailsTitle.text = movie.originalTitle
                movieDetailsOverview.text = movie.overview
                movieDetailsGenres.text = getString(R.string._genres_text)
                val releaseDateText = "${getString(R.string.release_date)}${movie.releaseDate}"
                movieDetailsReleaseDate.text = releaseDateText
                movieDetailsVotes.text = movie.voteAverage.toString()

            }
        }
    }
}