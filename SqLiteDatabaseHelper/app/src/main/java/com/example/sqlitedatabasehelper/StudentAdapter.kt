package com.example.sqlitedatabasehelper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter() : RecyclerView.Adapter<StudentAdapter.MyViewHolder>(){
     var list:ArrayList<StudentModalClass> = ArrayList()
    var pos = -1

    class MyViewHolder (view : View) : RecyclerView.ViewHolder(view){
        var txtname : TextView = view.findViewById(R.id.txtname)
        var txtmobile : TextView = view.findViewById((R.id.txtmobile))
        var txtgender : TextView = view.findViewById((R.id.txtgender))
        var txtfees : TextView = view.findViewById((R.id.txtfees))
        var radio : RadioButton = view.findViewById((R.id.radio))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.MyViewHolder {
        var dna = LayoutInflater.from(parent.context).inflate(R.layout.details_display,null,false)
        return MyViewHolder(dna)
    }

    override fun onBindViewHolder(holder: StudentAdapter.MyViewHolder, position: Int) {
        holder.txtname.setText(list[position].name)
        holder.txtmobile.setText(list[position].mobile)
        holder.txtgender.setText(list[position].gender)
        holder.txtfees.setText(list[position].fees)

        holder.radio.setOnClickListener{
            pos = position
            notifyDataSetChanged()
        }
        if (position == pos)
        {
            holder.radio.isChecked = true
        }
        else{
            holder.radio.isChecked = false
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateData(list: ArrayList<StudentModalClass>){
        this.list = list
        notifyDataSetChanged()
    }
}