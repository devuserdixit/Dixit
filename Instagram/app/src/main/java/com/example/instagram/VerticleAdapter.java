package com.example.instagram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class VerticleAdapter extends RecyclerView.Adapter<VerticleAdapter.MyViewHolder> {

    ArrayList<VerticleModalClass> instaverticalList;

    public VerticleAdapter(ArrayList<VerticleModalClass> instaverticalList) {
        this.instaverticalList = instaverticalList;
    }

    @NonNull
    @Override
    public VerticleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.verticle_view,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VerticleAdapter.MyViewHolder holder, int position) {
        holder.txtname.setText(String.valueOf(instaverticalList.get(position).getName()));
        holder.imagelogo.setImageResource(instaverticalList.get(position).getImageLogo());
        holder.imagepost.setImageResource(instaverticalList.get(position).getImagePost());
    }

    @Override
    public int getItemCount() {
        return instaverticalList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imagelogo;
        TextView txtname;
        ImageView imagepost;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imagelogo=itemView.findViewById(R.id.imagelogo);
            txtname=itemView.findViewById(R.id.txtname);
            imagepost=itemView.findViewById(R.id.imagepost);
        }
    }
}
