package com.example.mykos.ui.sigin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mykos.R;
import com.example.mykos.databinding.ActivitySignInBinding;
import com.example.mykos.ui.HomeActivity;
import com.example.mykos.utils.SharedPrefManager;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignInActivity extends AppCompatActivity {

    private MaterialEditText etEmail;
    private MaterialEditText etPassword;
    private ImageButton btnSignIn;

    private SignInViewModel signInViewModel;

    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        etEmail = binding.email;
        etPassword = binding.password;
        btnSignIn = binding.btnsignin;

        subscribeToObservers();

        initViewModel();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        login();
    }

    private void initViewModel() {
        SharedPrefManager sharedPrefManager = new SharedPrefManager(this);
        ViewModelProvider.Factory factory = new SignInViewModelFactory(sharedPrefManager);
        signInViewModel = new ViewModelProvider(this, factory).get(SignInViewModel.class);
    }

    private void subscribeToObservers() {
        signInViewModel.observeIsLogin().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isSuccessLogin) {
                if (isSuccessLogin){
                    Intent i = new Intent(SignInActivity.this, HomeActivity.class);
                    finishAffinity();
                    startActivity(i);
                }else {
                    Toast.makeText(SignInActivity.this, "username dan password salah :)", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void login() {
        if (etEmail.getText() == null || etPassword.getText() == null) return;

        final String email = etEmail.getText().toString();
        final String password = etPassword.getText().toString();

        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(SignInActivity.this, "username dan password tidak boleh kosong :)", Toast.LENGTH_SHORT).show();
        }else{
            signInViewModel.login(email, password);
        }
    }
}