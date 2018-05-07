package com.malkove.app.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.malkove.app.views.MyOrders;
import com.malkove.app.views.PinnedBlogs;
import com.malkove.app.views.R;
import com.malkove.app.views.ShoppingCart;
import com.malkove.app.views.WishList;


public class UserFragment extends Fragment {


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


        Button pinbtn = rootView.findViewById(R.id.button_user_pinned_blogs);
        Button scartbtn = rootView.findViewById(R.id.button_user_shopping_cart);
        Button wishbtn = rootView.findViewById(R.id.button_user_wishlist);
        Button morderbtn = rootView.findViewById(R.id.button_user_my_orders);
        Button rewardbtn = rootView.findViewById(R.id.button_user_rewards);

        pinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PinnedBlogs.class));
            }
        });

        scartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ShoppingCart.class));
            }
        });

        wishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), WishList.class));
            }
        });

        morderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MyOrders.class));
            }
        });

        rewardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Set Rewards Link
            }
        });

        return rootView;

    }
}