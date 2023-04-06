package com.example.expensemanager_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransactionAdapter(var incomeExpenselist : ArrayList<IncomeExpenseModalClass>,var n :(IncomeExpenseModalClass) -> Unit,var delete : (Int) -> Unit): RecyclerView.Adapter<TransactionAdapter.myAdapter>() {
    class myAdapter(view : View) : RecyclerView.ViewHolder(view) {
        var txtIncomeExpense : TextView = view.findViewById(R.id.txtIncomeExpense)
        var txtDate : TextView = view.findViewById(R.id.txtDate)
        var txtAmount : TextView = view.findViewById(R.id.txtAmount)
        var txtNote : TextView = view.findViewById(R.id.txtNote)
        var txtCategoryType : TextView = view.findViewById(R.id.txtCategoryType)
        var txtMode : TextView = view.findViewById(R.id.txtMote)
        var imgedit : ImageView = view.findViewById(R.id.imgedit)
        var imgdelete : ImageView = view.findViewById(R.id.imgdelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myAdapter {
        var v=LayoutInflater.from(parent.context).inflate(R.layout.transaction_recycler_item,parent,false)
        var view = myAdapter(v)
        return view
    }

    override fun getItemCount(): Int {
        return incomeExpenselist.size
    }

    override fun onBindViewHolder(holder: myAdapter, position: Int) {
        holder.txtDate.setText(incomeExpenselist[position].date)
        holder.txtAmount.setText(incomeExpenselist[position].amount)
        holder.txtCategoryType.setText(incomeExpenselist[position].category)
        holder.txtMode.setText(incomeExpenselist[position].mode)
        holder.txtIncomeExpense.setText(incomeExpenselist[position].type.toString())
        holder.txtNote.setText(incomeExpenselist[position].note)

        holder.imgedit.setOnClickListener{
            n.invoke(incomeExpenselist[position])
        }
        holder.imgdelete.setOnClickListener{
            delete.invoke(incomeExpenselist[position].id)
        }

    }

    fun updateData(listTransaction : ArrayList<IncomeExpenseModalClass>) {
        this.incomeExpenselist= ArrayList()
        this.incomeExpenselist.addAll(listTransaction)
        notifyDataSetChanged()

    }
}