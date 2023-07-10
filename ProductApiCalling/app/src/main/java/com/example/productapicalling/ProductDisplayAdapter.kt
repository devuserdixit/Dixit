package com.example.productapicalling

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import java.util.Objects

class ProductDisplayAdapter(var context : Context,var ProductList :ArrayList<String>) : PagerAdapter() {
    override fun getCount(): Int {
        return ProductList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ImageView
    }

    @SuppressLint("MissingInflatedId")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView : View = LayoutInflater.from(container.context).inflate(R.layout.products_display_list,container,false)
        val imageView : ImageView = itemView.findViewById(R.id.viewpager)

        Glide.with(context).load("${ProductList[position]}").into(imageView)
        Objects.requireNonNull(container).addView(itemView)

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ImageView)
    }
}