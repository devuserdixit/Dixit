package com.example.masterproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CulturalWorldAdapter(var context: DiscoverFragment,var CulturalWorldList : ArrayList<CulturalModalClass>) : RecyclerView.Adapter<CulturalWorldAdapter.MyViewHolder>() {
    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var imgCulturalExp : ImageView = view.findViewById(R.id.imgCulturalExp)
        var txtdetails : TextView = view.findViewById(R.id.txtdetails)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.cultural_experiences_item,parent,false)
        var view = CulturalWorldAdapter.MyViewHolder(v)
        return view
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        Glide.with(context).load(CulturalWorldList[position].image).into(holder.imgCulturalExp)
        holder.txtdetails.setText(CulturalWorldList[position].name)
    }

    override fun getItemCount(): Int {
        return CulturalWorldList.size
    }
}
