package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactAdapter extends BaseAdapter
{
    String contactar[];
    Context context;

    ContactAdapter(String contactar[],Context context)
    {
        this.contactar=contactar;
        this.context=context;
    }
    @Override
    public int getCount() {
        return contactar.length;
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
        View v= LayoutInflater.from(context).inflate(R.layout.contactdisplay,null);
        TextView txtcontactname=v.findViewById(R.id.txtcontactname);
        txtcontactname.setText(contactar[i]);
        return v;
    }
}
