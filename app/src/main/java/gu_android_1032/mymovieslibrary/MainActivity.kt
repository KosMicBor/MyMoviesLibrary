package gu_android_1032.mymovieslibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import gu_android_1032.mymovieslibrary.databinding.MainActivityBinding
import gu_android_1032.mymovieslibrary.ui.main.fragments.MoviesMainListFragment
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModel
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModelFactory

class MainActivity : AppCompatActivity(), RouterHolder {

    private val bundle = Bundle()

    override val router = MoviesMainRouter(this)

    private lateinit var viewBinding: MainActivityBinding

    private val viewModel: MoviesMainViewModel by viewModels {
        MoviesMainViewModelFactory(ResourceProvider(this.application))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = MainActivityBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        if (savedInstanceState == null) {
            router.openMainList(bundle)
        }

        val navView: BottomNavigationView = viewBinding.bottomMenu

        navView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home_button -> {
                    router.openMainList(bundle)
                }
                R.id.favorites_button -> {
                    router.openMoviesFavorites()
                }
                R.id.ratings_button -> {
                    router.openMoviesRatings()
                }
                R.id.search_button -> {
                    //TODO add search functionality
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}