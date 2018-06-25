package edu.wyzc.paycore.wx.model;

import edu.wyzc.paycore.wx.mapping.ApiField;

import java.util.Date;

/**
 * Created by Allen on 2018/6/25.
 */
public class WxApiPayNotifyModel {
    // TODO 代金券ID	coupon_id_$n,单个代金券支付金额	coupon_fee_$n解析较为麻烦，这里暂省略不解析
    @ApiField(value="return_code")
    private String returnCode;
    @ApiField(value="return_msg")
    private String returnMsg;
    @ApiField(value="appid")
    private String appid;
    @ApiField(value="mch_id")
    private String mchId;
    @ApiField(value="device_info")
    private String deviceInfo;
    @ApiField(value="nonce_str")
    private String nonceStr;
    @ApiField(value="sign")
    private String sign;
    @ApiField(value="result_code")
    private String resultCode;
    @ApiField(value="err_code")
    private String errCode;
    @ApiField(value="err_code_des")
    private String errCodeDes;
    @ApiField(value="openid")
    private String openid;
    @ApiField(value="is_subscribe")
    private String isSubscribe;
    @ApiField(value="trade_type")
    private String tradeType;
    @ApiField(value="bank_type")
    private String bankType;
    @ApiField(value="total_fee")
    private Integer totalFee;
    @ApiField(value="fee_type")
    private String feeType;
    @ApiField(value="cash_fee")
    private Integer cashFee;
    @ApiField(value="cash_fee_type")
    private String cashFeeType;
    @ApiField(value="coupon_fee")
    private Integer couponFee;
    @ApiField(value="coupon_count")
    private Integer couponCount;
    @ApiField(value="transaction_id")
    private String transactionId;
    @ApiField(value="out_trade_no")
    private String outTradeNo;
    @ApiField(value="attach")
    private String attach;
    @ApiField(value="time_end")
    private Date timeEnd;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public Integer getCashFee() {
        return cashFee;
    }

    public void setCashFee(Integer cashFee) {
        this.cashFee = cashFee;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public void setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
    }

    public Integer getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(Integer couponFee) {
        this.couponFee = couponFee;
    }

    public Integer getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(Integer couponCount) {
        this.couponCount = couponCount;
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

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }
}
