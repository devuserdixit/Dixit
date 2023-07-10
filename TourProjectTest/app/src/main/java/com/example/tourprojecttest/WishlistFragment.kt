package com.example.tourprojecttest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tourprojecttest.databinding.FragmentWishlistBinding

class WishlistFragment : Fragment() {

    lateinit var Wishlistbinding: FragmentWishlistBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Wishlistbinding = FragmentWishlistBinding.inflate(layoutInflater, container, false)

        initView()
        return Wishlistbinding.root
    }

    private fun initView() {

    }
}