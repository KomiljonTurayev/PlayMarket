package com.example.playmarket.ui.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.playmarket.R
import com.example.playmarket.dto.MockData
import kotlinx.android.synthetic.main.item_home_game.view.*

class GameAdapter : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    val list = MockData.getGame()

    var onItemClick: ((MockData.ChildData) -> Unit)? = null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.imageGame
        val textGameTitle = view.textGameTitle
        val textGameTitleBack = view.textGameTitleBack
        val textGameSize = view.textGameSize


        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
            }
        }

        fun bind(game: MockData.ChildData) {
            itemView.apply {
                Glide.with(itemView.context)
                    .load(game.image)
                    .into(itemView.imageGame)

                Glide.with(itemView.context)
                    .load(game.image)
                    .into(itemView.imageGame2)

                textGameTitle.text = game.nameApp
                textGameTitleBack.text = game.nameApp
                textGameSize.text = game.sizeApp

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_game, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount() = list.size ?: 0

}