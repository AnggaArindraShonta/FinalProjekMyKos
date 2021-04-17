package com.example.mykos.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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

        adapter = new AdapterData();
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        getRecommendedSpaces();
    }

    private void getRecommendedSpaces() {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Kos>> call = apiService.getRecommendedSpace();
        call.enqueue(new Callback<List<Kos>>() {
            @Override
            public void onResponse(Call<List<Kos>> call, Response<List<Kos>> response) {
                if (response.isSuccessful()){
                    List<Kos> kosList = response.body();
                    adapter.updateList(kosList);
                    Log.d(TAG, "Number of movies received: " + kosList.size());
                }
            }

            @Override
            public void onFailure(Call<List<Kos>> call, Throwable t) {

            }
        });
    }
}