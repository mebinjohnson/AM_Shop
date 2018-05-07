package com.malkove.app.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIDelegate {
    @GET("posts")
    Call<String> getAllPosts();
}
