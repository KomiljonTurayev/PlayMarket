package com.example.playmarket.ui.home.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.playmarket.R

class Tab2Fragment : Fragment() {
    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab2, container)
    }

    companion object {
        fun create(): Tab2Fragment {
            return Tab2Fragment()
        }
    }
}