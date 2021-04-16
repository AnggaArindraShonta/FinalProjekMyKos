package com.example.mykos.SharedPref;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    SharedPreferences pref;

    public SharedPrefManager(Context context) {
        pref = context.getSharedPreferences("latihan_shared_preference", Context.MODE_PRIVATE);
    }

    public void saveString(String value) {
        pref.edit().putString("ini_string", value).apply();
    }

    public String getString() {
        return pref.getString("ini_string", "");
    }

    public String getUsername() {
        return pref.getString("sp_email", "anggaarindra@gmail.com");
    }

    public String getPassword() {
        return pref.getString("sp_password", "0423");
    }

    public void saveIsLogin(Boolean value) {
        pref.edit().putBoolean("sp_islogin", value).apply();
    }

    public boolean getIsLogin() {
        return pref.getBoolean("sp_islogin", false);
    }
}
