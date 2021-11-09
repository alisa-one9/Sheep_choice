package com.example.sheep_choice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.sheep_choice.databinding.ItemSheepBinding
import java.util.*

class MainAdapter(private var onClick: OnItemClick?): RecyclerView.Adapter <MainAdapter.ViewHolder> (){

    private var list =arrayListOf<Int>()
     var  counterInt: Int =0
     var  counterStr:String? = null

    fun setList(list:ArrayList<Int>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(
           ItemSheepBinding.inflate(
               LayoutInflater.from(parent.context), parent,false)
       )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int =list.size



    inner class ViewHolder(private var binding: ItemSheepBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(get: Int) {
           binding.imageView.setImageResource(get)

            binding.imageView.setOnClickListener {
                if(binding.imageView.colorFilter == null){
                    binding.imageView.setColorFilter(R.color.black)
                    binding.done.visibility = View.VISIBLE
                    onClick?.onClick(get)
                    counterInt++
                    counterStr = counterInt as String





                } else {
                    binding.imageView.colorFilter = null
                    binding.done.visibility = View.INVISIBLE
                    onClick?.deleteClick(get)
                    counterInt--
                    counterStr = counterInt as String
                }
            }

        }

    }
    interface OnItemClick {

        fun onClick(image:Int)

        fun deleteClick(image:Int)

    }

}

