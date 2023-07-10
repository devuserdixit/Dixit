package com.example.masterproject2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TravelMemoriesAdapter(var context: DiscoverFragment,var TravelMemoriesList : ArrayList<CulturalModalClass>) : RecyclerView.Adapter<TravelMemoriesAdapter.MyViewHolder>() {
    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var imgCulturalExp : ImageView = view.findViewById(R.id.imgCulturalExp)
        var txtdetails : TextView = view.findViewById(R.id.txtdetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.cultural_experiences_item,parent,false)
        var view = TravelMemoriesAdapter.MyViewHolder(v)
        return view
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        Glide.with(context).load(TravelMemoriesList[position].image).into(holder.imgCulturalExp)
        holder.txtdetails.setText(TravelMemoriesList[position].name)
    }

    override fun getItemCount(): Int {
        return TravelMemoriesList.size
    }
}