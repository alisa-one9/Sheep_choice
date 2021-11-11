package com.example.sheep_choice


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sheep_choice.databinding.ActivityFavoritesBinding

class FavoritesActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private lateinit var binding: ActivityFavoritesBinding
    private var content: ActivityResultLauncher<String>? = null
    private  var str: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
        selectFromMyGallery()

    }

    private fun initRecycler() {

        adapter= MainAdapter(null)
        intent.getIntegerArrayListExtra(MainActivity.IMAGE_KEY)?.let{adapter.setList(it)}
        binding.rvFavorites.adapter =adapter
    }
    private fun selectFromMyGallery() {

        binding.btnSelectFromMyGallery.setOnClickListener {
            content?.launch("image/*")
        }
        content = registerForActivityResult(
            ActivityResultContracts.GetContent()) { result ->
            if (result != null) {

                binding.imageFrom.setImageURI(result)
            }
            str = result.toString()
        }
    }
}