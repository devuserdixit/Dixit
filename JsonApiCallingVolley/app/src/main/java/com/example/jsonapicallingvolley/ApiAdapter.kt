package com.example.jsonapicallingvolley

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ApiAdapter(var list : ArrayList<ResponseItem>): RecyclerView.Adapter<ApiAdapter.MyViewHolder>() {

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var txtid : TextView = view.findViewById(R.id.txtid)
        var txtuserid : TextView = view.findViewById(R.id.txtuserid)
        var txttitle : TextView = view.findViewById(R.id.txttitle)
        var txtbody : TextView = view.findViewById(R.id.txtbody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiAdapter.MyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.display_record,parent,false)
        var view = MyViewHolder(v)
        return view
    }

    override fun onBindViewHolder(holder: ApiAdapter.MyViewHolder, position: Int) {
        holder.txtid.text = list[position].id.toString()
        holder.txtuserid.text = list[position].userId.toString()
        holder.txttitle.text = list[position].title
        holder.txtbody.text = list[position].body
    }

    override fun getItemCount(): Int {
       return list.size
    }
}