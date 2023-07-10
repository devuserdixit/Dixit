package com.example.masterproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CulturalSightsAdapter(var context: DiscoverFragment,var CulturalSightsList : ArrayList<CulturalModalClass>): RecyclerView.Adapter<CulturalSightsAdapter.MyViewHolder>() {
    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var imgCulturalExp : ImageView = view.findViewById(R.id.imgCulturalExp)
        var txtdetails : TextView = view.findViewById(R.id.txtdetails)
        var crdimage : CardView = view.findViewById(R.id.crdimage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.cultural_experiences_item,parent,false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        Glide.with(context).load(CulturalSightsList[position].image).into(holder.imgCulturalExp)
        holder.txtdetails.setText(CulturalSightsList[position].name)

//        holder.crdimage.setOnClickListener {
//            OnClick.invoke(CulturalSightsList[position])
//        }
    }

    override fun getItemCount(): Int {
        return CulturalSightsList.size
    }

}