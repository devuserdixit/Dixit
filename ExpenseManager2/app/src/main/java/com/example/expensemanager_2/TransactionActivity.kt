package com.example.expensemanager_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensemanager_2.databinding.ActivityTransactionBinding

class TransactionActivity : AppCompatActivity() {

    lateinit var db: DataHelperClass
    lateinit var adapter: TransactionAdapter
    lateinit var binding: ActivityTransactionBinding
    var incomeExpenselist = ArrayList<IncomeExpenseModalClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DataHelperClass(this)
        initview()
    }

    private fun initview() {
        incomeExpenselist = db.displayIncomeExpenseRecord()
        var title = "Update Details"
        var iconname = "Update"
        db.displayIncomeExpenseRecord()
        adapter = TransactionAdapter(incomeExpenselist, {
            val i = Intent(this@TransactionActivity, IncomeExpense_Activity::class.java)
            i.putExtra("id", it.id)
            i.putExtra("type", it.type)
            i.putExtra("date", it.date)
            i.putExtra("amount", it.amount)
            i.putExtra("note", it.note)
            i.putExtra("category", it.category)
            i.putExtra("mode", it.mode)
            i.putExtra("title", title)
            i.putExtra("icon", iconname)
            i.putExtra("update Record", true)
            startActivity(i)

        }, { id ->
            db.deleteData(id)
            Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show()
            incomeExpenselist = db.displayIncomeExpenseRecord()
            adapter.updateData(incomeExpenselist)
            Log.e("TAG", "record delete: " + id)
        })

//        var adapter = TransactionAdapter(incomeExpenselist)
        var transManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcvTransaction.layoutManager = transManager
        binding.rcvTransaction.adapter = adapter

        incomeExpenselist = db.displayIncomeExpenseRecord()
        adapter.updateData(incomeExpenselist)


        binding.imgBackTransaction.setOnClickListener {
            val transaction = Intent(this@TransactionActivity, MainActivity::class.java)
            startActivity(transaction)
        }


    }
}