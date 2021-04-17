package com.example.mykos.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mykos.databinding.ActivityExploreBinding;
import com.example.mykos.ui.sigin.SignInActivity;

public class ExploreActivity extends AppCompatActivity {

    private ActivityExploreBinding binding;

    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExploreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnExploreNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ExploreActivity.this, HomeActivity.class);
                finishAffinity();
                startActivity(i);
            }
        });
    }
}