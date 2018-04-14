package com.example.am.am_shop;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class App extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("raleway_regular.ttf")    //specify
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
