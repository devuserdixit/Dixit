package com.example.expensemanager_2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DataHelperClass(context: Context) : SQLiteOpenHelper(context,"Categorydb",null,1) {
    var list = ArrayList<CategoryModal>()
    var incomeExpenselist = ArrayList<IncomeExpenseModalClass>()
    override fun onCreate(db: SQLiteDatabase?) {
        var sql = "Create table Categorytb(category_no integer primary key Autoincrement,name text)"
        var sql2 = "Create table incomeExpenseTb(id_no integer primary key Autoincrement,date text,amount integer,category_name text,modeType text,type integer,note text )"
        db?.execSQL(sql2)
        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    fun insert(name: String)
    {
        val db = writableDatabase
        var d = ContentValues()
        d.put("name",name)
        db.insert("Categorytb",null,d)
    }

    fun display():ArrayList<CategoryModal>{
        list.clear()

        val db = readableDatabase
        val sql = "select * from Categorytb"
        var cursor = db.rawQuery(sql,null)
        if (cursor.count > 0){
            cursor.moveToFirst()

            do {
                val name = cursor.getString(1)

                var studentList = CategoryModal(name)
                list.add(studentList)
            }while (cursor.moveToNext())

//            Log.e("TAG", "display:size "+list.size)
        }else{
            Log.e("TAG", "display: "+"no data found" )
        }
        return list
    }

    fun insertExpenseIncomeRecord(dateValue : String,amount : String,selectedcategory : String,selectedMode : String,type : Int,notes : String)
    {

        var inExp = writableDatabase
        var adding = ContentValues()
        adding.put("date",dateValue)
        adding.put("amount",amount)
        adding.put("category_name",selectedcategory)
        adding.put("modeType",selectedMode)
        adding.put("type",type)
        adding.put("note",notes)
        inExp.insert("incomeExpenseTb",null,adding)
    }
    fun displayIncomeExpenseRecord():ArrayList<IncomeExpenseModalClass>{
        incomeExpenselist.clear()
        var inExp = readableDatabase
        val sql2 = "select * from incomeExpenseTb"
        var cursor = inExp.rawQuery(sql2,null)
        if (cursor.count>0){
            cursor.moveToFirst()
            do {
                var id = cursor.getInt(0)
                var date = cursor.getString(1)
                var amount = cursor.getString(2)
                var category = cursor.getString(3)
                var mode = cursor.getString(4)
                var type = cursor.getString(5)
                var note = cursor.getString(6)

                val modelTwo = IncomeExpenseModalClass(id,date,amount,category,mode,type,note)
                incomeExpenselist.add(modelTwo)
            }while (cursor.moveToNext())
        }
        return incomeExpenselist
    }

    fun updateRecord(newamount : String?,newnote : String?,id : Int) {
        val update = writableDatabase
        val updateSql = "update incomeExpenseTb set amount='$newamount',note='$newnote' where id_no='$id'"
        update.execSQL(updateSql)
    }
    fun deleteData(id: Int){
        var db = writableDatabase
        var delete = "delete from incomeExpenseTb where id_no = '$id'"
        db.execSQL(delete)
    }
}