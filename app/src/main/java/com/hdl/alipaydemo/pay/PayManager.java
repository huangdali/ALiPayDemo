package com.hdl.alipaydemo.pay;

import android.app.Activity;

import com.hdl.alipaydemo.pay.bean.PayCallback;
import com.hdl.alipaydemo.pay.bean.PayType;

/**
 * 支付管理器
 * Created by HDL on 2017/6/19.
 */

public class PayManager<T> {
    private IPayStrategy payStrategy;
    private Activity context;

    public PayManager(Activity context, PayType type) {
        this.context = context;
        switch (type) {
            case ALIPAY://支付宝支付策略类
                payStrategy = new ALiPayStrategy();
                break;
            case WXPAY://微信支付策略类
                payStrategy = new WXPayStrategy();
                break;
        }
    }

    /**
     * 开始支付
     * <br/>
     * 支付宝支付见{@link ALiPayStrategy#pay(Activity, String, PayCallback)}
     * <br/>
     * 微信支付见{@link WXPayStrategy#pay(Activity, Object, PayCallback)}
     *
     * @param orderInfo 通过服务器加密过的订单信息
     * @param callback  支付进度回调
     */
    public void pay(T orderInfo, PayCallback callback) {
        payStrategy.pay(context, orderInfo, callback);
    }
}
