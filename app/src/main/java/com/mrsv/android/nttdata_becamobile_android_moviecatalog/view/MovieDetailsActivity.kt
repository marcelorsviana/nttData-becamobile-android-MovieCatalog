package com.mrsv.android.nttdata_becamobile_android_moviecatalog.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mrsv.android.nttdata_becamobile_android_moviecatalog.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity(){

    private val binding by lazy {
        ActivityMovieDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}