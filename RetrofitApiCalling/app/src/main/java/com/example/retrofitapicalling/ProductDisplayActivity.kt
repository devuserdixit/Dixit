package com.example.retrofitapicalling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitapicalling.databinding.ActivityMainBinding
import com.example.retrofitapicalling.databinding.ActivityProductDisplayBinding
import com.journaldev.retrofitintro.APIClient
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ProductDisplayActivity : AppCompatActivity() {

    lateinit var binding : ActivityProductDisplayBinding
     var apiInterface : APIInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {
        var id = intent.getIntExtra("id",0)

        apiInterface = APIClient.getClient().create(APIInterface::class.java)

        apiInterface?.getAllContent(id)?.enqueue(object :retrofit2.Callback<ProductsItem>{
            override fun onResponse(call: Call<ProductsItem>, response: Response<ProductsItem>) {
                var images = response.body()?.images
                var Id = response.body()?.id
                var Title = response.body()?.title
                var Description = response.body()?.description
                var Price = response.body()?.price
                var Rating = response.body()?.rating
                var Stock = response.body()?.stock
                var Brand = response.body()?.brand

                var adapter = ProductDisplayAdapter(this@ProductDisplayActivity,images)
                binding.viewpager.adapter = adapter

                binding.txttitle.text = Title
                binding.txtid.text = id.toString()
                binding.txtstock.text = Stock.toString()
                binding.txtdescription.text = Description
                binding.txtprice.text = Price.toString()
                binding.txtrating.text = Rating.toString()
                binding.txtbrand.text = Brand

            }

            override fun onFailure(call: Call<ProductsItem>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


    }
}