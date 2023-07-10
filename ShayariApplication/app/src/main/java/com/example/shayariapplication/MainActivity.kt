package com.example.shayariapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shayariapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var db : MyDatabase

    lateinit var adapter : CategoryAdapter

    var categoryList = ArrayList<CategoryModalClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = MyDatabase(this)
        initview()
        drawer();
    }

    private fun drawer() {
        binding.imgmenu.setOnClickListener{
            binding.layoutDrawer.openDrawer(GravityCompat.START)
        }
        binding.loutFavorite.setOnClickListener{
            binding.layoutDrawer.closeDrawer(GravityCompat.START)
            var i = Intent(this,FavoriteActivity::class.java)
            startActivity(i)
        }
        binding.loutHome.setOnClickListener{
            Toast.makeText(this, "You are in home now", Toast.LENGTH_SHORT).show()
            binding.layoutDrawer.closeDrawer(GravityCompat.START)
        }
        binding.loutShare.setOnClickListener{
            binding.layoutDrawer.closeDrawer(GravityCompat.START)
            val Share = Intent(Intent.ACTION_SEND)
            Share.type = "text/plain"
            Share.putExtra(
                Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=com.varnisoftech.loveshayari"

            )
            startActivity(Share)
        }
        binding.loutExit.setOnClickListener{
            onBackPressed()
        }
        binding.loutPrivacy.setOnClickListener{
          val Url = "https://dikshitakabari.blogspot.com/2023/04/privacy-policy.html"
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse(Url))
            startActivity(intent)
        }
    }

    fun initview() {

        categoryList = db.readData()
        adapter = CategoryAdapter(categoryList){
            var i = Intent(this,DisplayCategoryActivity::class.java)
            i.putExtra("Title",it.categoryName)
            i.putExtra("Id",it.id)

            startActivity(i)


            Log.e("TAG", "initview: "+it.id)
        }
        var manager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rcvCategory.layoutManager = manager
        binding.rcvCategory.adapter = adapter

    }

}