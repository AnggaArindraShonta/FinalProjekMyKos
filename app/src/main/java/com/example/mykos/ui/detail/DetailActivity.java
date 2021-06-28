package com.example.mykos.ui.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mykos.R;
import com.example.mykos.model.Kos;

public class DetailActivity extends AppCompatActivity {

    TextView txtharga, txtkitchen, txtbedroom, txtlemari, txtalamat;
    ImageView maps;
    Button phone;


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
    }

    private void setupView() {
        if (getIntent().hasExtra(KEY_INTENT_KOS)) {
            Kos kos = (Kos) getIntent().getSerializableExtra(KEY_INTENT_KOS);


            txtharga.setText(kos.getPrice());
            txtkitchen.setText(kos.getNumber_of_kitchens());
            txtbedroom.setText(kos.getNumber_of_bedrooms());
            txtlemari.setText(kos.getNumber_of_cupboards());
            txtalamat.setText(kos.getAddress());
            maps.(kos.getMap_url());
            phone.setText(kos.getPhone());

            Glide.with(DetailActivity.this)
                    .load(kos.getPhotos());
                    .into();
        }
    }
}