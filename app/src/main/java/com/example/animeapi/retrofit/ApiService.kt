package com.example.animeapi.retrofit

import com.example.animeapi.anime.animeModel.AnimeModel
import com.example.animeapi.anime.animeModel.Data
import com.example.animeapi.manga.mangaModel.MangaModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/edge/anime")
    suspend fun getAnime(
        @Query("page[limit]") limit: Int
    ): Response<AnimeModel>

    @GET("/api/edge/manga")
    suspend fun getManga(
        @Query("page[limit]") limit: Int
    ): Response<MangaModel>
}