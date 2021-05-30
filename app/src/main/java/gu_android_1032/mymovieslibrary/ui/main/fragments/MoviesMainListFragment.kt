package gu_android_1032.mymovieslibrary.ui.main.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gu_android_1032.mymovieslibrary.R
import gu_android_1032.mymovieslibrary.ResourceProvider
import gu_android_1032.mymovieslibrary.databinding.FragmentMainListBinding
import gu_android_1032.mymovieslibrary.domain.Movie
import gu_android_1032.mymovieslibrary.ui.main.adapters.MoviesMainListAdapter

import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModel
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModelFactory

class MoviesMainListFragment : Fragment(R.layout.fragment_main_list) {

    companion object {
        fun newInstance() = MoviesMainListFragment()
    }

    private var viewBinding: FragmentMainListBinding? = null

    private lateinit var viewModel: MoviesMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = MoviesMainViewModelFactory(
            ResourceProvider(requireActivity().application))

        viewModel = ViewModelProvider(requireActivity(), factory)
            .get(MoviesMainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMainListBinding.bind(view)
        viewBinding = binding

        val recyclerView: RecyclerView = viewBinding!!.mainRecyclerviewList
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        val observer = Observer<List<Movie>> { recyclerView.adapter = MoviesMainListAdapter(it) }
        viewModel.getMoviesLiveData().observe(viewLifecycleOwner, observer)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}

