package com.example.administrator.douyuanchor.util;

/**
 * Created by Administrator on 2016/8/25.
 */
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
