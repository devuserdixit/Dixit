package com.example.shayariapp.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shayariapp.R

class DisplayShayariAdapter(var List : ArrayList<ShayariModalClass>) : RecyclerView.Adapter<DisplayShayariAdapter.MyViewHolder>(){
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtdisplay : TextView = view.findViewById(R.id.txtdisplay)
        var layout : LinearLayout = view.findViewById(R.id.layout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v= LayoutInflater.from(parent.context).inflate(R.layout.activity_shayari_display,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtdisplay.text = List[position].Shayari

    }

}