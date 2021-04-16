package com.example.mykos.ui.sigin;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mykos.utils.SharedPrefManager;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SignInViewModel extends ViewModel {

    private SharedPrefManager prefManager;
    private Handler handler = new Handler();

    @Inject
    public SignInViewModel(SharedPrefManager prefManager) {
        this.prefManager = prefManager;
    }

    private MutableLiveData<Boolean> isSuccessLogin = new MutableLiveData<>();

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
                    isSuccessLogin.postValue(true);
                }else {
                    isSuccessLogin.postValue(false);
                }
            }
        }, 3000);
    }

    public LiveData<Boolean> observeIsLogin(){
        return isSuccessLogin;
    }

    public boolean checkIsLoggedIn() {
        return prefManager.getIsLogin();
    }
}
