package com.example.mykos.ui.SharedPref;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    public SharedPrefManager(Context context) {
        sharedPreferences = context.getSharedPreferences("latihan_shared_preference",context.MODE_PRIVATE);
        editor =sharedPreferences.edit();
    }

    public void saveString(String value) {
        editor.putString("ini_string",value);
        editor.commit();
    }

    public String getString() {
        return sharedPreferences.getString("ini_string", "");
    }
    public String getUsername(){
        return sharedPreferences.getString("sp_email", "anggaarindra@gmail.com");
    }

    public String getPassword(){
        return sharedPreferences.getString("sp_password", "0423");
    }

    public void saveIsLogin(Boolean value){
        editor.putBoolean("sp_islogin",value);
        editor.commit();
    }
    public boolean getIsLogin() {
        return sharedPreferences.getBoolean("sp_islogin", false);
    }
}
