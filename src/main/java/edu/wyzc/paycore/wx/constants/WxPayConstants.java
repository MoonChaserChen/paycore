package edu.wyzc.paycore.wx.constants;

/**
 * Created by Allen on 2018/6/13.
 */
public class WxPayConstants {
    public static final String FIELD_SIGN = "sign";
    public static final String FIELD_SIGN_TYPE = "signType";
    public static final String DEFAULT_CHARSET = "UTF-8";

    public static final String COMMON_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String WX_DATE_FORMAT = "yyyyMMddHHmmss";
    public static final String DATE_TIMEZONE = "GMT+8";

    public static final String XML_TAG = "xml";

    public static final String URL_PAY_REQUEST = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    public static final String URL_PAY_ORDER_QUERY = "https://api.mch.weixin.qq.com/pay/orderquery";


    public static final String NOTIFY_RETURN_CODE = "return_code";
    public static final String NOTIFY_RETURN_MSG = "return_msg";
    public static final String NOTIFY_RETURN_CODE_SUCCESS = "SUCCESS";
    public static final String NOTIFY_RETURN_CODE_FAIL = "FAIL";
}
