package com.hdl.alipaydemo.pay.global;

/**
 * 全局字段
 * Created by HDL on 2017/6/20.
 */

public class Constants {
    /**
     * 微信支付的appid
     */
    public static final String KEY_WX_APPID = "wxf8b4f85f3a794e77";
    /**
     * 支付宝支付的appid
     */
    public static final String KEY_ALIPAY_APPID = "2016080400163745";

    /**
     * 广播接收器的action，全局定义
     */
    public class BroadcastAction {
        /**
         * 微信支付成功的action【正式环境建议将com.hdl.alipaydemo替换为你的包名】
         */
        public static final String KEY_ACTION_WXPAY_SUCCESS = "com.hdl.alipaydemo.receiver.wxpay.SUCCESS";
        /**
         * 微信支付失败的action【正式环境建议将com.hdl.alipaydemo替换为你的包名】
         */
        public static final String KEY_ACTION_WXPAY_FAILED = "com.hdl.alipaydemo.receiver.wxpay.FAILED";
        /**
         * 微信支付取消的action【正式环境建议将com.hdl.alipaydemo替换为你的包名】
         */
        public static final String KEY_ACTION_WXPAY_CANCEL = "com.hdl.alipaydemo.receiver.wxpay.CANCEL";
    }
}
