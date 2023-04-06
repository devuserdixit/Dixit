package com.example.shayariapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shayariapp.Shayari_Display_Activity
import com.example.shayariapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var db : MyDatabase

    lateinit var adapter : CategoryAdapter

    var categoryList = ArrayList<ModalClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = MyDatabase(this)
        initview()
    }

     fun initview() {

         categoryList = db.readData()
        adapter = CategoryAdapter(categoryList)
//        {
//            var i = Intent(this,Shayari_Display_Activity::class.java)
//            i.putExtra("Title",it.categoryName)
//            i.putExtra("Id",it.id)
//
//            Log.e("TAG", "initview: "+it.id )
//            startActivity(i)
//        }


        var manager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rcvCategory.layoutManager = manager
        binding.rcvCategory.adapter = adapter
    }
}