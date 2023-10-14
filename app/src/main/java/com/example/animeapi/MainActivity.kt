package com.example.animeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.animeapi.anime.AnimeFragment
import com.example.animeapi.databinding.ActivityMainBinding
import com.example.animeapi.manga.MangaFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(AnimeFragment())


        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.anime -> {
                    loadFragment(AnimeFragment())
                }

                R.id.manga -> {
                    loadFragment(MangaFragment())
                }
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}