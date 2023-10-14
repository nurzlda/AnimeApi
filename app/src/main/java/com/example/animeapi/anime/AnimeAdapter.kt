package com.example.animeapi.anime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animeapi.anime.animeModel.Attributes
import com.example.animeapi.anime.animeModel.Data
import com.example.animeapi.anime.animeModel.PosterImage
import com.example.animeapi.databinding.ItemAnimeBinding
import com.example.animeapi.loadImage

class AnimeAdapter() :
    RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private var animeList = emptyList<Data>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimeViewHolder {
        return AnimeViewHolder(
            ItemAnimeBinding.inflate
                (LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        return holder.onBind(animeList[position])
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: Data) {

            binding.tvNameAnime.text = data.attributes.canonicalTitle
            binding.tvCountAnime.text = data.attributes.episodeCount.toString() + " series"
            binding.ivAnime.loadImage(data.attributes.posterImage.original)


        }
    }

    fun addList(list: List<Data>) {
        animeList = list
        notifyDataSetChanged()
    }
}