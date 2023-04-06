package com.example.expensemanager_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.expensemanager_2.databinding.ActivityAddCategoryBinding

class AddCategory_Activity : AppCompatActivity() {

    lateinit var binding : ActivityAddCategoryBinding
    lateinit var db : DataHelperClass
    var datalist = ArrayList<CategoryModal>()
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

            if (name.isEmpty())
            {
                Toast.makeText(this, "Please enter a field", Toast.LENGTH_SHORT).show()
            }
            else if (name.length <=3 || name.length>=15)
            {
                Toast.makeText(this, "Please enter a valid field", Toast.LENGTH_SHORT).show()
            }
            db.insert(name)
        }
        binding.imgright.setOnClickListener{
            val a = Intent(this,MainActivity::class.java)
            startActivity(a)

        }
        binding.imgback.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}