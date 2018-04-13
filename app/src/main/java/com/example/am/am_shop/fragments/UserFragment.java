package com.example.am.am_shop.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.am.am_shop.R;
import com.example.am.am_shop.ShopItemActivity;
import com.mikhaellopez.circularimageview.CircularImageView;

public class UserFragment extends Fragment {
    CircularImageView img;

    public UserFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_user, container, false);

        img = (CircularImageView) rootView.findViewById(R.id.user_image);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShopItemActivity.class);
                startActivity(intent);
            }
        });
        return rootView;

    }
}