package com.example.shayariapplication

class CategoryModalClass(var id : Int , var categoryName : String)

data class DisplayCategoryModelClass(var Shayari_id : Int,var Shayari_item : String,var Category_Id : Int,var fav : Int)

class FavoriteModalClass(var Shayari_id : Int,var Shayari_item : String,var fav : Int)