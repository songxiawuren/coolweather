package com.coolweather.util;

/**
 * Created by byn on 2015/5/29.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
