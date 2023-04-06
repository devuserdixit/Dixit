package com.example.shayariapp.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shayariapp.R

class CategoryAdapter( var categoryList: ArrayList<ModalClass>,var n : (ShayariModalClass) -> Unit)) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtname : TextView = view.findViewById(R.id.txtname)
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MyViewHolder {
        var v= LayoutInflater.from(parent.context).inflate(R.layout.category_list,parent,false)
        var view = MyViewHolder(v)
        return view
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        holder.txtname.text = categoryList[position].categoryName
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}