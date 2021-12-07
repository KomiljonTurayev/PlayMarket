package com.example.playmarket.ui.home

import com.example.playmarket.R
import com.example.playmarket.ui.home.tabs.Tab1Fragment
import com.example.playmarket.ui.home.tabs.Tab2Fragment
import com.example.playmarket.ui.home.tabs.Tab3Fragment
import com.example.playmarket.ui.home.tabs.Tab4Fragment

interface ResourceStore {
    companion object {
        val tabList = listOf(
            R.string.tab1, R.string.tab2, R.string.tab3, R.string.tab4
        )
        val pagerFragments = listOf(
            Tab1Fragment.create(), Tab2Fragment.create(),
            Tab3Fragment.create(), Tab4Fragment.create())
    }
}