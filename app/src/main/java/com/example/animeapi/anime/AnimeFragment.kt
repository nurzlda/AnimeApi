package com.example.animeapi.anime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.animeapi.databinding.FragmentAnimeBinding

class AnimeFragment : Fragment() {

    private lateinit var binding: FragmentAnimeBinding
    private val adapter by lazy { AnimeAdapter() }
    private val viewModel: AnimeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
    }

    private fun init() {
        viewModel.getAnime()
        binding.rvAnime.adapter = adapter
        viewModel.myAnime.observe(viewLifecycleOwner) {
            adapter.addList(it.body()!!.data)

        }
    }

}

