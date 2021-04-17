package com.example.mykos.ui.home;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mykos.model.Kos;
import com.example.mykos.networking.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    private ApiInterface apiInterface;
    private Handler handler = new Handler();

    private MutableLiveData<List<Kos>> recommendedSpaces = new MutableLiveData<>();

    public HomeViewModel(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public void getRecommendedSpaces(){
        Call<List<Kos>> call = apiInterface.getRecommendedSpace();
        call.enqueue(new Callback<List<Kos>>() {
            @Override
            public void onResponse(Call<List<Kos>> call, Response<List<Kos>> response) {
                if (response.isSuccessful()) {
                    List<Kos> kos = response.body();
                    recommendedSpaces.postValue(kos);
                }
            }

            @Override
            public void onFailure(Call<List<Kos>> call, Throwable t) {

            }
        });
    }

    public LiveData<List<Kos>> observeRecommendedSpaces(){
        return recommendedSpaces;
    }
}
