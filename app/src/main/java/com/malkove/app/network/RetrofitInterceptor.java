package com.malkove.app.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.malkove.app.views.BuildConfig;

import java.io.IOException;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static android.os.Build.VERSION.SDK_INT;

@Slf4j
public class RetrofitInterceptor implements Interceptor {
    private Gson gson;

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        if (gson == null) {
            gson = new GsonBuilder().setPrettyPrinting().create();
        }
        return responseIntercept(chain.proceed(requestIntercept(chain.request())));
    }

    private Request requestIntercept(Request request) {
        request = request.newBuilder()
                .addHeader("sdk-version", String.valueOf(SDK_INT))
                .addHeader("api-version", String.valueOf(3))
                .addHeader("app-version", String.valueOf(BuildConfig.VERSION_CODE))
                .addHeader("app-version-name", BuildConfig.VERSION_NAME)
                .method(request.method(), request.body()).build();
        return request;
    }

    private Response responseIntercept(Response response) {
        if (!response.isSuccessful()) {
            if (response.code() == 401) {
                log.error("Session doesn't exist or expired");
            }
        }
        return response;
    }
}