package com.example.expensemanager_1

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensemanager_1.databinding.ActivityIncomeBinding
import com.example.expensemanager_1.databinding.CategoryDialogBinding
import layout.CategoryAdapter
import layout.CategoryModal
import layout.DataHelperClass

class Income_Activity : AppCompatActivity() {
    lateinit var binding : ActivityIncomeBinding

    var categoryList = ArrayList<CategoryModal>()

    lateinit var db : DataHelperClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIncomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DataHelperClass(this)
        income()
    }

    private fun income() {
        binding.loutcatagory.setOnClickListener{
            val dialog = Dialog(this)
            val dialogBinding : CategoryDialogBinding = CategoryDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            dialogBinding.btnset.setOnClickListener{
                Toast.makeText(this, "Set", Toast.LENGTH_SHORT).show()
            }

            dialogBinding.btncancel.setOnClickListener{
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
            }

            categoryList = db.display()
            var categoryAdapter = CategoryAdapter(categoryList)
            dialogBinding.rcvcategory.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
            dialogBinding.rcvcategory.adapter = categoryAdapter
            dialog.show()
        }
    }
}