package com.example.recycleview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    ArrayList<ModalClass> list;
    Context context;
    ClickListner listner;

    public UserAdapter(ArrayList<ModalClass> list,ClickListner listner)
    {
        this.list=list;
        this.listner=listner;
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {
        holder.txtId.setText(String.valueOf(list.get(position).getId()));
        holder.txtName.setText(String.valueOf(list.get(position).getUsername()));

        holder.loutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.onclick(list.get(position).getId(),list.get(position).getUsername());
               // Log.e("TAG", "onClick: "+position );
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtId,txtName;
        LinearLayout loutMain;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtId=itemView.findViewById(R.id.txtId);
            txtName=itemView.findViewById(R.id.txtName);
            loutMain = itemView.findViewById(R.id.loutMain);
        }
    }
}
