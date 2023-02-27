package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.MyViewHolder>{

    ArrayList<ModalClass> list;
    Context context;
    OnClickListener listener;

    public AnimalsAdapter(ArrayList<ModalClass> list,OnClickListener listener) {
       this.list=list;
       this.listener=listener;
    }

    @NonNull
    @Override
    public AnimalsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      context=parent.getContext();
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_display,parent,false);
      MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalsAdapter.MyViewHolder holder, int position) {
        holder.txtname.setText(list.get(position).getAnimalname());
        holder.txtrun.setText(String.valueOf(list.get(position).getAnimalspeed()));

        holder.loutmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onclick(list.get(position).getAnimalname(),list.get(position).getAnimalspeed(),list.get(position).getAnimalimage());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtname,txtrun;
        ImageView imganimal;
        LinearLayout loutmain;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtname = itemView.findViewById(R.id.txtname);
            txtrun = itemView.findViewById(R.id.txtrun);
            imganimal = itemView.findViewById(R.id.imganimal);
            loutmain = itemView.findViewById(R.id.loutmain);
        }
    }
}
