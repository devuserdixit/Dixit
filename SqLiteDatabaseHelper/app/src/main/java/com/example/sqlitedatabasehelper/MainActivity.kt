package com.example.sqlitedatabasehelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqlitedatabasehelper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var db : MyDatabaseHelper
    lateinit var binding : ActivityMainBinding
    lateinit var adapter : StudentAdapter
    var list : ArrayList<StudentModalClass> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         db = MyDatabaseHelper(this)

        adapter = StudentAdapter()
        var manager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rcvlist.layoutManager=manager
        binding.rcvlist.adapter=adapter

        initview()
    }

    private fun initview() {
        binding.btnsubmit.setOnClickListener{
            val name = binding.edtname.text.toString()
            val mobile = binding.edtmobile.text.toString()
            val gender = binding.edtgender.text.toString()
            val fees = binding.edtfee.text.toString()

            db.insertRecord(name,mobile,gender,fees)
        }

        binding.btndisplay.setOnClickListener{
            list =  db.displayRecords()
            adapter.updateData(list)

        }
    }
}