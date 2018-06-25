package edu.wyzc.paycore.wx.model;

import edu.wyzc.paycore.wx.mapping.ApiField;

import java.util.UUID;

/**
 * Created by Allen on 2018/6/25.
 */
public class WxApiOrderQueryModel extends WxApiRequestModel {
    @ApiField("transaction_id")
    private String transactionId;
    @ApiField("out_trade_no")
    private String outTradeNo;
    @ApiField("nonce_str")
    private String nonceStr;


    public WxApiOrderQueryModel(String outTradeNo) {
        this.nonceStr = UUID.randomUUID().toString().replace("-","");
        this.outTradeNo = outTradeNo;
    }

    public WxApiOrderQueryModel(String transactionId, String outTradeNo) {
        this(outTradeNo);
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }
}
