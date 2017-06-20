package com.hdl.alipaydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alipay.sdk.app.EnvUtils;
import com.hdl.alipaydemo.pay.PayManager;
import com.hdl.alipaydemo.pay.bean.PayCallback;
import com.hdl.alipaydemo.pay.bean.PayType;
import com.hdl.alipaydemo.pay.bean.WXPayOrderInfo;
import com.hdl.alipaydemo.pay.utils.AnglogOrderInfoUtil;
import com.hdl.elog.ELog;

/**
 * 正式环境需要删除pay/utils文件夹中的所有类-----没有使用
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);//沙箱支付【正式环境需删除】
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onAliPay(View view) {
        alipay(AnglogOrderInfoUtil.getAliPayOrderInfo());
    }


    private void alipay(final String orderInfo) {
        new PayManager<String>(this, PayType.ALIPAY)
                .pay(orderInfo, new PayCallback() {
                    @Override
                    public void onStart() {
                        ELog.e("开始了");
                    }

                    @Override
                    public void onError(String errorCode, Throwable throwable) {
                        ELog.e("出错了" + errorCode + " " + throwable);
                    }

                    @Override
                    public void onSuccess(Object o) {
                        ELog.e("" + o);
                    }

                    @Override
                    public void onCancle() {

                    }
                });
    }

    public void onWeChat(View view) {
        wechatPay(AnglogOrderInfoUtil.getWxPayOrderInfo());
    }

    /**
     * 微信支付
     *
     * @param wxPayOrderInfo 订单信息
     */
    private void wechatPay(WXPayOrderInfo wxPayOrderInfo) {

        new PayManager<WXPayOrderInfo>(this, PayType.WXPAY)
                .pay(wxPayOrderInfo, new PayCallback() {
                    @Override
                    public void onStart() {
                        ELog.e("开始了");
                    }

                    @Override
                    public void onError(String errorCode, Throwable throwable) {
                        ELog.e("出错了" + errorCode + " " + throwable);
                    }

                    @Override
                    public void onSuccess(Object o) {
                        ELog.e("" + o);
                    }

                    /**
                     * 支付取消的时候会回调
                     */
                    @Override
                    public void onCancle() {

                    }
                });
    }
}
