package layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expensemanager_1.R

class CategoryAdapter(var categorylist : ArrayList<CategoryModal>) :
    RecyclerView.Adapter<CategoryAdapter.myview>() {

    class myview(v : View) : RecyclerView.ViewHolder(v){
        var txtcategory : TextView = v.findViewById(R.id.txtcategory)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.myview {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.category_item,null,false)
        val adapter = myview(v)
        return adapter
    }

    override fun onBindViewHolder(holder: CategoryAdapter.myview, position: Int) {
        holder.txtcategory.setText(categorylist[position].d)
    }

    override fun getItemCount(): Int {
        return categorylist.size
    }

}