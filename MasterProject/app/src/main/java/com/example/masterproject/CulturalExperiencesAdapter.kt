package com.example.masterproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CulturalExperiencesAdapter(var context: DiscoverFragment,var CulturalExperiencesList : ArrayList<CulturalModalClass>) : RecyclerView.Adapter<CulturalExperiencesAdapter.MyViewHolder>() {
    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var imgCulturalExp : ImageView = view.findViewById(R.id.imgCulturalExp)
        var txtdetails : TextView = view.findViewById(R.id.txtdetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.cultural_experiences_item,parent,false)
        var view = MyViewHolder(v)
        return view
    }

    override fun getItemCount(): Int {
        return CulturalExperiencesList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int){
        Glide.with(context).load(CulturalExperiencesList[position].image).into(holder.imgCulturalExp)
        holder.txtdetails.setText(CulturalExperiencesList[position].name)
    }
}