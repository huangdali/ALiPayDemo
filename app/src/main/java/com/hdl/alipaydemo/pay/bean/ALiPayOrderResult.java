package com.hdl.alipaydemo.pay.bean;

/**
 * 支付宝支付订单结果
 * Created by HDL on 2017/6/20.
 */

public class ALiPayOrderResult {

    /**
     * alipay_trade_app_pay_response : {"code":"10000","msg":"Success","app_id":"2016080400163745","auth_app_id":"2016080400163745","charset":"utf-8","timestamp":"2017-06-20 08:46:28","total_amount":"0.01","trade_no":"2017062021001004490200145540","seller_id":"2088102169884193","out_trade_no":"0620084558-6305"}
     * sign : SsvTF6XTUkHq4lYvmSUV1SVGD9bvDhz+Mh+0OTpzGyGXq9WFK257i2sOw0C7O2lA+0JF4P3AqVuI5/58WBBTfp3aTfAMFjXM+bsxINkSwluQlyfjSWZ0QFE6efEnuxHRnmm+QBsCTek6VW1duW1l6SfYS6dXaWZ3AQOXmObT4ZbsJmu6Psb5mSB3UTWVfOswqonYumPMZK6Igy1gNFuDn+cIedEJnFKVLJSARmDLnRby52/wkpK/AHB2Oc+ulDH+ulRtMfHsXUFN/sB2EX2RjTaf1z/tbWZOHfEGBsJ/paIYaE/cZb3WI591Skg0GTFGA0HpVQsby6lolHiX0QaNow==
     * sign_type : RSA2
     */

    private AlipayTradeAppPayResponseBean alipay_trade_app_pay_response;
    private String sign;//签名
    private String sign_type;//签名类型

    public AlipayTradeAppPayResponseBean getAlipay_trade_app_pay_response() {
        return alipay_trade_app_pay_response;
    }

    public void setAlipay_trade_app_pay_response(AlipayTradeAppPayResponseBean alipay_trade_app_pay_response) {
        this.alipay_trade_app_pay_response = alipay_trade_app_pay_response;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public static class AlipayTradeAppPayResponseBean {
        /**
         * code : 10000
         * msg : Success
         * app_id : 2016080400163745
         * auth_app_id : 2016080400163745
         * charset : utf-8
         * timestamp : 2017-06-20 08:46:28
         * total_amount : 0.01
         * trade_no : 2017062021001004490200145540
         * seller_id : 2088102169884193
         * out_trade_no : 0620084558-6305
         */

        private String code;//支付的结果码
        private String msg;//提示信息
        private String app_id;//支付宝分配给开发者的应用ID
        private String auth_app_id;
        private String charset;
        private String timestamp;//发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"
        private String total_amount;//订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
        private String trade_no;//支付宝订单号
        private String seller_id;//收款支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
        private String out_trade_no;//商铺唯一订单号

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getAuth_app_id() {
            return auth_app_id;
        }

        public void setAuth_app_id(String auth_app_id) {
            this.auth_app_id = auth_app_id;
        }

        public String getCharset() {
            return charset;
        }

        public void setCharset(String charset) {
            this.charset = charset;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(String total_amount) {
            this.total_amount = total_amount;
        }

        public String getTrade_no() {
            return trade_no;
        }

        public void setTrade_no(String trade_no) {
            this.trade_no = trade_no;
        }

        public String getSeller_id() {
            return seller_id;
        }

        public void setSeller_id(String seller_id) {
            this.seller_id = seller_id;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        @Override
        public String toString() {
            return "AlipayTradeAppPayResponseBean{" +
                    "code='" + code + '\'' +
                    ", msg='" + msg + '\'' +
                    ", app_id='" + app_id + '\'' +
                    ", auth_app_id='" + auth_app_id + '\'' +
                    ", charset='" + charset + '\'' +
                    ", timestamp='" + timestamp + '\'' +
                    ", total_amount='" + total_amount + '\'' +
                    ", trade_no='" + trade_no + '\'' +
                    ", seller_id='" + seller_id + '\'' +
                    ", out_trade_no='" + out_trade_no + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ALiPayOrderResult{" +
                "alipay_trade_app_pay_response=" + alipay_trade_app_pay_response +
                ", sign='" + sign + '\'' +
                ", sign_type='" + sign_type + '\'' +
                '}';
    }
}
