package com.example.jsonapicallingvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.jsonapicallingvolley.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mRequestQueue: RequestQueue
    lateinit var adapter: ApiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        mRequestQueue = Volley.newRequestQueue(this)

        var reg = JsonArrayRequest(Request.Method.GET,
            "https://jsonplaceholder.typicode.com/posts",
            null,
            { response ->
                val datalist: ArrayList<ResponseItem>
                val listType: Type? = object : TypeToken<List<ResponseItem?>?>() {}.type
                datalist = Gson().fromJson(response.toString(), listType)
                for (i in 0 until datalist.size) {
                    Log.e("TAG", "initView: " + datalist.get(i).id)
                    Log.e("TAG", "initView: " + datalist.get(i).title)
                    Log.e("TAG", "initView: " + datalist.get(i).body)
                    Log.e("TAG", "initView: " + datalist.get(i).userId)

                }
                adapter = ApiAdapter(datalist)
                var manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
                binding.rcvJsonVolleyApi.layoutManager = manager
                binding.rcvJsonVolleyApi.adapter = adapter
            },
            { error ->
                Log.e("TAG", "initView: " + error.message)

            })
        mRequestQueue.add(reg)
    }
}