package com.example.animeapi.anime

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animeapi.anime.animeModel.AnimeModel
import com.example.animeapi.anime.animeModel.Attributes
import com.example.animeapi.retrofit.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class AnimeViewModel() : ViewModel() {
    private val repository = Repository()
    val myAnime: MutableLiveData<Response<AnimeModel>> = MutableLiveData()

    fun getAnime() {
        viewModelScope.launch {
            myAnime.value = repository.getAnime()
        }
    }
}