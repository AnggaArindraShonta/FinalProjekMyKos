package com.example.mykos.di;

import android.content.Context;

import com.example.mykos.utils.SharedPrefManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public SharedPrefManager provideSharePrefManager(@ApplicationContext Context context){
        return new SharedPrefManager(context);
    }
}
