package com.example.tourprojecttest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CulturalSightsAdapter(
    var context: DiscoverFragment,
    var CulturalSightsList: ArrayList<CulturalModalClass>,
    var clickculturalsite: (CulturalModalClass) -> Unit,
    var likeculturalsitedata: (Int, String) -> Unit
) : RecyclerView.Adapter<CulturalSightsAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgCulturalExp: ImageView = view.findViewById(R.id.imgCulturalExp)
        var txtdetails: TextView = view.findViewById(R.id.txtdetails)
        var Loutsites: TextView = view.findViewById(R.id.loutsites)
        var culturallikeicon: ImageView = view.findViewById(R.id.culturallikeicon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.cultural_experiences_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(CulturalSightsList[position].url).into(holder.imgCulturalExp)
        holder.txtdetails.setText(CulturalSightsList[position].title)

        holder.Loutsites.setOnClickListener {
            clickculturalsite.invoke(CulturalSightsList[position])
        }

        if(CulturalSightsList[position].status==1)
        {
            holder.culturallikeicon.setImageResource(R.drawable.heartfill)
        } else {
            holder.culturallikeicon.setImageResource(R.drawable.heart)
        }

        holder.culturallikeicon.setOnClickListener {

            if (CulturalSightsList[position].status == 1) {
                likeculturalsitedata.invoke(0,CulturalSightsList[position].title)
                holder.culturallikeicon.setImageResource(R.drawable.heart)
                CulturalSightsList[position].status = 0
                Log.e(
                    "text",
                    "display:" + CulturalSightsList[position].status.toString() + " " + CulturalSightsList[position].title
                )
            } else {
                likeculturalsitedata.invoke(1,CulturalSightsList[position].title)
                holder.culturallikeicon.setImageResource(R.drawable.heartfill)
                CulturalSightsList[position].status = 1
            }
        }
    }

    override fun getItemCount(): Int {
        return CulturalSightsList.size
    }

}