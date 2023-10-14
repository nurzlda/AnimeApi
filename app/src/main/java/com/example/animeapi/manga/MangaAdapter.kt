package com.example.animeapi.manga

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.animeapi.databinding.ItemMangaBinding
import com.example.animeapi.loadImage
import com.example.animeapi.manga.mangaModel.Data
import android.content.Context
import com.example.animeapi.R

class MangaAdapter() :
    RecyclerView.Adapter<MangaAdapter.MangaViewHolder>() {

    private var mangaList = emptyList<Data>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MangaViewHolder {
        return MangaViewHolder(
            ItemMangaBinding.inflate
                (LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        return holder.onBind(mangaList[position])
    }

    override fun getItemCount(): Int {
        return mangaList.size
    }

    inner class MangaViewHolder(private val binding: ItemMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun onBind(data: Data) {
            binding.tvNameManga.text = data.attributes.canonicalTitle
            binding.tvVolumeCountManga.text = data.attributes.volumeCount.toString() + " volumes"
            binding.ivManga.loadImage(data.attributes.posterImage.original)

        }
    }

    fun addList(list: List<Data>) {
        mangaList = list
        notifyDataSetChanged()
    }
}