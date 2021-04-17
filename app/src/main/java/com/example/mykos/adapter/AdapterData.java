package com.example.mykos.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mykos.R;
import com.example.mykos.model.Kos;

import java.util.ArrayList;
import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private List<Kos> kos = new ArrayList<>();

    public void updateList(List<Kos> list){
        kos = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recomended, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.bindItem(kos.get(position));
    }

    @Override
    public int getItemCount() {
        return kos.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView rating, nama, harga, tempat;
        private ImageView image;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            rating = itemView.findViewById(R.id.rating);
            nama = itemView.findViewById(R.id.txtnama);
            harga = itemView.findViewById(R.id.txtharga);
            tempat = itemView.findViewById(R.id.txttempat);
            image = itemView.findViewById(R.id.image);
        }

        public void bindItem(Kos kos) {
            rating.setText(kos.getRating());
            nama.setText(kos.getName());
            harga.setText(kos.getPrice());
            tempat.setText(kos.getCity());
            Glide.with(itemView)
                    .load(kos.getImage_url())
                    .into(image);
        }
    }
}
