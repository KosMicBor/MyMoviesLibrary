package gu_android_1032.mymovieslibrary.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gu_android_1032.mymovieslibrary.R
import gu_android_1032.mymovieslibrary.domain.Movie
import gu_android_1032.mymovieslibrary.ui.main.viewmodels.MoviesMainViewModel

class MoviesMainListAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<MoviesMainListAdapter.MoviesMainListViewHolder>() {

    private lateinit var viewModel: MoviesMainViewModel

    class MoviesMainListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTextView: TextView? = null
        var itemImage: ImageView? = null

        init {
            titleTextView = itemView.findViewById(R.id.main_list_item_title)
            itemImage = itemView.findViewById(R.id.main_list_item_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesMainListViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movies_list_item, parent, false)

        return MoviesMainListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MoviesMainListViewHolder, position: Int) {
        holder.titleTextView?.text = movies[position].originalTitle
    }

    override fun getItemCount() = movies.size
}