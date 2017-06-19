package com.hdl.alipaydemo.pay;

import android.app.Activity;

import com.hdl.alipaydemo.pay.bean.PayCallback;

/**
 * 微信支付策略类
 * Created by HDL on 2017/6/19.
 */

public class WeChatPayStrategy implements IPayStrategy {
    /**
     * 发起支付
     *
     * @param context
     * @param orderInfo 订单信息(此订单信息必须为从服务器获取加密之后的订单信息)
     * @param callback  支付回调{@link PayCallback}
     */
    @Override
    public void pay(Activity context, String orderInfo, PayCallback callback) {

    }
}
