package edu.wyzc.paycore.wx.constants;

/**
 * Created by Allen on 2018/5/31.
 */
public class AlipayConstant {
    public static final String NOTIFY_SUCCESS = "success";
    public static final String NOTIFY_FAILED = "failed";

    public static final String API_CODE_SUCCESS = "10000";
    public static final String API_CODE_TRASACTION_OPERATION_FAILED = "40004";
    public static final String API_CODE_TRADE_NOT_EXIST = "ACQ.TRADE_NOT_EXIST";

    public static final String PRODUCT_CODE_PC = "FAST_INSTANT_TRADE_PAY";
    public static final String PRODUCT_CODE_APP = "QUICK_MSECURITY_PAY";
    public static final String PRODUCE_CODE_H5 = "QUICK_WAP_WAY";

    public static final String GOODS_TYPE_VIRTUAL = "0";
    public static final String GOODS_TYPE_REAL = "1";

    public static final String NOTIFY_OUT_TRADE_NO = "out_trade_no";
    public static final String NOTIFY_TOTAL_AMOUNT = "total_amount";
    public static final String NOTIFY_SELLER_ID = "seller_id";
    public static final String NOTIFY_APP_ID = "app_id";
    public static final String NOTIFY_TRADE_STATUS = "trade_status";
    // order create time by alipay
    public static final String NOTIFY_GMT_CREATE = "gmt_create";
    // order pay time
    public static final String NOTIFY_GMT_PAYMENT = "gmt_payment";
    public static final String NOTIFY_TIME = "notify_time";
    public static final String NOTIFY_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // the time when merchant received the money (regarded as "order pay time")
    public static final String QUERY_SEND_PAY_DATE = "send_pay_date";
}
