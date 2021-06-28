package com.example.mykos.ui.photos;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mykos.databinding.ItemPhotoBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 6/28/21 by Pengkuh Dwi Septiandi (@pengdst)
 * <p>
 * - Github https://github.com/pengdst
 * - Gitlab https://gitlab.com/pengdst
 * - LinkedIn https://linkedin.com/in/pengdst
 */
public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder> {

    private List<String> images = new ArrayList<>();

    public void submitImages(List<String> imageUrls) {
        images = imageUrls;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPhotoBinding binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhotoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        holder.bind(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class PhotoViewHolder extends RecyclerView.ViewHolder {
        private final ItemPhotoBinding binding;

        public PhotoViewHolder(@NonNull ItemPhotoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String imageUrl) {
            Glide.with(itemView)
                    .load(imageUrl)
                    .into(binding.image);
        }
    }
}
