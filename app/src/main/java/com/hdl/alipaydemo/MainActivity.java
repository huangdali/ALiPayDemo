package com.hdl.alipaydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alipay.sdk.app.EnvUtils;
import com.hdl.alipaydemo.pay.bean.PayCallback;
import com.hdl.alipaydemo.pay.PayManager;
import com.hdl.alipaydemo.pay.bean.PayType;
import com.hdl.alipaydemo.pay.utils.OrderInfoALiPayUtil;
import com.hdl.elog.ELog;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_APPID = "2016080400163745";
    private String orderInfo = "";
    private static final String KEY_RSA2_PRIVATE = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCBRv+XWTDkc4AcsnDvFy4Fd4qOV5b0oTWqirTFwIu98zCidKpgq6ve3hkRIu+skOf1wEuSlQbnD2yAGW68X++oL4x3JgeE5Vp6vFlQi/eSTaj2TjNcAtCAScCXrh5gMqEoFRWHI6Gx11Zrk+rYA2r/5BPP9P5uD5W/OeckN+AVlDAk5dgWuNfIBvYi40MYnl9bwWOb5XWMPJUg2G9ok1zDLpwuxAFPXAfjKNyriGw/pRWgvc8dId15LfRc8CNooqiimNDcO2UXVJdcOZpaBNMuz9aQYsWmG7fgD37ad3m5k3GC6HqJlHK4YZE2YCjPN9wIhuSO4xJTac8XGaT+Hr8jAgMBAAECggEAbA7ofZ2z3IEeyN3uwCrj8PXm/uv/5iMKNK8UQ2eaZv/r2x8hewSD+Ro0YbqOE/Rbr3M4uCGRT3n4+2pGwXZ/YFm+U6maB1+erZDaJxWXrtbzME5VZ8eCeHktXpvQECDBzDszb249LeYM+ob9eeoBejsuxFjIgz7LsLe5mPCLgfzXkuPyPeyh2S3PHn+xWLkkOlPwhY+OONSOvcUmxRzUUAqCpLHfighRXW3hJfUDvrSr/+Mv+rTeI/3q3qirhknu2NdDVn8H2Ho5LGKGYo3hqsX1qlUcgnD3xOGg2xpDpBfq4deq+hyQuR4Yt/JuTH47CF/r4UUl/O7pqThLoaoG4QKBgQC9VgjYYcsL3MZ12FHOFwIct9zhwkoJY15+vsxiXXRiUeOAWG5/U8ttvnQ7CTSzb2xJxGTgG/sELLSiMvZPhpImjUgOMRVYjUTsPjJALzFrBY+6f9lR+DoUs5HeJfQ32zu9hEVc0Z1+3AlhdvOVdJmqCGz2VV6H1/IBS0qqsmeF/wKBgQCuy4T8tQcSC+Q2bxmK4Aa2VVgSi5BNG9zpamJ3SJqgIgDd0VcwY2xvH2tEp/ZS8CXBF0pCoL+ML6+90GH5f4bw/omfoTYriNYkenxISrIwP1jk+aAFCagqOMP2EoraPhI+sCvB++WhMU85WKxFTBdPJjPRsZPo9yexRSKktdPu3QKBgQCo+Lc8JUqIc6fKVBvtySrhZlWCRVq9tikHBFBzGORdOqfGSyWSDL5oWqhwZ27ZFH+X9eXw/AexWhR7DPA1WOvl7AB6aeOa+7ie/YLrNTLtSDFVR/Qy600qXHe5wjWKA+X05K7if1AHf2f/y6DnqP/ad1qHHPkYUuhvrzobzMwHEQKBgHHKPADnOHsfEqn9GXu266e3V2Z7RK1t/hpWD1PoCAFHIZlFtqThlK2inopLbagAfhN9vfIyA4CXaqj/B0kNJCOvEJjCsikVI5MLyeyl8+pE0vH9L5cX+knCOo/u8kWxMt9sgJAAFDUjjJegikVyi5oTHJjeKZP3kfdtMmhXlmhhAoGAcO9cWX01MCNUn0FDtK6SRRQKw+NMCT+rIqhS5DS4jcJUHEdQ/j1m2qHqj0r/nzjXXChJXvnTub1rNVA4JlaQK+9RNKwl6+RNBuvKWSRWFEz658HXcPHP2ZAwNBcBYGXXLrEp4JBmkajT+x3BxaXlHAZtO53P/5xJJwBdNSGYefQ=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);//沙箱支付
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onAliPay(View view) {
        boolean rsa2 = (KEY_RSA2_PRIVATE.length() > 0);
        Map<String, String> params = OrderInfoALiPayUtil.buildOrderParamMap(KEY_APPID, rsa2);
        String orderParam = OrderInfoALiPayUtil.buildOrderParam(params);

        String sign = OrderInfoALiPayUtil.getSign(params, KEY_RSA2_PRIVATE, rsa2);
        orderInfo = orderParam + "&" + sign;
        alipay(orderInfo);
    }

    private void alipay(final String orderInfo) {
        new PayManager(this, PayType.ALIPAY).pay(orderInfo, new PayCallback() {
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
        });
    }
}
