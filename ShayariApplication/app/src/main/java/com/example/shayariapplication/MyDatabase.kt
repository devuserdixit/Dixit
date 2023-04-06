package com.example.shayariapplication

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class MyDatabase(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    private val mDataBase: SQLiteDatabase? = null
    private var mNeedUpdate = false
    private val mContext: Context

    init {
        if (Build.VERSION.SDK_INT >= 17) DB_PATH =
            context.applicationInfo.dataDir + "/databases/" else DB_PATH =
            "/data/data/" + context.packageName + "/databases/"
        mContext = context
        copyDataBase()
        this.readableDatabase
    }

    private fun copyDataBase() {
        if (!checkDataBase()) {
            this.readableDatabase
            close()
            try {
                copyDBFile()
            } catch (mIOException: IOException) {
                throw Error("ErrorCopyingDataBase")
            }
        }
    }

    private fun checkDataBase(): Boolean {
        val dbFile = File(DB_PATH + DB_NAME)
        return dbFile.exists()
    }

    //    TODO copy file
    @Throws(IOException::class)
    private fun copyDBFile() {
        val mInput = mContext.assets.open(DB_NAME)
        val mOutput: OutputStream = FileOutputStream(DB_PATH + DB_NAME)
        val mBuffer = ByteArray(1024)
        var mLength: Int
        while (mInput.read(mBuffer).also { mLength = it } > 0) mOutput.write(mBuffer, 0, mLength)
        mOutput.flush()
        mOutput.close()
        mInput.close()
    }

    override fun onCreate(db: SQLiteDatabase) {}
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (newVersion > oldVersion) mNeedUpdate = true
    }

    //    TODO update database
    @Throws(IOException::class)
    fun updateDataBase() {
        if (mNeedUpdate) {
            val dbFile = File(DB_PATH + DB_NAME)
            if (dbFile.exists()) dbFile.delete()
            copyDataBase()
            mNeedUpdate = false
        }
    }

    @Synchronized
    override fun close() {
        mDataBase?.close()
        super.close()
    }

    fun readData(): ArrayList<CategoryModalClass> {
        var list = ArrayList<CategoryModalClass>()
        val db = readableDatabase
        val sql = "select * from CategoryTb"
        val c = db.rawQuery(sql, null)
        if (c.count > 0) {
            c.moveToFirst()
            do {
                val id = c.getInt(0)
                val categoryName = c.getString(1)

                Log.e(TAG, "readData:==> $id   $categoryName")
                var modal = CategoryModalClass(id, categoryName)

                list.add(modal)
            } while (c.moveToNext())
        }
        return list
    }

    fun ShatariData(c_ID:Int): ArrayList<DisplayCategoryModelClass> {
        var shayariList = ArrayList<DisplayCategoryModelClass>()
        val db1 = readableDatabase
        val sql1 = "select * from Shayari_Tb where Category Id = $c_ID"
        val c = db1.rawQuery(sql1, null)
        if (c.count > 0) {
            c.moveToFirst()
            do {
                var id = c.getInt(0)
                var shayari = c.getString(1)
                var category_Id = c.getInt(2)

                Log.e(TAG, "readData:==> $id   $shayari")
                var shayarimodal = DisplayCategoryModelClass(id, shayari,category_Id)

                shayariList.add(shayarimodal)
            } while (c.moveToNext())
        }
        return shayariList
    }


    companion object {
        private const val TAG = "MyDatabase"
        private const val DB_NAME = "Shayari Database.db"
        private var DB_PATH = ""
        private const val DB_VERSION = 1
    }
}