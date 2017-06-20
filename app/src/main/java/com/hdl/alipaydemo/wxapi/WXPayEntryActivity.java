package com.hdl.alipaydemo.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hdl.alipaydemo.R;
import com.hdl.alipaydemo.pay.global.Constants;
import com.hdl.elog.ELog;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    private IWXAPI api;
    private TextView tv_pay_result_msg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_result);
        tv_pay_result_msg = (TextView) findViewById(R.id.tv_pay_result_msg);
        tv_pay_result_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//点击的时候销毁当前页面
            }
        });
        api = WXAPIFactory.createWXAPI(this, Constants.KEY_WX_APPID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        //发送本地广播
        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);
        ELog.e("dali", resp.errStr);
        ELog.e("dali", resp.errCode);
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            Toast.makeText(this, "微信支付结果" + resp.errCode, Toast.LENGTH_SHORT).show();
            switch (resp.errCode) {
                case 0:
                    tv_pay_result_msg.setText("支付成功");
                    broadcastManager.sendBroadcast(new Intent(Constants.BroadcastAction.KEY_ACTION_WXPAY_SUCCESS));
                    break;
                case -1:
                    tv_pay_result_msg.setText("支付异常");
                    broadcastManager.sendBroadcast(new Intent(Constants.BroadcastAction.KEY_ACTION_WXPAY_FAILED));
                    break;
                case -2:
                    tv_pay_result_msg.setText("取消支付");
                    //用户取消了，可以不做任何操作
                    broadcastManager.sendBroadcast(new Intent(Constants.BroadcastAction.KEY_ACTION_WXPAY_CANCEL));
                    break;
            }
        }
    }
}