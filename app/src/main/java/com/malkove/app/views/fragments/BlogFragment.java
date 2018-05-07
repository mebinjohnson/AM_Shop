package com.malkove.app.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malkove.app.views.BlogAdapter;
import com.malkove.app.views.R;
import com.malkove.app.views.SpacesItemDecoration;

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


        BlogAdapter adapter = new BlogAdapter(getActivity());
        mRecyclerView.setAdapter(adapter);

        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        mRecyclerView.addItemDecoration(decoration);


        return RootView;
    }
}