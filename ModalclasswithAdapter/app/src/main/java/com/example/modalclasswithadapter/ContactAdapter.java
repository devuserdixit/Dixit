package com.example.modalclasswithadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {

    ArrayList<ModalClassActivity> contact;
    Context context;

    ContactAdapter(ArrayList<ModalClassActivity> contact,Context context)
    {
       this.contact = contact;
       this.context=context;
    }

    @Override
    public int getCount() {
        return contact.size();
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

        View v = LayoutInflater.from(context).inflate(R.layout.itemdisplay,null);
        TextView txtcontact = v.findViewById(R.id.txtcontact);
        TextView txtid = v.findViewById(R.id.txtid);
        txtcontact.setText(contact.get(i).getContactname());
        txtid.setText(String.valueOf(contact.get(i).getid()));
        return v;
    }
}
