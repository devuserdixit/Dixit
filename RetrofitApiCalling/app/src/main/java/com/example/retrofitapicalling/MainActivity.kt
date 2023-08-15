package com.example.retrofitapicalling

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapicalling.databinding.ActivityMainBinding
import com.journaldev.retrofitintro.APIClient
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var ApiInterface: APIInterface
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        Search()
        logout()
    }

    private fun logout() {
        var sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        binding.btnlogout.setOnClickListener {

            val myEdit: SharedPreferences.Editor = sharedPreferences.edit()
            myEdit.remove("isLogin")
            myEdit.commit()

            var i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    private fun initView() {


        val ConnectionManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = ConnectionManager.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnected) {
            Toast.makeText(this@MainActivity, "Connection is available", Toast.LENGTH_SHORT).show()
            ApiInterface = APIClient.getClient().create(APIInterface::class.java)
            ApiInterface.getAllProduct()
                .enqueue(object : retrofit2.Callback<ProductModalClass<Any?>> {
                    override fun onResponse(
                        call: Call<ProductModalClass<Any?>>,
                        response: Response<ProductModalClass<Any?>>
                    ) {

                        var list = response.body()?.products

                        for (i in 0 until list?.size!!) {
                            Log.e("TAG", "onResponse: " + list[i]?.title)
                        }
                        var adapter = ProductAdapter(this@MainActivity, list) {
                            var i = Intent(this@MainActivity, ProductDisplayActivity::class.java)
                            i.putExtra("id", it.id)
                            Log.e("TAG", "onResponse: " + it.id)
                            startActivity(i)
                        }
                        var manager =
                            LinearLayoutManager(
                                this@MainActivity,
                                LinearLayoutManager.VERTICAL,
                                false
                            )
                        binding.rcvProduct.layoutManager = manager
                        binding.rcvProduct.adapter = adapter
                    }

                    override fun onFailure(call: Call<ProductModalClass<Any?>>?, t: Throwable) {
                    }
                })
        } else {
            Toast.makeText(
                this@MainActivity,
                "Please Check Internet Connection",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun Search() {
        binding.btnSearch.setOnClickListener {
            var SearchText = binding.edtSearchbar.text.toString()
            ApiInterface.getSearchItem(SearchText)
                .enqueue(object : retrofit2.Callback<ProductModalClass<ProductsItem>> {
                    override fun onResponse(
                        call: Call<ProductModalClass<ProductsItem>>,
                        response: Response<ProductModalClass<ProductsItem>>
                    ) {
                        var SearchList = response.body()?.products
                        var adapter = SearchAdapter(this@MainActivity, SearchList)
                        var manager = LinearLayoutManager(this@MainActivity)
                        binding.rcvSearch.layoutManager = manager
                        binding.rcvSearch.adapter = adapter
                    }

                    override fun onFailure(
                        call: Call<ProductModalClass<ProductsItem>>,
                        t: Throwable
                    ) {
                        TODO("Not yet implemented")
                    }

                })
        }
    }

}