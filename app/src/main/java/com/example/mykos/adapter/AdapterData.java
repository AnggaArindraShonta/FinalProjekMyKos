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
    private Callback.ItemClick itemClick;

    public void updateList(List<Kos> list) {
        kos.clear();
        kos.addAll(list);
//        kos = list;
        notifyDataSetChanged();
    }

    public void setOnItemCLickListener(Callback.ItemClick callback) {
        itemClick = callback;
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

        if (itemClick != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                private String t;

                @Override
                public void onClick(View v) {
                    itemClick.onItemClick(v, kos.get(position), position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return kos.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView rating, nama, harga, tempat, negara;
        private ImageView image;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            rating = itemView.findViewById(R.id.rating);
            nama = itemView.findViewById(R.id.txtnama);
            harga = itemView.findViewById(R.id.txtharga);
            tempat = itemView.findViewById(R.id.txttempat);
            negara = itemView.findViewById(R.id.txtnegara);
            image = itemView.findViewById(R.id.image);
        }

        public void bindItem(Kos kos) {
            rating.setText(kos.getRating());
            nama.setText(kos.getName());
            harga.setText(kos.getPrice());
            tempat.setText(kos.getCity());
            negara.setText(kos.getCountry());
            Glide.with(itemView)
                    .load(kos.getImage_url())
                    .into(image);
        }
    }

    interface Callback {
        interface ItemClick {
            void onItemClick(View view, Kos kos, int position);
        }
    }
}
