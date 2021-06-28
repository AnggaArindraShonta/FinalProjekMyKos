package com.example.mykos.networking;

import com.example.mykos.model.Kos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("recommended-spaces")
    Call<List<Kos>> getRecommendedSpace();

    @GET("detail-spaces")
    Call<List<Kos>> getDetailSpace();
}
