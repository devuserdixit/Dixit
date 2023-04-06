package com.example.shayariapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shayariapplication.databinding.ActivityDisplayCategoryBinding

class DisplayCategoryActivity : AppCompatActivity() {

    lateinit var binding : ActivityDisplayCategoryBinding
    lateinit var dbD : MyDatabase

    var shayariList = ArrayList<DisplayCategoryModelClass>()

    lateinit var adapter : CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbD = MyDatabase(this)

        initview()
    }

    private fun initview() {
        var categoryName : String? = intent.getStringExtra("Title")
        binding.txtDisplayTitle.text = categoryName

        var c_ID = intent.getIntExtra("Id",0)
        shayariList = dbD.ShatariData(c_ID)

        adapter = DisplayCategoryModelClass(shayariList,{
            var i =
        })
    }
}