package gu_android_1032.mymovieslibrary.ui.main.fragments

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import gu_android_1032.mymovieslibrary.*
import gu_android_1032.mymovieslibrary.databinding.FragmentMainListBinding
import gu_android_1032.mymovieslibrary.domain.GetMovieService
import gu_android_1032.mymovieslibrary.domain.responses.Movie
import gu_android_1032.mymovieslibrary.ui.main.adapters.MoviesMainListAdapter

import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModel
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModelFactory

class MoviesMainListFragment : Fragment(R.layout.fragment_main_list) {

    companion object {
        const val ACTIVITY_ROUTER = "ACTIVITY_ROUTER"

        fun newInstance(bundle: Bundle): MoviesMainListFragment {
            return MoviesMainListFragment().apply {
                arguments = bundle
            }
        }
    }

    private var viewBinding: FragmentMainListBinding? = null

    private lateinit var viewModel: MoviesMainViewModel

    private lateinit var mainListAdapter: MoviesMainListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = MoviesMainViewModelFactory(
            ResourceProvider(requireActivity().application)
        )

        viewModel = ViewModelProvider(requireActivity(), factory)
            .get(MoviesMainViewModel::class.java)

        if (savedInstanceState == null) {
            viewModel.getMoviesLiveDataList()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val router = MoviesMainRouter(requireActivity() as MainActivity)

        viewBinding = FragmentMainListBinding.bind(view)
        val safeBinding = viewBinding ?: return

        val recyclerView: RecyclerView = safeBinding.mainRecyclerviewList.also {
            it.layoutManager = LinearLayoutManager(requireActivity())
        }

        viewModel.moviesListLiveData.observe(viewLifecycleOwner, {
            mainListAdapter =
                MoviesMainListAdapter(it, object :
                    OnItemClickListener {
                    override fun onItemClick(movie: Movie) {
                        requireContext().startService(
                            Intent(
                                requireContext(),
                                GetMovieService::class.java
                            ).apply { putExtra(GetMovieService.ARG_MOVIE, movie.id) })
                        router.openMovieDetails()
                    }
                })
            recyclerView.adapter = mainListAdapter
        })

        viewModel.errorLiveData.observe(viewLifecycleOwner, {
            Snackbar.make(view,getString(R.string._loading_error), Snackbar.LENGTH_SHORT)
        })

        viewModel.getMoviesLiveDataList()
    }

    interface OnItemClickListener {
        fun onItemClick(movie: Movie)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
        mainListAdapter.removeListener()
    }
}

