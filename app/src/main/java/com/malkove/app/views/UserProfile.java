package com.malkove.app.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class UserProfile extends AppCompatActivity {
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Button pinbtn = findViewById(R.id.button_user_pinned_blogs);
        Button scartbtn = findViewById(R.id.button_user_shopping_cart);
        Button wishbtn = findViewById(R.id.button_user_wishlist);
        Button morderbtn = findViewById(R.id.button_user_my_orders);
        Button rewardbtn = findViewById(R.id.button_user_rewards);

        pinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserProfile.this, PinnedBlogs.class));
            }
        });

        scartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserProfile.this, ShoppingCart.class));
            }
        });

        wishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserProfile.this, WishList.class));
            }
        });

        morderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserProfile.this, MyOrders.class));
            }
        });

        rewardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Set Rewards Link
            }
        });
    }
}
