package com.example.shayariapplication

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class DisplayCategoryAdapter(
    var shayariList: ArrayList<DisplayCategoryModelClass>,
    var click: (DisplayCategoryModelClass) -> Unit,
    var like : (Int , Int) -> Unit)  : RecyclerView.Adapter<DisplayCategoryAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var layout: CardView = view.findViewById(R.id.layout)
        var txtshayari: TextView = view.findViewById(R.id.txtshayari)
        var imglike : ImageView = view.findViewById(R.id.imglike)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.display_category_data, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return shayariList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtshayari.text = shayariList[position].Shayari_item

        holder.layout.setOnClickListener{
            click.invoke(shayariList[position])
        }

        if (shayariList[position].fav == 1){
            holder.imglike.setImageResource(R.drawable.heartcolor)
        }else{
            holder.imglike.setImageResource(R.drawable.heart)
        }
        holder.imglike.setOnClickListener{
            if (shayariList[position].fav == 1){
                like.invoke(shayariList[position].Shayari_id,0)
                holder.imglike.setImageResource(R.drawable.heart)
                shayariList[position].fav = 0
                Log.e("TAG", "onBindViewHolder: "+shayariList[position].fav)
            }else{
                like.invoke(shayariList[position].Shayari_id,1)
                holder.imglike.setImageResource(R.drawable.heartcolor)
                shayariList[position].fav = 1
            }
        }
    }
    fun updatelist(shayariList : ArrayList<DisplayCategoryModelClass>){
        this.shayariList = ArrayList()
        this.shayariList.addAll(shayariList)
        notifyDataSetChanged()
    }
}