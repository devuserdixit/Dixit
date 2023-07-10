package com.example.realtimedatabasefirebase

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(var onEdit: (StudentModel) -> Unit, var onDelete: (String) -> Unit) :
    RecyclerView.Adapter<StudentAdapter.MyViewHolder>() {
    var StudentList = ArrayList<StudentModel>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtFname: TextView = view.findViewById(R.id.txtFname)
        var txtLname: TextView = view.findViewById(R.id.txtLname)
        var txtMobile: TextView = view.findViewById(R.id.txtMobile)
        var txtEmail: TextView = view.findViewById(R.id.txtEmail)
        var txtPassword: TextView = view.findViewById(R.id.txtPassword)

        var txtEdit: TextView = view.findViewById(R.id.txtEdit)
        var txtDelete: TextView = view.findViewById(R.id.txtDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.display_details_file, parent, false)
        return MyViewHolder(v)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            txtFname.text = StudentList[position].fname
            txtLname.text = StudentList[position].lname
            txtMobile.text = StudentList[position].mobile
            txtEmail.text = StudentList[position].email
            txtPassword.text = StudentList[position].password


            holder.txtEdit.setOnClickListener {
                onEdit.invoke(StudentList[position])
            }
            holder.txtDelete.setOnClickListener {
                onDelete.invoke(StudentList[position].id)
            }
        }
    }

    override fun getItemCount(): Int {
        return StudentList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(StudentList: ArrayList<StudentModel>) {
        this.StudentList = StudentList
        notifyDataSetChanged()


    }
}