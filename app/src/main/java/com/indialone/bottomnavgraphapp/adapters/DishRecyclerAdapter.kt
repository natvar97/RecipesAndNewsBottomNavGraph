package com.indialone.bottomnavgraphapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indialone.bottomnavgraphapp.R
import com.indialone.bottomnavgraphapp.api.dish.RecipesItem
import com.indialone.bottomnavgraphapp.databinding.DishItemLayoutBinding

class DishRecyclerAdapter(
    private val dishes : ArrayList<RecipesItem>
) : RecyclerView.Adapter<DishRecyclerAdapter.DishRecyclerViewHolder>() {
    class DishRecyclerViewHolder(itemView: DishItemLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        val tvTitle = itemView.tvDishTitle
        val tvType = itemView.tvDishType
        val ivDish = itemView.ivDish

        fun bind(dish : RecipesItem) {
            tvTitle.text = dish.title
            tvType.text = "${dish.dishTypes}"
            Glide.with(itemView.context)
                .load(dish.image)
                .centerCrop()
                .into(ivDish)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishRecyclerViewHolder {
        val view = DishItemLayoutBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return DishRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishRecyclerViewHolder, position: Int) {
        val dish = dishes[position]
        holder.bind(dish)

    }

    override fun getItemCount(): Int {
        return dishes.size
    }
}