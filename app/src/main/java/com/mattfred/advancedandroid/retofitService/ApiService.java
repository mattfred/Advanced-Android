package com.mattfred.advancedandroid.retofitService;

import com.mattfred.advancedandroid.models.Post;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Retrofit call interface
 */

public interface ApiService {

    @GET("/posts/1")
    Call<Post> getPost();
}
