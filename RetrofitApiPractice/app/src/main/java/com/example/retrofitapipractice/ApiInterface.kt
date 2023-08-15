package com.example.retrofitapipractice

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    fun getAllProduct(): Call<List<ResponseModalItem>>
}

