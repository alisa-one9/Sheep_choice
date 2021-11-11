package com.example.sheep_choice

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.appcompat.app.AppCompatActivity
import com.example.sheep_choice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter:MainAdapter
    private var list = arrayListOf<Int>()





    private var secondList =arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createList()
        initRecycler()

        btnFavorites()
    }




    private fun createList() {
        for(i in 1..30) {
            list.add(R.drawable.smoll_sheep1)
            list.add(R.drawable.smoll_sheep2)
            list.add(R.drawable.smoll_sheep3)
            list.add(R.drawable.smoll_sheep4)
            list.add(R.drawable.smoll_sheep5)
        }
    }

    private fun initRecycler() {
        adapter = MainAdapter(object : MainAdapter.OnItemClick {
            override fun onClick(image: Int) {
                secondList.add(image)
                binding.counterCardView.text = adapter.counterInt.toString()

            }

            override fun deleteClick(image: Int) {
                secondList.remove(image)
                binding.counterCardView.text = adapter.counterInt.toString()

            }

        })
        adapter.setList(list)
        binding.rvSheep.adapter =adapter


    }
    private fun btnFavorites() {
        val intent = Intent(this, FavoritesActivity::class.java)
        binding.btnGoSecondActivity.setOnClickListener{
            intent.putExtra(IMAGE_KEY, secondList)
            startActivity(intent)

        }
    }
    companion object{
        const val IMAGE_KEY ="images"
    }
}