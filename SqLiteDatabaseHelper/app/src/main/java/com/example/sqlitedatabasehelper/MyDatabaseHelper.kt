package com.example.sqlitedatabasehelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

var StudentList = ArrayList<StudentModalClass>()

class MyDatabaseHelper(context: Context) : SQLiteOpenHelper(context, "StudentDb", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        var sql =
            "create table studentTb (student_id integer primary key Autoincrement,name text,Mobile text,gender text,fees integer)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun insertRecord(name: String, mobile: String, gender: String, fees: String) {
        val db = writableDatabase
        var s = ContentValues()
        s.put("name", name)
        s.put("mobile", mobile)
        s.put("gender", gender)
        s.put("fees", fees)
        db.insert("StudentTb", null, s)
    }

    fun displayRecords(): ArrayList<StudentModalClass> {
        StudentList.clear()

        val db = readableDatabase
        val sql = "select * from studentTb"
        var cursor = db.rawQuery(sql, null)
        if (cursor.count > 0) {
            cursor.moveToFirst()
            do {
                val name = cursor.getString(1)
                val mobile = cursor.getString(2)
                val gender = cursor.getString(3)
                val fees = cursor.getString(4)

                Log.e("TAG", "displayRecords: " + name + " " + mobile + " " + gender + " " + fees)

                var model = StudentModalClass(name, mobile, gender, fees)
                StudentList.add(model)

            } while (cursor.moveToNext())
        } else {
            Log.e("TAG", "displayRecords: " + "No data found")
        }
        return StudentList
    }
}