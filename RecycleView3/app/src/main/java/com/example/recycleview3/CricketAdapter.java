package com.example.recycleview3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CricketAdapter extends RecyclerView.Adapter<CricketAdapter.MyViewHolder> {

    ArrayList<ModalClass> list;

    public CricketAdapter(ArrayList<ModalClass> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public CricketAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detailsdisplay,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CricketAdapter.MyViewHolder holder, int position) {
        holder.txtname.setText(String.valueOf(list.get(position).getUsername()));
        holder.txtrun.setText(String.valueOf(list.get(position).getUserrun()));
        holder.txtwicket.setText(String.valueOf(list.get(position).getUserwicket()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtname,txtrun,txtwicket;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txtname);
            txtrun = itemView.findViewById(R.id.txtrun);
            txtwicket = itemView.findViewById(R.id.txtwicket);

        }
    }
}
