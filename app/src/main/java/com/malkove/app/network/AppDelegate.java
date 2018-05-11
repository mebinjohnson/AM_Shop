package com.malkove.app.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.malkove.app.views.BuildConfig;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Slf4j
public class AppDelegate {
    private static final String BASE_URL = "http://demo.malkove.com/wp-json/wp/v2/";
    private static AppDelegate _inst = new AppDelegate();
    private APIDelegate serviceApi;

    public static AppDelegate getInstance() {
        return _inst;
    }

    public APIDelegate get() {
        if (serviceApi == null || BuildConfig.DEBUG) {
            serviceApi = new Retrofit.Builder()
                    .addConverterFactory(buildGsonConverter())
                    .baseUrl(BASE_URL).client(httpClient().build())
                    .build()
                    .create(APIDelegate.class);
        }
        return serviceApi;
    }

    private OkHttpClient.Builder httpClient() {
        val logging = new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(new RetrofitInterceptor()).addInterceptor(logging).readTimeout(2, TimeUnit.MINUTES).retryOnConnectionFailure(true).connectTimeout(BuildConfig.DEBUG ? 4 : 20, TimeUnit.SECONDS);
    }

    private GsonConverterFactory buildGsonConverter() {
        Gson myGson = new GsonBuilder()./*setExclusionStrategies(new AnnotationExclusionStrategy()).*/create();
        return GsonConverterFactory.create(myGson);
    }

    public boolean hasInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean hasInternet = networkInfo != null && networkInfo.isConnected();
        if (!hasInternet)
            log.debug("Network check status :{}", hasInternet);
        return hasInternet;
    }
   /* class AnnotationExclusionStrategy implements ExclusionStrategy {
        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            return f.getAnnotation(Exclude.class) != null;
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    }*/
}