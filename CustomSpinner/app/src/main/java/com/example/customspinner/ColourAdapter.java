package com.example.customspinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColourAdapter extends BaseAdapter
{
    String colourar[];
    Context context;

    ColourAdapter(String[] colourar,Context context)
    {
        this.colourar=colourar;
        this.context=context;
    }

    @Override
    public int getCount() {
        return colourar.length;
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
        View v= LayoutInflater.from(context).inflate(R.layout.weekspinner,null);
        TextView txtweekname = v.findViewById(R.id.txtweekname);
        txtweekname.setText(colourar[i]);
        return v;
    }
}
