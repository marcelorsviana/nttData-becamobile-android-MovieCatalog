package com.mrsv.android.nttdata_becamobile_android_moviecatalog.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrsv.android.nttdata_becamobile_android_moviecatalog.view.adapter.MovieAdapter
import com.mrsv.android.nttdata_becamobile_android_moviecatalog.R
import com.mrsv.android.nttdata_becamobile_android_moviecatalog.models.Movie
import com.mrsv.android.nttdata_becamobile_android_moviecatalog.models.MovieResponse
import com.mrsv.android.nttdata_becamobile_android_moviecatalog.data.MovieApiInterface
import com.mrsv.android.nttdata_becamobile_android_moviecatalog.data.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies : List<Movie> ->
            rv_movies_list.adapter = MovieAdapter(movies)
        }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {}

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }
}