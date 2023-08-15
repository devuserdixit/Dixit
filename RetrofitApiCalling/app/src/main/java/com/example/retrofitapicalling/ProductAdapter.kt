package com.example.retrofitapicalling

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(
    var context: Context,
    var list: ArrayList<ProductsItem>?,
    var OnClick: (ProductsItem) -> Unit
) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtid: TextView = view.findViewById(R.id.txtid)
        var txttitle: TextView = view.findViewById(R.id.txttitle)
        var txtdescription: TextView = view.findViewById(R.id.txtdescription)
        var txtprice: TextView = view.findViewById(R.id.txtprice)
        var txtrating: TextView = view.findViewById(R.id.txtrating)
        var txtstock: TextView = view.findViewById(R.id.txtstock)
        var txtbrand: TextView = view.findViewById(R.id.txtbrand)
        var imgproduct: ImageView = view.findViewById(R.id.imgproduct)
        var crdproduct: CardView = view.findViewById(R.id.crdproduct)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.display_record, parent, false)
        var view = MyViewHolder(v)
        return view
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtid.text = list!![position].id.toString()
        holder.txttitle.text = list!![position].title
        holder.txtdescription.text = list!![position].description
        holder.txtprice.text = list!![position].price.toString()
        holder.txtrating.text = list!![position].rating.toString()
        holder.txtstock.text = list!![position].stock.toString()
        holder.txtbrand.text = list!![position].brand

        holder.crdproduct.setOnClickListener {
            OnClick.invoke(list!![position])
        }

        Glide.with(context)
            .load("https://i.dummyjson.com/data/products/${list!![position].id}/thumbnail.jpg")
            .placeholder(R.drawable.place).into(holder.imgproduct)
    }
}