package ominext.com.mvpexample.listener;

/**
 * Created by vinh on 6/8/16.
 */
public abstract class OnResponse {
    public void onStart(){}
    public void onFinish(){}
    public abstract void onResponseSuccess(String tag, String response);
    public abstract void onResponseError(String tag, String message);
}

