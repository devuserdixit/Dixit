package com.example.shayariapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FavoriteAdapter(var like: (Int, Int) -> Unit) :
    RecyclerView.Adapter<FavoriteAdapter.MyViewHolder>() {

    var list = ArrayList<FavoriteModalClass>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtshayari: TextView = view.findViewById(R.id.txtshayari)
        var imglike: ImageView = view.findViewById(R.id.imglike)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.display_category_data, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtshayari.text = list[position].Shayari_item

        holder.imglike.setImageResource(R.drawable.heartcolor)

        holder.imglike.setOnClickListener {
            like.invoke(list[position].Shayari_id, 0)
            holder.imglike.setImageResource(R.drawable.heart)
            list[position].fav = 0
            deleteItem(position)
        }
    }

    fun updateList(list: ArrayList<FavoriteModalClass>) {
        this.list = list
        notifyDataSetChanged()
    }

    private fun deleteItem(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, list.size)
    }

}