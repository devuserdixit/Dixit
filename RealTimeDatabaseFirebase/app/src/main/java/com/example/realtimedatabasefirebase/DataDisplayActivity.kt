package com.example.realtimedatabasefirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.realtimedatabasefirebase.databinding.ActivityDataDisplayBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DataDisplayActivity : AppCompatActivity() {
    lateinit var binding: ActivityDataDisplayBinding
    lateinit var adapter: StudentAdapter
    lateinit var firebaseDatabase: FirebaseDatabase
    var StudentList = ArrayList<StudentModel>()
    var id = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        firebaseDatabase = FirebaseDatabase.getInstance()
        setAdapter()
        firebaseDatabase.reference.child("StudentTb")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    StudentList.clear()
                    for (i in snapshot.children) {
                        var data = i.getValue(StudentModel::class.java)
                        Log.e(  "TAG", "OnDataChange: " + data?.fname + data?.email)

                        data?.let { it1 -> StudentList.add(it1) }

                    }
                    adapter.updateData(StudentList)
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
    }
    private fun setAdapter() {
        adapter = StudentAdapter({
            var i = Intent(this, DataUpdateActivity::class.java)
            id = it.id
            i.putExtra("id", id)
            i.putExtra("firstname", it.fname)
            i.putExtra("lastname", it.lname)
            i.putExtra("mobile", it.mobile)
            i.putExtra("email", it.email)
            i.putExtra("password",it.password)
            startActivity(i)
        }, {
            id = it
            deleteRecordFromDatabase()
        })
        var manager = LinearLayoutManager(this@DataDisplayActivity, LinearLayoutManager.VERTICAL, false)
        binding.rcvDisplayData.layoutManager = manager
        binding.rcvDisplayData.adapter = adapter
    }

    private fun deleteRecordFromDatabase() {
        firebaseDatabase.reference.child("StudentTb").child(id).removeValue()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "record deleted Successfully", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener {
                Log.e("TAG", "deleteRecordFromDatabase: " + it.message)
            }
    }

}