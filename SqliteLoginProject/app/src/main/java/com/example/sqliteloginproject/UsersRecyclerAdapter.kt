package com.example.sqliteloginproject

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class UsersRecyclerAdapter(private val listUsers: MutableList<String>?) : RecyclerView.Adapter<UsersRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflating recycler item view
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user_recycler, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewName.text = listUsers!![position].name
        holder.textViewEmail.text = listUsers[position].email
        holder.textViewPassword.text = listUsers[position].password
    }

    override fun getItemCount(): Int {
        return listUsers!!.size
    }
    
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewName: AppCompatTextView
        var textViewEmail: AppCompatTextView
        var textViewPassword: AppCompatTextView

        init {
            textViewName = view.findViewById(R.id.textViewName) as AppCompatTextView
            textViewEmail = view.findViewById(R.id.textViewEmail) as AppCompatTextView
            textViewPassword = view.findViewById(R.id.textViewPassword) as AppCompatTextView
        }
    }
}