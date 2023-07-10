package com.example.shayariapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class CategoryAdapter( var categoryList: ArrayList<CategoryModalClass>,var onclick : (CategoryModalClass) -> Unit) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtname : TextView = view.findViewById(R.id.txtname)
        var layout: LinearLayout = view.findViewById(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MyViewHolder {
        var v= LayoutInflater.from(parent.context).inflate(R.layout.category_list,parent,false)
        var view = MyViewHolder(v)
        return view
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        holder.txtname.text = categoryList[position].categoryName
        holder.layout.setOnClickListener {

            onclick.invoke(categoryList[position])
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}