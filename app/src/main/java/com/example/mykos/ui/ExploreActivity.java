package com.example.mykos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.mykos.R;

public class ExploreActivity extends AppCompatActivity {

    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        button = findViewById(R.id.flatsplash);
        button.setOnClickListener(v -> {
            Intent i = new Intent(ExploreActivity.this, HomeActivity.class);
            finishAffinity();
            startActivity(i);
        });

    }
}