package com.example.recyclerviewpagination

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(var list: ArrayList<String>) :
    RecyclerView.Adapter<StudentAdapter.MyViewHolder>() {
    var listsize: Int = 10

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName: TextView = itemView.findViewById(R.id.txtName)
        var txtMobile: TextView = itemView.findViewById(R.id.txtMobile)
        var txtAddress: TextView = itemView.findViewById(R.id.txtAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.studentitem, parent, false)
        return MyViewHolder(v)

    }

    override fun getItemCount(): Int {
        return listsize
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

//
        holder.txtName.text = "${position + 1}"
//        holder.txtMobile.text = list[position].mobile
//        holder.txtAddress.text = list[position].address
//
//
//        holder.imgEditRecord.setOnClickListener {
//            onEditClick.invoke(list[position].studentId)
//
//        }

    }

    fun updateData(i: Int) {

        listsize = this.listsize + i;
        notifyDataSetChanged();

    }

    fun getSize(): Int {
        return listsize
    }

}