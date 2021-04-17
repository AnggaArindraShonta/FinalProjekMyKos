package com.example.mykos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mykos.R;
import com.example.mykos.SharedPref.SharedPrefManager;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignInActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private SharedPrefManager sharedPrefManager;
    private MaterialEditText etEmail;
    private MaterialEditText etPassword;
    private ImageButton btnsignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        sharedPrefManager = new SharedPrefManager(this);
        etEmail = findViewById(R.id.email);
        etPassword = findViewById(R.id.password);
        btnsignin = findViewById(R.id.btnsignin);

        login();
    }
    private void login() {
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()){
                    Toast.makeText(SignInActivity.this, "username dan password salah :)", Toast.LENGTH_SHORT).show();
                }else{
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            String spEmail = sharedPrefManager.getUsername();
                            String spPassword = sharedPrefManager.getPassword();

                            Log.d("email","email"+email);
                            Log.d("password","pass"+password);

                            if (email.equals(spEmail) && password.equals(spPassword)){
                                Intent i = new Intent(SignInActivity.this, HomeActivity.class);
                                sharedPrefManager.saveIsLogin(true);
                                finishAffinity();
                                startActivity(i);
                            }else {
                                Toast.makeText(SignInActivity.this, "username dan password salah :)", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, 3000);
                }
            }
        });
    }
}