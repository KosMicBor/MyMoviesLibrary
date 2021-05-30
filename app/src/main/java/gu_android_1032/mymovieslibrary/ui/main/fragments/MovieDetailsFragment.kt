package gu_android_1032.mymovieslibrary.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import gu_android_1032.mymovieslibrary.MainActivity
import gu_android_1032.mymovieslibrary.MoviesMainRouter
import gu_android_1032.mymovieslibrary.R
import gu_android_1032.mymovieslibrary.ResourceProvider
import gu_android_1032.mymovieslibrary.databinding.FragmentMovieDetailsBinding
import gu_android_1032.mymovieslibrary.domain.Movie
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModel
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie_details.*

class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    companion object {

        const val BUNDLE_EXTRA = "movie"

        fun newInstance(bundle: Bundle): MovieDetailsFragment {
            val fragment = MovieDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private val viewModel: MoviesMainViewModel by viewModels {
        MoviesMainViewModelFactory(ResourceProvider(requireActivity().application))
    }

    private var binding: FragmentMovieDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movie = arguments?.getParcelable<Movie>(BUNDLE_EXTRA)

        val _binding = FragmentMovieDetailsBinding.bind(view)
        binding = _binding
        if (movie != null) {
            binding?.movieDetailsLocalTitle?.text = movie.localTitle
            binding?.movieDetailsTitle?.text = movie.originalTitle
        }
    }
}