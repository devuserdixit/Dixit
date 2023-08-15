package com.example.retrofitapipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapipractice.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var apiInterface: ApiInterface? = null
    lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        apiInterface = ApiClient.getClient().create(ApiInterface::class.java)

        apiInterface!!.getAllProduct().enqueue(object : Callback<List<ResponseModalItem>> {
            override fun onResponse(
                call: Call<List<ResponseModalItem>>,
                response: Response<List<ResponseModalItem>>
            ) {
                var list = response.body()
                var adapter = MyAdapter(list)
                var manager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                binding.rcvdisplay.layoutManager = manager
                binding.rcvdisplay.adapter = adapter
            }

            override fun onFailure(call: Call<List<ResponseModalItem>>, t: Throwable) {

            }

        })
    }
}

