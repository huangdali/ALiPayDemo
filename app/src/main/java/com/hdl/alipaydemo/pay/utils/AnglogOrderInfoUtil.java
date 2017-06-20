package com.hdl.alipaydemo.pay.utils;

import com.hdl.alipaydemo.pay.bean.WXPayOrderInfo;
import com.hdl.alipaydemo.pay.global.Constants;

import java.util.Map;

/**
 * 模拟订单消息工具，实际开发中不需要使用此类
 * Created by HDL on 2017/6/20.
 */

public class AnglogOrderInfoUtil {
    /**
     * 【正式环境需删除】实际开发中不会用到该字段，由服务器来完成相应的编码工作
     */
    private static final String KEY_APPID = Constants.KEY_ALIPAY_APPID;
    /**
     * 【正式环境需删除】实际开发中不会用到该字段，由服务器来完成相应的编码工作
     */
    private static final String KEY_RSA2_PRIVATE = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCBRv+XWTDkc4AcsnDvFy4Fd4qOV5b0oTWqirTFwIu98zCidKpgq6ve3hkRIu+skOf1wEuSlQbnD2yAGW68X++oL4x3JgeE5Vp6vFlQi/eSTaj2TjNcAtCAScCXrh5gMqEoFRWHI6Gx11Zrk+rYA2r/5BPP9P5uD5W/OeckN+AVlDAk5dgWuNfIBvYi40MYnl9bwWOb5XWMPJUg2G9ok1zDLpwuxAFPXAfjKNyriGw/pRWgvc8dId15LfRc8CNooqiimNDcO2UXVJdcOZpaBNMuz9aQYsWmG7fgD37ad3m5k3GC6HqJlHK4YZE2YCjPN9wIhuSO4xJTac8XGaT+Hr8jAgMBAAECggEAbA7ofZ2z3IEeyN3uwCrj8PXm/uv/5iMKNK8UQ2eaZv/r2x8hewSD+Ro0YbqOE/Rbr3M4uCGRT3n4+2pGwXZ/YFm+U6maB1+erZDaJxWXrtbzME5VZ8eCeHktXpvQECDBzDszb249LeYM+ob9eeoBejsuxFjIgz7LsLe5mPCLgfzXkuPyPeyh2S3PHn+xWLkkOlPwhY+OONSOvcUmxRzUUAqCpLHfighRXW3hJfUDvrSr/+Mv+rTeI/3q3qirhknu2NdDVn8H2Ho5LGKGYo3hqsX1qlUcgnD3xOGg2xpDpBfq4deq+hyQuR4Yt/JuTH47CF/r4UUl/O7pqThLoaoG4QKBgQC9VgjYYcsL3MZ12FHOFwIct9zhwkoJY15+vsxiXXRiUeOAWG5/U8ttvnQ7CTSzb2xJxGTgG/sELLSiMvZPhpImjUgOMRVYjUTsPjJALzFrBY+6f9lR+DoUs5HeJfQ32zu9hEVc0Z1+3AlhdvOVdJmqCGz2VV6H1/IBS0qqsmeF/wKBgQCuy4T8tQcSC+Q2bxmK4Aa2VVgSi5BNG9zpamJ3SJqgIgDd0VcwY2xvH2tEp/ZS8CXBF0pCoL+ML6+90GH5f4bw/omfoTYriNYkenxISrIwP1jk+aAFCagqOMP2EoraPhI+sCvB++WhMU85WKxFTBdPJjPRsZPo9yexRSKktdPu3QKBgQCo+Lc8JUqIc6fKVBvtySrhZlWCRVq9tikHBFBzGORdOqfGSyWSDL5oWqhwZ27ZFH+X9eXw/AexWhR7DPA1WOvl7AB6aeOa+7ie/YLrNTLtSDFVR/Qy600qXHe5wjWKA+X05K7if1AHf2f/y6DnqP/ad1qHHPkYUuhvrzobzMwHEQKBgHHKPADnOHsfEqn9GXu266e3V2Z7RK1t/hpWD1PoCAFHIZlFtqThlK2inopLbagAfhN9vfIyA4CXaqj/B0kNJCOvEJjCsikVI5MLyeyl8+pE0vH9L5cX+knCOo/u8kWxMt9sgJAAFDUjjJegikVyi5oTHJjeKZP3kfdtMmhXlmhhAoGAcO9cWX01MCNUn0FDtK6SRRQKw+NMCT+rIqhS5DS4jcJUHEdQ/j1m2qHqj0r/nzjXXChJXvnTub1rNVA4JlaQK+9RNKwl6+RNBuvKWSRWFEz658HXcPHP2ZAwNBcBYGXXLrEp4JBmkajT+x3BxaXlHAZtO53P/5xJJwBdNSGYefQ=";

    /**
     * 模拟产生微信订单信息，实际开发需要从服务器获取
     *
     * @return
     */
    public static WXPayOrderInfo getWxPayOrderInfo() {
        WXPayOrderInfo wxPayOrderInfo = new WXPayOrderInfo();
        wxPayOrderInfo.setAppId(Constants.KEY_WX_APPID);
        wxPayOrderInfo.setExtData("k=v");
        wxPayOrderInfo.setNonceStr("lasjdglasjgljaoeuwohjflsdg");
        wxPayOrderInfo.setPackageValue("Sign=WXPay");
        wxPayOrderInfo.setPartnerId("1900000109");
        wxPayOrderInfo.setPrepayId("WX1217752501201407033233368018");
        wxPayOrderInfo.setSign("C380BEC2BFD727A4B6845133519F3AD6");
        wxPayOrderInfo.setTimeStamp("1412000000");
        return wxPayOrderInfo;
    }

    /**
     * 模拟获取支付宝订单信息，正式环境需要从服务器获取
     *
     * @return
     */
    public static String getAliPayOrderInfo() {
        boolean rsa2 = (KEY_RSA2_PRIVATE.length() > 0);
        Map<String, String> params = OrderInfoALiPayUtil.buildOrderParamMap(KEY_APPID, rsa2);
        String orderParam = OrderInfoALiPayUtil.buildOrderParam(params);
        String sign = OrderInfoALiPayUtil.getSign(params, KEY_RSA2_PRIVATE, rsa2);
        return orderParam + "&" + sign;
    }
}
