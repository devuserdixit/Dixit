package com.example.shayariapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shayariapplication.databinding.ActivityFavoriteBinding
import com.example.shayariapplication.databinding.ActivityMainBinding

class FavoriteActivity : AppCompatActivity() {

    lateinit var db : MyDatabase
    var list = ArrayList<FavoriteModalClass>()
    lateinit var adapter : FavoriteAdapter

    lateinit var binding: ActivityFavoriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
         db = MyDatabase(this)
        initview()
    }

    private fun initview() {

        list = db.FavoriteDisplayRecord()

         adapter =
            FavoriteAdapter { Shayari_id,fav ->
            db.updateRecord(Shayari_id, fav)
        }

        var manager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rcvfavorite.layoutManager = manager
        binding.rcvfavorite.adapter = adapter
        binding.imgBack.setOnClickListener{
            onBackPressed()
        }

//        list = db.updateRecord()
//        adapter.updateList(list)
        adapter.updateList(list)
    }
}