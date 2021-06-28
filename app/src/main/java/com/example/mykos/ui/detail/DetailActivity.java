package com.example.mykos.ui.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mykos.R;
import com.example.mykos.model.Kos;
import com.example.mykos.ui.photos.PhotosAdapter;

import static com.example.mykos.utils.Constant.KEY_INTENT_KOS;

public class DetailActivity extends AppCompatActivity {

    TextView txtharga, txtkitchen, txtbedroom, txtlemari, txtalamat;
    RecyclerView rvPhotos;
    ImageView maps;
    Button phone;
    PhotosAdapter photosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
        setupView();
    }

    private void init() {
        txtharga = findViewById(R.id.txtharga);
        txtkitchen = findViewById(R.id.txtkitchen);
        txtbedroom = findViewById(R.id.txtbedroom);
        txtlemari = findViewById(R.id.txtlemari);
        txtalamat = findViewById(R.id.txtalamat);
        maps = findViewById(R.id.maps);
        phone = findViewById(R.id.phone);
        rvPhotos = findViewById(R.id.rv_photos);

        photosAdapter = new PhotosAdapter();
        rvPhotos.setAdapter(photosAdapter);
        rvPhotos.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
    }

    private void setupView() {
        if (getIntent().hasExtra(KEY_INTENT_KOS)) {
            Kos kos = (Kos) getIntent().getSerializableExtra(KEY_INTENT_KOS);


            txtharga.setText(kos.getPrice());
            txtkitchen.setText(kos.getNumber_of_kitchens());
            txtbedroom.setText(kos.getNumber_of_bedrooms());
            txtlemari.setText(kos.getNumber_of_cupboards());
            txtalamat.setText(kos.getAddress());

            photosAdapter.submitImages(kos.getPhotos());

            phone.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+kos.getPhone()));
                startActivity(intent);
            });

            maps.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(kos.getMap_url()));
                startActivity(intent);
            });
        }
    }
}