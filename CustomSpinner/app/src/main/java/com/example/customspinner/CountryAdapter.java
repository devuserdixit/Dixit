package com.example.customspinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryAdapter extends BaseAdapter
{
    String countryar[];
    int imgar[];
    Context context;

    CountryAdapter(String[] countryar,int imgar[],Context context)
    {
        this.countryar=countryar;
        this.imgar=imgar;
        this.context=context;
    }

    @Override
    public int getCount() {
        return countryar.length;
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
        View v= LayoutInflater.from(context).inflate(R.layout.imagespinner,null);
        TextView txtcountryname = v.findViewById(R.id.txtcountryname);
        ImageView imgCountryflag = v.findViewById(R.id.imgCountryflag);
        txtcountryname.setText(countryar[i]);

        imgCountryflag.setImageResource(imgar[i]);
        return v;
    }
}
