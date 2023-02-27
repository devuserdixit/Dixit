package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter
{
    ArrayList<String> food;
    ArrayList<Integer> img;
    Context context;

    FoodAdapter(ArrayList<String> food,ArrayList<Integer> img,Context context)
    {
        this.food=food;
        this.img=img;
        this.context=context;
    }
    @Override
    public int getCount() {
        return food.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v= LayoutInflater.from(context).inflate(R.layout.fooddisplay,null);
        TextView txtFoodname=v.findViewById(R.id.txtFoodname);
        ImageView imgFood=v.findViewById(R.id.imgFood);
        imgFood.setImageResource(img.get(i));
        txtFoodname.setText(food.get(i));

        return v;
    }
}

