package com.tarandigitalempire.bankigame.data;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class GameSingleton  {

    private static GameSingleton mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private GameSingleton(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized GameSingleton getInstance(Context context) {

        if (mInstance == null) {
            mInstance = new GameSingleton(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
