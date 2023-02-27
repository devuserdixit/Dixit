package com.example.instagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class InstaAdapter extends RecyclerView.Adapter<InstaAdapter.MyViewHolder> {

    ArrayList<ModalClass> instagramList;
    Context context;
    OnClicklListener listener;

    public InstaAdapter(ArrayList<ModalClass> instagramList,OnClicklListener listener) {
        this.instagramList = instagramList;
        this.listener= listener;
    }

    @NonNull
    @Override
    public InstaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_view,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InstaAdapter.MyViewHolder holder, int position)
    {
        holder.txtname.setText(String.valueOf(instagramList.get(position).getName()));
        holder.imgstatus.setImageResource(instagramList.get(position).getImage());

        holder.loutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onclick(instagramList.get(position).getName(),instagramList.get(position).getImage());
            }
        });
    }

    @Override
    public int getItemCount() {
        return instagramList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgstatus;
        TextView txtname;
        LinearLayout loutMain;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgstatus=itemView.findViewById(R.id.imgstatus);
            txtname=itemView.findViewById(R.id.txtname);
            loutMain=itemView.findViewById(R.id.loutMain);
        }
    }
}
