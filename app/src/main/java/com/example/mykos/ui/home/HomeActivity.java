package com.example.mykos.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykos.R;
import com.example.mykos.adapter.AdapterData;
import com.example.mykos.networking.ApiClient;
import com.example.mykos.networking.ApiInterface;
import com.example.mykos.ui.detail.DetailActivity;
import static com.example.mykos.utils.Constant.KEY_INTENT_KOS;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();
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

        setupView();
    }

    private void setupView() {
        adapter.setOnItemCLickListener((view, kos, position) -> {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(KEY_INTENT_KOS, kos);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        subscribeToObservers();
    }

    private void subscribeToObservers() {
        homeViewModel.observeRecommendedSpaces().observe(this, list -> adapter.updateList(list));
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