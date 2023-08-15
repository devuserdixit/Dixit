package com.example.retrofitapipractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var list: List<ResponseModalItem>?) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var id: TextView = view.findViewById(R.id.txtid)
        var title: TextView = view.findViewById(R.id.txttitle)
        var body: TextView = view.findViewById(R.id.txtbody)
        var userid: TextView = view.findViewById(R.id.txtuserid)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = list!![position].id.toString()
        holder.title.text = list!![position].title.toString()
        holder.body.text = list!![position].body.toString()
        holder.userid.text = list!![position].userId.toString()
    }
}