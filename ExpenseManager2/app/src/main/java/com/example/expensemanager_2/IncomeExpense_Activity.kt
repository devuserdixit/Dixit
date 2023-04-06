package com.example.expensemanager_2

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensemanager_2.databinding.ActivityIncomeExpenseBinding
import com.example.expensemanager_2.databinding.CategoryDialogBinding
import com.example.expensemanager_2.databinding.ModeDialogBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class IncomeExpense_Activity : AppCompatActivity() {
    var id = 0
    lateinit var binding: ActivityIncomeExpenseBinding
    var mode = ArrayList<String>()
    var categorylist = ArrayList<CategoryModal>()
    var selectedcategory = ""
    lateinit var db: DataHelperClass
    var type = -1
    var dateValue = ""
    var selectmode = ""
    var flag=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIncomeExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

//
        db = DataHelperClass(this)
        if (intent != null && intent.hasExtra("update Record")) {
            flag=1
            val newamount: String? = intent.getStringExtra("amount")
            val newnote: String? = intent.getStringExtra("note")
            val newtitle: String? = intent.getStringExtra("title")
            val newdone: String? = intent.getStringExtra("icon")
            id = intent.getIntExtra("id", 0)


            binding.edtamount.setText(newamount)
            binding.edtnote.setText(newnote)
            binding.txtTitle.setText(newtitle)
            binding.imgright.setText(newdone)

        }
        edit()
        income()

    }


    private fun income() {
        binding.loutcatagory.setOnClickListener {
            val dialog = Dialog(this)
            val dialogBinding: CategoryDialogBinding = CategoryDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            dialogBinding.btnset.setOnClickListener {
                Toast.makeText(this, "Set", Toast.LENGTH_SHORT).show()
            }

            dialogBinding.btncancel.setOnClickListener {
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            categorylist = db.display()

            val categoryAdapter = CategoryAdapter(categorylist) { categoryname ->
                Log.e("TAG", "income: " + categoryname)
                selectedcategory = categoryname
            }
            dialogBinding.rcvcategory.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            dialogBinding.rcvcategory.adapter = categoryAdapter
            dialog.show()
            dialogBinding.btnset.setOnClickListener {
                dialog.dismiss()
            }
            dialogBinding.btncancel.setOnClickListener {
                dialog.dismiss()
            }
        }
        val page = intent.getStringExtra("page")
        var name: String? = intent.getStringExtra("title")

        when (page) {
            "income" ->
                binding.btnrbincome.isChecked = true
            "expense" ->
                binding.btnrbexpanse.isChecked = true
        }
        binding.txtTitle.text = name

        binding.imgback.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.loutmode.setOnClickListener {
            val dialog = Dialog(this)
            val dialogBinding: ModeDialogBinding = ModeDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT

            )
            dialogBinding.btnset.setOnClickListener {
                Toast.makeText(this, "Set", Toast.LENGTH_SHORT).show()
            }
            dialogBinding.btncancel.setOnClickListener {
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
            }
            val adapter = ModeAdapter(mode, { mode ->
                selectmode = mode
            })
            dialogBinding.rcvmode.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            dialogBinding.rcvmode.adapter = adapter
            dialog.show()
            dialogBinding.btnset.setOnClickListener {
                dialog.dismiss()
            }
            dialogBinding.btncancel.setOnClickListener {
                dialog.dismiss()
            }
        }
        mode.add("CASH")
        mode.add("CREDIT CARD")
        mode.add("DEBIT CARD")
        mode.add("UPI")
        mode.add("NET BANKING")
        mode.add("CHEQUE")

        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy")
        val date: String = simpleDateFormat.format(Date())
        binding.date.text = date
        dateValue = date

        val simpleDateformat = SimpleDateFormat("HH:mm")
        val time: String = simpleDateformat.format(Date())
        binding.time.text = time

        binding.imgright.setOnClickListener {
            var amount = binding.edtamount.text.toString()
            var note = binding.edtnote.text.toString()
            if (amount.isEmpty()) {
                Toast.makeText(this, "please enter amount", Toast.LENGTH_SHORT).show()
            } else if (amount.length <= 1 || amount.length >= 10) {
                Toast.makeText(this, "please enter amount first", Toast.LENGTH_SHORT).show()
            } else if (note.isEmpty()) {
                Toast.makeText(this, "please enter a note", Toast.LENGTH_SHORT).show()
            } else {
                if (binding.rgincomeExpense.checkedRadioButtonId == -1) {

                } else {
                    val selectedId: Int = binding.rgincomeExpense.checkedRadioButtonId
                    var selectedRadioButton: RadioButton = findViewById(selectedId)
                    var text = selectedRadioButton.text.toString()

                    if (text.equals("Income")) {
                        type = 1
                    } else {
                        type = 2
                    }
                }
                if (flag==1) {
                    db.updateRecord(amount, note, id)
                } else {
                    db.insertExpenseIncomeRecord(
                        dateValue,
                        amount,
                        selectedcategory,
                        selectmode,
                        type,
                        note
                    )
                }
            }
            val trans = Intent(this, TransactionActivity::class.java)
            startActivity(trans)

        }

    }

    private fun edit() {

    }
}