package com.example.sheep_choice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.sheep_choice.databinding.ActivityFavoritesBinding

class FavoritesActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private lateinit var binding: ActivityFavoritesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        initRecycler()
    }

    private fun initRecycler() {

        adapter= MainAdapter(null)
        intent.getIntegerArrayListExtra(MainActivity.IMAGE_KEY)?.let{adapter.setList(it)}
        binding.rvFavorites.adapter =adapter
    }
}