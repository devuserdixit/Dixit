package com.example.productapicalling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.productapicalling.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mRequestQueue: RequestQueue
    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        mRequestQueue = Volley.newRequestQueue(this)

        var reg = JsonObjectRequest(
            Request.Method.GET,
            "https://dummyjson.com/products",
            null,
            { response ->
                var productList = Gson().fromJson(response.toString(), ProductResponse::class.java)
                for (i in 0 until productList.products.size) {
                    Log.e("TAG", "initView: "+productList.products.get(i).id)
                    Log.e("TAG", "initView: "+productList.products.get(i).title)
                    Log.e("TAG", "initView: "+productList.products.get(i).description)
                    Log.e("TAG", "initView: "+productList.products.get(i).price)
                    Log.e("TAG", "initView: "+productList.products.get(i).rating)
                    Log.e("TAG", "initView: "+productList.products.get(i).stock)
                    Log.e("TAG", "initView: "+productList.products.get(i).brand)
                }
                adapter = ProductAdapter(this,productList.products)
                var manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
                binding.rcvProduct.layoutManager = manager
                binding.rcvProduct.adapter = adapter
            }, {
                error ->
                Log.e("TAG", "initView: "+error.message)
            })
        mRequestQueue.add(reg)
    }
}