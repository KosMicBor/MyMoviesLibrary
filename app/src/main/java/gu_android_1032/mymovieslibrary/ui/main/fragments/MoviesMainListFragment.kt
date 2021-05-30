package gu_android_1032.mymovieslibrary.ui.main.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import gu_android_1032.mymovieslibrary.*
import gu_android_1032.mymovieslibrary.databinding.FragmentMainListBinding
import gu_android_1032.mymovieslibrary.domain.Movie
import gu_android_1032.mymovieslibrary.ui.main.adapters.MoviesMainListAdapter

import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModel
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModelFactory
import kotlinx.android.parcel.RawValue

class MoviesMainListFragment : Fragment(R.layout.fragment_main_list) {

    companion object {
        fun newInstance() = MoviesMainListFragment()
    }

    private var viewBinding: FragmentMainListBinding? = null

    private lateinit var viewModel: MoviesMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = MoviesMainViewModelFactory(
            ResourceProvider(requireActivity().application)
        )

        viewModel = ViewModelProvider(requireActivity(), factory)
            .get(MoviesMainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val router = MoviesMainRouter(activity = requireActivity() as @RawValue MainActivity)
        val bundle = Bundle()
        val binding = FragmentMainListBinding.bind(view)
        viewBinding = binding

        val recyclerView: RecyclerView? = viewBinding?.mainRecyclerviewList
        if (recyclerView != null) {
            recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        }

        viewModel.getMoviesLiveData().observe(viewLifecycleOwner, {
            when (it) {
                is AppState.Success -> {
                    recyclerView?.adapter = MoviesMainListAdapter(it.moviesData, object : OnItemClickListener{
                        override fun onItemClick(movie: Movie) {
                            bundle.putParcelable(MovieDetailsFragment.BUNDLE_EXTRA, movie)
                            val manager = activity?.supportFragmentManager
                            manager?.beginTransaction()
                                ?.replace(R.id.fragment_main_list_container, MovieDetailsFragment.newInstance(bundle))
                                ?.addToBackStack("MovieDetailsFragment")?.commit()
                        }
                    })
                }
                is AppState.Error -> {
                    Snackbar
                        .make(view, "There is loading error", Snackbar.LENGTH_INDEFINITE)
                        .show()
                }
            }

        })
        viewModel.getMoviesLiveDataList()

    }

    interface OnItemClickListener{
        fun onItemClick (movie: Movie)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}

