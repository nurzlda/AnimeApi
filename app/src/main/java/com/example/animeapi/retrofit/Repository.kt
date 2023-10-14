package com.example.animeapi.retrofit


import com.example.animeapi.anime.animeModel.AnimeModel
import com.example.animeapi.manga.mangaModel.MangaModel
import retrofit2.Response


class Repository() {
    suspend fun getAnime(): Response<AnimeModel> {
        return RetrofitInstance.api.getAnime(5)
    }

    suspend fun getManga(): Response<MangaModel> {
        return RetrofitInstance.api.getManga(6)
    }

}