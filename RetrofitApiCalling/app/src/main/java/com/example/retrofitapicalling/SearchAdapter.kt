package com.example.retrofitapicalling

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter(var context: Context, var SearchList: ArrayList<ProductsItem>?) :
    RecyclerView.Adapter<SearchAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtid: TextView = view.findViewById(R.id.txtid)
        var txttitle: TextView = view.findViewById(R.id.txttitle)
        var txtdescription: TextView = view.findViewById(R.id.txtdescription)
        var txtprice: TextView = view.findViewById(R.id.txtprice)
        var txtrating: TextView = view.findViewById(R.id.txtrating)
        var txtstock: TextView = view.findViewById(R.id.txtstock)
        var txtbrand: TextView = view.findViewById(R.id.txtbrand)
//        var imgproduct: ImageView = view.findViewById(R.id.imgproduct)
//        var crdproduct: CardView = view.findViewById(R.id.crdproduct)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_display_item_file, parent, false)
        var view = MyViewHolder(v)
        return view
    }

    override fun getItemCount(): Int {
        return SearchList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtid.text = SearchList!![position].id.toString()
        holder.txttitle.text = SearchList!![position].title
        holder.txtdescription.text = SearchList!![position].description
        holder.txtprice.text = SearchList!![position].price.toString()
        holder.txtrating.text = SearchList!![position].rating.toString()
        holder.txtstock.text = SearchList!![position].stock.toString()
        holder.txtbrand.text = SearchList!![position].brand
    }
}