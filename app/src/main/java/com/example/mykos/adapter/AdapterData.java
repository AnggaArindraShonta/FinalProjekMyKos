package com.example.mykos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykos.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    List<String> listData;
    LayoutInflater layoutInflater;

    public AdapterData(Context context, List<String> listData) {
        this.listData = listData;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_recomended, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.rating.setText(listData.get(position));
        holder.nama.setText(listData.get(position));
        holder.harga.setText(listData.get(position));
        holder.tempat.setText(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView rating, nama, harga, tempat;
        public HolderData(@NonNull View itemView) {
            super(itemView);

            rating = itemView.findViewById(R.id.rating);
            nama = itemView.findViewById(R.id.txtnama);
            harga = itemView.findViewById(R.id.txtharga);
            tempat = itemView.findViewById(R.id.txttempat);
        }
    }
}
