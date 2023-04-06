package com.example.expensemanager_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.expensemanager_1.databinding.ActivityAddCategoryBinding
import layout.CategoryAdapter
import layout.DataHelperClass

class AddCategory_Activity : AppCompatActivity() {

    lateinit var binding : ActivityAddCategoryBinding
    lateinit var db : DataHelperClass
    var datalist = ArrayList<CategoryAdapter>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DataHelperClass(this)

        category()
    }

    private fun category() {
        binding.btnadd.setOnClickListener{
            val name = binding.edtcategory.text.toString()
            db.inseart(name)
            datalist = db.display()
        }
        binding.imgback.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        binding.imgright.setOnClickListener{
            val name = binding.edtcategory.text.toString()
            db.inseart(name)

            datalist = db.display()
        }
    }
}