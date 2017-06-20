package com.hdl.alipaydemo.pay.bean;

/**
 * 微信支付的订单信息
 * Created by HDL on 2017/6/20.
 */

public class WXPayOrderInfo {
    private String appId;//应用ID
    private String partnerId;//商户号
    private String prepayId;//预支付交易会话ID
    private String nonceStr;//随机字符串
    private String timeStamp;//时间戳
    private String packageValue;//扩展字段,暂填写固定值Sign=WXPay
    private String sign;//签名
    private String extData;//扩展字段

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getExtData() {
        return extData;
    }

    public void setExtData(String extData) {
        this.extData = extData;
    }

    @Override
    public String toString() {
        return "WXPayOrderInfo{" +
                "appId='" + appId + '\'' +
                ", partnerId='" + partnerId + '\'' +
                ", prepayId='" + prepayId + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", packageValue='" + packageValue + '\'' +
                ", sign='" + sign + '\'' +
                ", extData='" + extData + '\'' +
                '}';
    }
}
