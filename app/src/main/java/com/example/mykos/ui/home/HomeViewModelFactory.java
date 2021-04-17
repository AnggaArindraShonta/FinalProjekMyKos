package com.example.mykos.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mykos.networking.ApiInterface;

public class HomeViewModelFactory implements ViewModelProvider.Factory {
    private final ApiInterface apiInterface;

    public HomeViewModelFactory(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new HomeViewModel(apiInterface);
    }
}
