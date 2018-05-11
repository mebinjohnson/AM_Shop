package com.malkove.app.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malkove.app.models.Blog;
import com.malkove.app.network.AppDelegate;
import com.malkove.app.utilities.GsonHelper;
import com.malkove.app.views.BlogAdapter;
import com.malkove.app.views.R;
import com.malkove.app.views.SpacesItemDecoration;

import java.io.IOException;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Slf4j
public class BlogFragment extends Fragment {
    RecyclerView mRecyclerView;

    public BlogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View RootView = inflater.inflate(R.layout.fragment_blog, container, false);

        mRecyclerView = (RecyclerView) RootView.findViewById(R.id.recycler_blog);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));


        fetchBlogs();

        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        mRecyclerView.addItemDecoration(decoration);

        return RootView;
    }


    private void fetchBlogs() {
        AppDelegate.getInstance().get().getAllPosts().enqueue(new Callback<List<Blog>>() {
            @Override
            public void onResponse(Call<List<Blog>> call, Response<List<Blog>> response) {
                if (response.isSuccessful()) {
                    log.debug(GsonHelper.getInstance().string(response.body()));

                    BlogAdapter adapter = new BlogAdapter(getActivity(), response.body());
                    mRecyclerView.setAdapter(adapter);
                } else {
                    try {
                        log.error(response.errorBody().string());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Blog>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}