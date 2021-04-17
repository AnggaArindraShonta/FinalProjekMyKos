package com.example.mykos.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mykos.R;
import com.example.mykos.adapter.AdapterData;
import com.example.mykos.model.Kos;
import com.example.mykos.networking.ApiClient;
import com.example.mykos.networking.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private AdapterData adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Kos> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<Kos>() {
            @Override
            public void onResponse(Call<Kos>call, Response<Kos> response) {
                String kosList = response.body().getId();
                Log.d(TAG, "Number of movies received: " + kosList.length());
                Toast.makeText(HomeActivity.this, "Number of movies received: " + kosList.length(), Toast.LENGTH_LONG).show();
                recyclerView.setAdapter(new AdapterData(kosList, R.layout.list_recomended, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<Kos>call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}