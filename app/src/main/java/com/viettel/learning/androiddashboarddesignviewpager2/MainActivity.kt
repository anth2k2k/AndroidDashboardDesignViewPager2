package com.viettel.learning.androiddashboarddesignviewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.viettel.learning.androiddashboarddesignviewpager2.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupMoviesViewPager()
    }

    private fun setupMoviesViewPager() {
        val viewPagerMovies: ViewPager2 = binding.viewPagerMovies
        viewPagerMovies.clipToPadding = false
        viewPagerMovies.clipChildren = false
        viewPagerMovies.offscreenPageLimit = 3
        viewPagerMovies.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val compositePageTransformer: CompositePageTransformer =  CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(10))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }
        viewPagerMovies.setPageTransformer(compositePageTransformer)
        viewPagerMovies.adapter = MovieAdapter(getMovies())
    }

    private fun getMovies(): MutableList<Movie> {
        var movies: MutableList<Movie> = arrayListOf()

        val passengers =
            Movie(
                "Passengers",
                "Science Fiction",
                "December 14, 2016",
                R.drawable.passengers,
                4.6f)
        val theTomorrowWar = Movie(
            "The Tomorrow War",
            "Science Fiction",
            "July 2, 2021",
            R.drawable.thetomorrowwar,
            4.0f
        )
        val theMartians = Movie(
            "The Martians",
            "Science Fiction",
            "October 2, 2015",
            R.drawable.themartians,
            4.7f
        )
        val bladeRunner2049 = Movie(
            "Blade Runner 2049",
            "Science Fiction",
            "October 5, 2017",
            R.drawable.bladerunner2049,
            4.1f
        )

        movies.add(passengers)
        movies.add(theTomorrowWar)
        movies.add(theMartians)
        movies.add(bladeRunner2049)

        return movies
    }
}