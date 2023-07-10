package com.example.retrofitapicalling

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import java.util.Objects

class ProductDisplayAdapter(var context: Context,var images : ArrayList<String>?) : PagerAdapter(){
    override fun getCount(): Int {
        return images!!.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ImageView
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView : View = LayoutInflater.from(context).inflate(R.layout.imageslider_item,container,false)
        val imageView : ImageView = itemView.findViewById(R.id.viewpagerscroll)

        Glide.with(context).load("${images!![position]}").into(imageView)
        Objects.requireNonNull(container).addView(itemView)

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ImageView)
    }

}