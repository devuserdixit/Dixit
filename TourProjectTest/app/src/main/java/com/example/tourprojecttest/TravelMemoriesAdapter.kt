package com.example.tourprojecttest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TravelMemoriesAdapter(
    var context: DiscoverFragment,
    var TravelMemoriesList: ArrayList<CulturalModalClass>,
    var clickculturalsite: (CulturalModalClass) -> Unit,var likeculturalsitedata : (Int,String) -> Unit
) : RecyclerView.Adapter<TravelMemoriesAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgCulturalExp: ImageView = view.findViewById(R.id.imgCulturalExp)
        var txtdetails: TextView = view.findViewById(R.id.txtdetails)
        var Loutsites: TextView = view.findViewById(R.id.loutsites)
        var culturallikeicon : ImageView = view.findViewById(R.id.culturallikeicon)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.cultural_experiences_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(TravelMemoriesList[position].url).into(holder.imgCulturalExp)
        holder.txtdetails.setText(TravelMemoriesList[position].title)

        holder.Loutsites.setOnClickListener {
            clickculturalsite.invoke(TravelMemoriesList[position])
        }

        if(TravelMemoriesList[position].status==1)
        {
            holder.culturallikeicon.setImageResource(R.drawable.heartfill)
        } else {
            holder.culturallikeicon.setImageResource(R.drawable.heart)
        }

        holder.culturallikeicon.setOnClickListener {

            if (TravelMemoriesList[position].status == 1) {
                likeculturalsitedata.invoke(0,TravelMemoriesList[position].title)
                holder.culturallikeicon.setImageResource(R.drawable.heart)
                TravelMemoriesList[position].status = 0
                Log.e(
                    "text",
                    "display:" + TravelMemoriesList[position].status.toString() + " " + TravelMemoriesList[position].title
                )
            } else {
                likeculturalsitedata.invoke(1,TravelMemoriesList[position].title)
                holder.culturallikeicon.setImageResource(R.drawable.heartfill)
                TravelMemoriesList[position].status = 1
            }
        }
    }

    override fun getItemCount(): Int {
        return TravelMemoriesList.size
    }
}