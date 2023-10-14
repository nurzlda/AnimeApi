package com.example.animeapi

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.animeapi.anime.animeModel.PosterImage

fun ImageView.loadImage(url: String){
    Glide.with(this).load(url).into(this)
}