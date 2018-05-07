package com.malkove.app.views;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class WishList extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //To make the status bar light themed with dark icons
        getWindow().setStatusBarColor(Color.parseColor("#eeeeee")); //TODO: Add the status bar color here instead of WHITE

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
