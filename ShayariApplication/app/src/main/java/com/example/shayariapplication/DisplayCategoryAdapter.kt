package com.example.shayariapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DisplayCategoryAdapter(
    var shayariList: ArrayList<DisplayCategoryAdapter>,
    var click: (DisplayCategoryModelClass) -> Unit
) : RecyclerView.Adapter<DisplayCategoryAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var layout: LinearLayout = view.findViewById(R.id.layout)
        var txtshayari: TextView = view.findViewById(R.id.txtshayari)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.display_category_data, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return shayariList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtshayari
    }
}