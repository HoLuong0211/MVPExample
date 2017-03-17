package ominext.com.mvpexample.api;

import android.os.Handler;

import ominext.com.mvpexample.listener.OnResponse;

/**
 * Created by LuongHH on 3/17/2017.
 */

public class ApiRequest {

    private static final String TAG = ApiRequest.class.getSimpleName();

    public static void login(final String username, final String password, final OnResponse onResponse) {
        onResponse.onStart();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (username.length() > 0 && password.length() > 0) {
                    String response = "{\"name\": \"aloha\", \"nickname\": \"azure\"}";
                    onResponse.onResponseSuccess(TAG, response);
                } else {
                    onResponse.onResponseError(TAG, "Username or password incorrect!");
                }
                onResponse.onFinish();
            }
        }, 2000);

    }
}
