package com.hdl.alipaydemo.pay.bean;

/**
 * 支付回调
 * Created by HDL on 2017/6/19.
 */

public interface PayCallback<T> {
    /**
     * 开始支付的时候回调
     */
    void onStart();

    /**
     * 支付出错的时候回调
     *
     * @param errorCode
     * @param throwable
     */
    void onError(String errorCode, Throwable throwable);

    /**
     * 支付成功的时候回调
     */
    void onSuccess(T t);
}
