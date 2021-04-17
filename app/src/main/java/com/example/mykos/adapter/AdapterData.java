package com.example.mykos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykos.R;
import com.example.mykos.model.Kos;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    List<Kos> kos;
    LayoutInflater layoutInflater;
    private Context context;

    public AdapterData(Context context, List<Kos> kos) {
        this.kos = kos;
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
        holder.rating.setText(kos.get(position).getRating());
        holder.nama.setText(kos.get(position).getName());
        holder.harga.setText(kos.get(position).getPrice());
        holder.tempat.setText(kos.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return kos.size();
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
