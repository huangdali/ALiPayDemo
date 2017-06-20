package com.hdl.alipaydemo.pay;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import com.hdl.alipaydemo.pay.bean.PayCallback;
import com.hdl.alipaydemo.pay.bean.WXPayOrderInfo;
import com.hdl.alipaydemo.pay.global.Constants;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * 微信支付策略类
 * Created by HDL on 2017/6/19.
 */

public class WXPayStrategy implements IPayStrategy<WXPayOrderInfo> {
    private Activity mActivity;
    private IWXAPI wxAPI;//微信api
    private PayCallback callback;

    /**
     * 发起支付
     *
     * @param context
     * @param orderInfo 订单信息(此订单信息必须为从服务器获取加密之后的订单信息)
     * @param callback  支付回调{@link PayCallback}
     */
    @Override
    public void pay(Activity context, WXPayOrderInfo orderInfo, PayCallback callback) {
        this.mActivity = context;
        this.callback = callback;
        this.callback.onStart();//开始调起支付
        initSdk(mActivity, orderInfo.getAppId());
        PayReq request = new PayReq();
        request.appId = orderInfo.getAppId();//app编号
        request.partnerId = orderInfo.getPartnerId();//商户号
        request.prepayId = orderInfo.getPrepayId();//预支付交易会话ID,由服务器返回
        request.packageValue = orderInfo.getPackageValue();//固定值
        request.nonceStr = orderInfo.getNonceStr();//随机字符串
        request.timeStamp = orderInfo.getTimeStamp();//时间戳
        request.sign = orderInfo.getSign();//签名
        request.extData = orderInfo.getExtData();//扩展信息
        wxAPI.sendReq(request);//调起微信支付
    }

    /**
     * 初始化sdk
     *
     * @param mActivity
     */
    private void initSdk(Activity mActivity, String appId) {
        wxAPI = WXAPIFactory.createWXAPI(mActivity, appId);
        wxAPI.registerApp(appId);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(mActivity);
        IntentFilter wxPayResult = new IntentFilter();
        wxPayResult.addAction(Constants.BroadcastAction.KEY_ACTION_WXPAY_SUCCESS);
        wxPayResult.addAction(Constants.BroadcastAction.KEY_ACTION_WXPAY_FAILED);
        wxPayResult.addAction(Constants.BroadcastAction.KEY_ACTION_WXPAY_CANCEL);
        localBroadcastManager.registerReceiver(new WXPayResultBroadcastReceiver(), wxPayResult);
    }

    /**
     * 微信支付结果的本地广告类
     */
    class WXPayResultBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case Constants.BroadcastAction.KEY_ACTION_WXPAY_SUCCESS:
                    String result = intent.getStringExtra("result");//可以不要结果
                    callback.onSuccess(result);
                    break;
                case Constants.BroadcastAction.KEY_ACTION_WXPAY_FAILED:
                    String failMsg = intent.getStringExtra("failMsg");
                    callback.onError("-1", new Throwable(failMsg));
                    break;
                case Constants.BroadcastAction.KEY_ACTION_WXPAY_CANCEL:
                    callback.onCancle();
                    break;
            }
        }
    }
}
