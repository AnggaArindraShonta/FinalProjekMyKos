package com.example.mykos.ui.sigin;

import android.os.Handler;
import android.util.Log;

import com.example.mykos.utils.SharedPrefManager;

public class SignInPresenter {

    private SignInView signInView;
    private Handler handler = new Handler();
    private SharedPrefManager prefManager;

    public SignInPresenter(SignInView signInView, SharedPrefManager prefManager) {
        this.signInView = signInView;
        this.prefManager = prefManager;
    }

    public void login(String email, String password){

        String spEmail = prefManager.getUsername();
        String spPassword = prefManager.getPassword();

        Log.d("email","email" + email);
        Log.d("password","pass" + password);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (email.equals(spEmail) && password.equals(spPassword)){
                    prefManager.saveIsLogin(true);
                    signInView.onLoginSuccess();
                }else {
                    signInView.onLoginFailed();
                }
            }
        }, 3000);
    }

    public boolean checkIsLoggedIn() {
        return prefManager.getIsLogin();
    }
}
