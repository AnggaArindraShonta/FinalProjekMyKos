package com.example.mykos.ui.home;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykos.R;
import com.example.mykos.adapter.AdapterData;
import com.example.mykos.model.Kos;
import com.example.mykos.networking.ApiClient;
import com.example.mykos.networking.ApiInterface;
import com.example.mykos.ui.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private AdapterData adapter;

    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        adapter = new AdapterData();
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        initViewModel();

        getRecommendedSpaces();
    }

    @Override
    protected void onResume() {
        super.onResume();

        subscribeToObservers();
    }

    private void subscribeToObservers() {
        homeViewModel.observeRecommendedSpaces().observe(this, new Observer<List<Kos>>() {
            @Override
            public void onChanged(List<Kos> list) {
                adapter.updateList(list);
            }
        });
    }

    private void initViewModel() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        ViewModelProvider.Factory factory = new HomeViewModelFactory(apiService);
        homeViewModel = new ViewModelProvider(this, factory).get(HomeViewModel.class);
    }

    private void getRecommendedSpaces() {
        homeViewModel.getRecommendedSpaces();
    }
}