package com.example.recycleview2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyviewHolder> {

    ArrayList<ModalClass> list;
    public UserAdapter(ArrayList<ModalClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public UserAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detailsdisplay,parent,false);
        MyviewHolder viewHolder = new MyviewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyviewHolder holder, int position)
    {
       holder.txtname.setText(String.valueOf(list.get(position).getUsername()));
       holder.txtnumber.setText(String.valueOf(list.get(position).getNumber()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        TextView txtname,txtnumber;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txtname);
            txtnumber = itemView.findViewById(R.id.txtnumber);

        }
    }
}
