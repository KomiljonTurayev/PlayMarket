package com.example.playmarket.ui.home.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.playmarket.R

class Tab4Fragment : Fragment() {
    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab4, container)
    }

    companion object {
        fun create(): Tab4Fragment {
            return Tab4Fragment()
        }
    }
}