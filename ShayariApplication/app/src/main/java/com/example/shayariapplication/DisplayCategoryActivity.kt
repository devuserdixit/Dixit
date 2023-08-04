package com.example.shayariapplication

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shayariapplication.databinding.ActivityDisplayCategoryBinding

class DisplayCategoryActivity : AppCompatActivity() {

    lateinit var binding: ActivityDisplayCategoryBinding
    lateinit var dbD: MyDatabase

    var shayariList = ArrayList<DisplayCategoryModelClass>()
    var cate_id : Int = 0

    lateinit var adapter: DisplayCategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbD = MyDatabase(this)

        initview()
    }

    private fun initview() {
        binding.imglike.setOnClickListener{
            var favorite = Intent(this,FavoriteActivity::class.java)
            startActivity(favorite)
        }
        binding.imgback.setOnClickListener{
            onBackPressed()
        }

//        binding.imgCopy.setOnClickListener {
//            val clipboard: ClipboardManager =
//                getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
//            val clip = ClipData.newPlainText("label", ShayariName)
//            clipboard.setPrimaryClip(clip)
//            Toast.makeText(this, "Copy Successfully", Toast.LENGTH_SHORT).show()
//        }

        var categoryName: String? = intent.getStringExtra("Title")
        binding.txtDisplayTitle.text = categoryName

        cate_id = intent.getIntExtra("Id", 0)

        adapter = DisplayCategoryAdapter(
             shayariList,
            {
                var i = Intent(this, ShayariDisplayActivity::class.java)
                i.putExtra("ShayariItem", it.Shayari_item)
                startActivity(i)
                finish()
            },
            { Shayari_id, fav ->
                dbD.updateRecord(Shayari_id, fav)
            })

        var manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcvCategoryData.layoutManager = manager
        binding.rcvCategoryData.adapter = adapter

    }

    override fun onResume() {
        super.onResume()
        shayariList = dbD.ShayariData(cate_id)
        adapter.updatelist(shayariList)
        Log.e("TAG", "onResume: "+cate_id)
    }
}