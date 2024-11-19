package com.example.chapter8_java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final ArrayList<Contact> data;

    public MyAdapter(ArrayList<Contact> data) {
        this.data = data;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName;
        private final TextView tvPhone;
        private final ImageView imgDelete;

        public ViewHolder(@NonNull View v) {
            super(v);
            tvName = v.findViewById(R.id.tvName);
            tvPhone = v.findViewById(R.id.tvPhone);
            imgDelete = v.findViewById(R.id.imgDelete);
        }

        public void bind(Contact item, OnItemClickListener clickListener) {
            tvName.setText(item.getName());
            tvPhone.setText(item.getPhone());
            imgDelete.setOnClickListener(v -> clickListener.onItemClick(item));
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_row, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(data.get(position), item -> {
            data.remove(item);
            notifyDataSetChanged();
        });
    }

    public interface OnItemClickListener {
        void onItemClick(Contact item);
    }
}