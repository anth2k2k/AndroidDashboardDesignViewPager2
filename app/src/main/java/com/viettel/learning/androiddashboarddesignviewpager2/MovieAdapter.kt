package com.viettel.learning.androiddashboarddesignviewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView

class MovieAdapter(private val movies: MutableList<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_container_movies,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.setMovie(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imagePoster: RoundedImageView
        val textName: TextView
        val textCategory: TextView
        val textReleaseDate: TextView
        val ratingBar: RatingBar

        init {
            imagePoster = itemView.findViewById(R.id.imagePoster)
            textName = itemView.findViewById(R.id.textName)
            textCategory = itemView.findViewById(R.id.textCategory)
            textReleaseDate = itemView.findViewById(R.id.textReleaseDate)
            ratingBar = itemView.findViewById(R.id.ratingBar)
        }

        fun setMovie(movie: Movie) {
            imagePoster.setImageResource(movie.poster)
            textName.setText(movie.name)
            textCategory.setText(movie.category)
            textReleaseDate.setText(movie.releaseDate)
            ratingBar.rating = movie.rating
        }
    }
}