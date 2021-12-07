package com.example.playmarket.ui.home.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.playmarket.R
import com.example.playmarket.ui.home.adapters.GameAdapter
import kotlinx.android.synthetic.main.fragment_tab1.*

class Tab1Fragment : Fragment(R.layout.fragment_tab1) {




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ll_top.setOnClickListener {
//            view.findNavController().navigate(R.id.nav_news_back)
        }
        ll_middle.setOnClickListener {
//            view.findNavController().navigate(R.id.nav_kategory_back)
        }
        ll_bottom.setOnClickListener {
//            view.findNavController().navigate(R.id.nav_kategory_back)
        }

        val recyclerViewGame = view.findViewById<RecyclerView>(R.id.recyclerGame)
        val recyclerCategory = view.findViewById<RecyclerView>(R.id.recyclerCategory)
        val recyclerCategoryBottom = view.findViewById<RecyclerView>(R.id.recyclerCategoryBottom)

        recyclerViewGame.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerCategory.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerCategoryBottom.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        val mAdapter = GameAdapter()
//        val mAdapterKategory = KategoryAdapter()
//        val mAdapterNovosti = NewsAdapter()

        recyclerViewGame.adapter = mAdapter
        recyclerCategory.adapter = mAdapter
        recyclerCategoryBottom.adapter = mAdapter
//        recyclerViewKaregory.adapter = mAdapterKategory
//        recyclerViewNovosti.adapter = mAdapterNovosti


    }

    companion object {
        fun create(): Tab1Fragment {
            return Tab1Fragment()
        }
    }
}