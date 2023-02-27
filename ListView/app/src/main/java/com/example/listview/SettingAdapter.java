package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingAdapter extends BaseAdapter {
    String settingar[];
    int imgar[];
    Context context;

    SettingAdapter(String[] settingar,int imgar[],Context context)
    {
        this.settingar=settingar;
        this.imgar=imgar;
        this.context=context;
    }

    @Override
    public int getCount() {
        return settingar.length;
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
        View v= LayoutInflater.from(context).inflate(R.layout.settingdisplay,null);
        TextView txtname = v.findViewById(R.id.txtname);
        ImageView imgicon = v.findViewById(R.id.imgicon);
        txtname.setText(settingar[i]);

        imgicon.setImageResource(imgar[i]);
        return v;
    }
}
