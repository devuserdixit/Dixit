package com.example.retrofitapipractice

import com.google.gson.annotations.SerializedName

//data class ResponseModal(
//
//	@field:SerializedName("ResponseModal")
//	val responseModal: List<ResponseModalItem?>? = null
//)

data class ResponseModalItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
)
