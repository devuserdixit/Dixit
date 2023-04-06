package com.example.shayariapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shayariapp.activity.CategoryAdapter
import com.example.shayariapp.activity.ModalClass
import com.example.shayariapp.activity.MyDatabase
import com.example.shayariapp.activity.ShayariModalClass
import com.example.shayariapp.databinding.ActivityShayariDisplayBinding

class Shayari_Display_Activity : AppCompatActivity() {

    lateinit var binding : ActivityShayariDisplayBinding
    lateinit var db1 : MyDatabase

    var flag = false

    var List = ArrayList<ModalClass>()

    lateinit var adapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShayariDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db1 = MyDatabase(this)

        initview()
    }

    private fun initview() {
        var categoryName : String? = intent.getStringExtra("Title")
        binding.txtDisplayTitle.text=categoryName

        var c_ID = intent.getIntExtra("Id",0)
        List = db1.ShayarireadData(c_ID)

        adapter = CategoryAdapter(List,{

        })
        var manager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rcvCategory.layoutManager = manager
        binding.rcvCategory.adapter = adapter
    }
}