package com.mattfred.advancedandroid.dagger;

import com.mattfred.advancedandroid.retofitService.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Dagger Rest module
 */
@Module
public class NetModule {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Provides
    @Singleton
    ApiService providesRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiService.class);
    }
}
