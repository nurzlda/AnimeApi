package com.example.animeapi.manga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.animeapi.databinding.FragmentMangaBinding
import com.example.animeapi.manga.mangaModel.MangaModel

class MangaFragment : Fragment() {

    private lateinit var binding: FragmentMangaBinding
    private var mangaAdapter = MangaAdapter()
    private val viewModel: MangaViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMangaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        init()
    }

    private fun init() {
        viewModel.getManga()
        binding.rvManga.adapter = mangaAdapter
        viewModel.myManga.observe(viewLifecycleOwner) {
            mangaAdapter.addList(it.body()!!.data)
        }
    }
}
