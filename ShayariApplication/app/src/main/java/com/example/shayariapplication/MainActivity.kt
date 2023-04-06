package com.example.shayariapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shayariapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var db : MyDatabase

    lateinit var adapter : CategoryAdapter

    var categoryList = ArrayList<CategoryModalClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = MyDatabase(this)
        initview()
    }

    fun initview() {

        categoryList = db.readData()
        adapter = CategoryAdapter(categoryList){
            var i = Intent(this,DisplayCategoryActivity::class.java)
            i.putExtra("Titile",it.categoryName)
            i.putExtra("Id",it.id)

            Log.e("TAG", "initview: "+it.id)
        }
        var manager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rcvCategory.layoutManager = manager
        binding.rcvCategory.adapter = adapter

    }

}