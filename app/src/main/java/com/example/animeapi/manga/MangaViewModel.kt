package com.example.animeapi.manga

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animeapi.manga.mangaModel.MangaModel
import com.example.animeapi.retrofit.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MangaViewModel() : ViewModel() {
    private val repository = Repository()
    val myManga: MutableLiveData<Response<MangaModel>> = MutableLiveData()

    fun getManga() {
        viewModelScope.launch {
            myManga.value = repository.getManga()
        }
    }
}