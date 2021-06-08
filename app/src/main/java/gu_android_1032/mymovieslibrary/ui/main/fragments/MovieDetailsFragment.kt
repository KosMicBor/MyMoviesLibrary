package gu_android_1032.mymovieslibrary.ui.main.fragments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle

import android.view.View

import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager

import gu_android_1032.mymovieslibrary.R

import gu_android_1032.mymovieslibrary.databinding.FragmentMovieDetailsBinding
import gu_android_1032.mymovieslibrary.domain.GetMovieService
import gu_android_1032.mymovieslibrary.domain.responses.Genre
import gu_android_1032.mymovieslibrary.domain.responses.Movie
import java.lang.StringBuilder


class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    companion object {

        const val BUNDLE_EXTRA = "movie"

        fun newInstance(bundle: Bundle): MovieDetailsFragment {
            return MovieDetailsFragment().apply {
                arguments = bundle
            }
        }
    }

    private var movie: Movie? = null

    private val movieReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            movie = intent?.getParcelableExtra("ARG_MOVIE_RESULT")

            binding?.apply {
                movieDetailsLocalTitle.text = movie?.title
                movieDetailsTitle.text = movie?.originalTitle
                movieDetailsOverview.text = movie?.overview
                movieDetailsRuntime.text = "${getString(R.string.runtime)} ${movie?.runtime}"
                movieDetailsBudget.text = "${getString(R.string.budbet)} ${movie?.budget.toString()}"
                movieDetailsGenres.text = "${getString(R.string._genres_text)} ${getGenres(movie?.genres)}"
                val releaseDateText = "${getString(R.string.release_date)} ${movie?.releaseDate}"
                movieDetailsReleaseDate.text = releaseDateText
                movieDetailsVotes.text = movie?.voteAverage.toString()
                movieDetailsRevenue.text = "${getString(R.string.revenue)} ${movie?.revenue.toString()}"
            }
        }
    }

    private fun getGenres(genres: ArrayList<Genre>?): String {
        val builder = StringBuilder()

        genres?.forEach {
            builder.apply{
                append(it.name)
                append((" "))
            }

        }
        return builder.toString()
    }

    override fun onStart() {
        super.onStart()

        IntentFilter(GetMovieService.REQUEST_MOVIE_RESULT).also {
            LocalBroadcastManager.getInstance(requireContext()).registerReceiver(movieReceiver, it)
        }
    }

    private var binding: FragmentMovieDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding = FragmentMovieDetailsBinding.bind(view)
    }

    override fun onStop() {
        super.onStop()
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(movieReceiver)
    }
}