package com.example.playmarket.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.playmarket.R
import com.example.playmarket.ui.home.adapters.GameAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        ll_top.setOnClickListener {
////            view.findNavController().navigate(R.id.nav_news_back)
//        }
//        ll_middle.setOnClickListener {
////            view.findNavController().navigate(R.id.nav_kategory_back)
//        }
//        ll_bottom.setOnClickListener {
////            view.findNavController().navigate(R.id.nav_kategory_back)
//        }
//
//        val recyclerViewGame = view.findViewById<RecyclerView>(R.id.recyclerGame)
//        val recyclerCategory = view.findViewById<RecyclerView>(R.id.recyclerCategory)
//        val recyclerCategoryBottom = view.findViewById<RecyclerView>(R.id.recyclerCategoryBottom)
//
//        recyclerViewGame.layoutManager =
//            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        recyclerCategory.layoutManager =
//            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        recyclerCategoryBottom.layoutManager =
//            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//
//        val mAdapter = GameAdapter()
////        val mAdapterKategory = KategoryAdapter()
////        val mAdapterNovosti = NewsAdapter()
//
//        recyclerViewGame.adapter = mAdapter
//        recyclerCategory.adapter = mAdapter
//        recyclerCategoryBottom.adapter = mAdapter
//        recyclerViewKaregory.adapter = mAdapterKategory
//        recyclerViewNovosti.adapter = mAdapterNovosti

        renderViewPager()
        renderTabLayer()

    }
    private fun renderViewPager() {

        viewpager.isUserInputEnabled = false

        viewpager.adapter = object : FragmentStateAdapter(this) {

            override fun createFragment(position: Int): Fragment {
                return ResourceStore.pagerFragments[position]
            }

            override fun getItemCount(): Int {
                return ResourceStore.tabList.size
            }
        }
    }

    private fun renderTabLayer() {
        TabLayoutMediator(tabs, viewpager) { tab, position ->
            tab.text = getString(ResourceStore.tabList[position])
        }.attach()
    }
}

