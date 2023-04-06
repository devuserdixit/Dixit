package com.example.expensemanager_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(var categorylist : ArrayList<CategoryModal>,var n : ((String) -> Unit)) :
    RecyclerView.Adapter<CategoryAdapter.myview>() {
var pos =-1
    class myview(v : View) : RecyclerView.ViewHolder(v){

        var btnrb : RadioButton = v.findViewById(R.id.btnrb)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myview {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.category_item,null,false)
        val adapter = myview(v)
        return adapter
    }

    override fun onBindViewHolder(holder: myview, position: Int) {
        holder.btnrb.setText(categorylist[position].categoryName)

        n.invoke(categorylist[position].categoryName    )

        holder.btnrb.setOnClickListener{
            pos=position
            notifyDataSetChanged()
        }
        if (position==pos)
        {
            holder.btnrb.isChecked=true
        }
        else{
            holder.btnrb.isChecked=false
        }
    }

    override fun getItemCount(): Int {
        return categorylist.size
    }

}