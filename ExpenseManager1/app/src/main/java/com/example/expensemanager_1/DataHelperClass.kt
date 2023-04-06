package layout

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DataHelperClass(context: Context) : SQLiteOpenHelper(context,"Categorydb",null,1) {
    var dataList = ArrayList<CategoryModal>()
    override fun onCreate(db: SQLiteDatabase?) {
        var sql = "Create table Categorytb(name text)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    fun inseart(name: String)
    {
        val db = writableDatabase
        var d = ContentValues()
        d.put("name",name)
        db.insert("Categorytb",null,d)
    }

    fun display() : ArrayList<CategoryModal>{
        dataList.clear()

        val db = readableDatabase
        val sql = "select * from Categorytb"
        var cursor = db.rawQuery(sql,null)
        if (cursor.count > 0){
            cursor.moveToFirst()

            do {
                val name = cursor.getString(0)

                var studentList = CategoryModal(name)
                dataList.add(studentList)
            }while (cursor.moveToNext())

            Log.e("TAG", "display:size "+dataList.size)
        }else{
            Log.e("TAG", "display: "+"no data found" )
        }
        return dataList
    }
}