package com.mrsv.android.nttdata_becamobile_android_moviecatalog.data

import com.mrsv.android.nttdata_becamobile_android_moviecatalog.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=2c0b360bf4312ce2f39defb8e18a81e0")
    fun getMovieList(): Call<MovieResponse>
}