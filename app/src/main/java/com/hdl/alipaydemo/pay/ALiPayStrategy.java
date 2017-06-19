package com.hdl.alipaydemo.pay;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.alipay.sdk.app.PayTask;
import com.hdl.alipaydemo.pay.bean.PayCallback;
import com.hdl.alipaydemo.pay.bean.PayResultForALiPay;
import com.hdl.elog.ELog;

import java.util.Map;

/**
 * 支付宝支付策略
 * Created by HDL on 2017/6/19.
 */

public class ALiPayStrategy implements IPayStrategy {
    /**
     * 支付开始的时候标记
     */
    private static final int WHAT_PAY_START = 340;
    /**
     * 支付发生错误的时候标记
     */
    private static final int WHAT_PAY_ERROR = 341;
    /**
     * 支付成功的时候标记
     */
    private static final int WHAT_PAY_SUCCESS = 342;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case WHAT_PAY_START:
                    callback.onStart();
                    break;
                case WHAT_PAY_ERROR:
                    callback.onError("", new Throwable(""));
                    break;
                case WHAT_PAY_SUCCESS:
                    callback.onSuccess("");
                    break;
            }
        }
    };

    private PayCallback callback;


    /**
     * 发起支付
     *
     * @param orderInfo 订单信息
     */
    @Override
    public void pay(final Activity context, final String orderInfo, PayCallback callback) {
        if (TextUtils.isEmpty(orderInfo)) {
            return;
        }
        this.callback = callback;
        mHandler.sendEmptyMessage(WHAT_PAY_START);
        new Thread() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(context);
                String version = alipay.getVersion();//获取开发包版本号
                ELog.e("version=" + version);
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Log.e("hdltag", "run(MainActivity.java:30):" + result);
                PayResultForALiPay payResultForALiPay = new PayResultForALiPay(result);
                ELog.e("dali", payResultForALiPay.toString());
                if ("9000".equals(payResultForALiPay.getResultStatus())) {//沙箱环境的结果码
                    mHandler.sendEmptyMessage(WHAT_PAY_SUCCESS);
                } else {
                    mHandler.sendEmptyMessage(WHAT_PAY_ERROR);
                }
            }
        }.start();
    }
}
