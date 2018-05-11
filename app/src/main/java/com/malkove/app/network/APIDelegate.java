package com.malkove.app.network;

import com.malkove.app.models.Blog;
import com.malkove.app.models.Media;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIDelegate {
    @GET("posts")
    Call<List<Blog>> getAllPosts();

    @GET("posts/{id}")
    Call<Blog> getPostById(@Path("id") int id);

    @GET("media/{id}")
    Call<Media> getMediaInfo(@Path("id") int id);
}
