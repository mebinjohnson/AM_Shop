package com.malkove.app.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class GsonHelper<T> {

    private static GsonHelper _inst = new GsonHelper();
    private Gson gson = new Gson();

    public static GsonHelper getInstance() {
        return _inst;
    }

    public static String serializeWithNulls(Object obj) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        Gson gson = gsonBuilder.create();
        return gson.toJson(obj);
    }

    public String string(T t) {
        return gson.toJson(t);
    }

    public T toClass(String json, Class<T> t) {
        try {
            if (gson == null)
                gson = new Gson();
            ;
            return gson.fromJson(json, t);
        } catch (JsonSyntaxException e) {
            return null;
        }
    }
}
