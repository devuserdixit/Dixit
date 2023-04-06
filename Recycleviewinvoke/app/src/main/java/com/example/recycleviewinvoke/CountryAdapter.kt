package com.example.recycleviewinvoke

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(val list : ArrayList<CountryModal>,var d:((Int,String) -> Unit)) : RecyclerView.Adapter<CountryAdapter.MyViewHolder>() {
    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        var txtcode : TextView = view.findViewById(R.id.txtcode)
        var txtcountry : TextView = view.findViewById(R.id.txtcountry)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.data_display,parent,false)
        var myViewHolder = MyViewHolder(view)
        return myViewHolder
    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        holder.txtcode.setText(list[position].countrycode.toString())
        holder.txtcountry.setText(list[position].name.toString())

    }


}