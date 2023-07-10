package com.example.retrofitapicalling

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface APIInterface {
    @GET("/products")
    fun getAllProduct(): Call<ProductModalClass<Any?>>


    @GET("/products/{id}")
    fun getAllContent(@Path("id")getId : Int): Call<ProductsItem>

    @GET("/products/search")
    fun getSearchItem(@Query("q")SearchText : String) : Call<ProductModalClass<ProductsItem>>

    @FormUrlEncoded
    @POST("/auth/login")
    fun getLogin(@Field("username")username : String,@Field("password")password : String) : Call<LoginModalClass>

}