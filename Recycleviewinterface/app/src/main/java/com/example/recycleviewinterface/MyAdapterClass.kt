package com.example.recycleviewinterface

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapterClass (val list : ArrayList<ModalClass>) : RecyclerView.Adapter<MyAdapterClass.MyViewHolder>(){
    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var txtid : TextView = view.findViewById(R.id.txtid)
        var txtname : TextView = view.findViewById(R.id.txtname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       var view=LayoutInflater.from(parent.context).inflate(R.layout.iteam_display,parent,false)
        var myViewHolder = MyViewHolder(view)
        return myViewHolder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtid.setText(list[position].id.toString())
        holder.txtname.setText(list[position].name.toString())
    }
}