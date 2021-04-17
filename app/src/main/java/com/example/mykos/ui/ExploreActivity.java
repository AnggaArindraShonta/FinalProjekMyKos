package com.example.mykos.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mykos.databinding.ActivityExploreBinding;

public class ExploreActivity extends AppCompatActivity {

    private ActivityExploreBinding binding;

    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExploreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnExploreNow.setOnClickListener(v -> {
            Intent i = new Intent(ExploreActivity.this, HomeActivity.class);
            finishAffinity();
            startActivity(i);
        });
    }
}