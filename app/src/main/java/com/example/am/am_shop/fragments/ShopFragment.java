package com.example.am.am_shop.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.am.am_shop.R;
import com.example.am.am_shop.ShopItemAdapter;
import com.example.am.am_shop.SpacesItemDecoration;
import com.facebook.drawee.view.SimpleDraweeView;

public class ShopFragment extends Fragment {

    RecyclerView mRecyclerView;

    public ShopFragment() {
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
         View RootView=inflater.inflate(R.layout.fragment_shop, container, false);

        mRecyclerView = (RecyclerView) RootView.findViewById(R.id.recycler_grid);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


        ShopItemAdapter adapter = new ShopItemAdapter(getActivity());
        mRecyclerView.setAdapter(adapter);

        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        mRecyclerView.addItemDecoration(decoration);

        return RootView;
    }


}

