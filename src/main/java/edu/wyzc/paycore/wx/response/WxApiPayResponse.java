package edu.wyzc.paycore.wx.response;

import edu.wyzc.paycore.wx.enums.TradeType;
import edu.wyzc.paycore.wx.mapping.ApiField;

/**
 * Created by Allen on 2018/6/14.
 */
public class WxApiPayResponse extends WxApiResponse {
    @ApiField("return_code")
    private String returnCode;
    @ApiField("return_msg")
    private String returnMsg;
    @ApiField("appid")
    private String appid;
    @ApiField("mch_id")
    private String mchId;
    @ApiField("device_info")
    private String deviceInfo;
    @ApiField("nonce_str")
    private String nonceStr;
    @ApiField("sign")
    private String sign;
    @ApiField("result_code")
    private String resultCode;
    @ApiField("err_code")
    private String errCode;
    @ApiField("err_code_des")
    private String errCodeDes;
    @ApiField("trade_type")
    private String tradeType;
    @ApiField("prepay_id")
    private String prepayId;
    @ApiField("code_url")
    private String codeUrl;
    @ApiField("mweb_url")
    private String mwebUrl;

    public WxApiPayResponse() {
    }

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

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getMwebUrl() {
        return mwebUrl;
    }

    public void setMwebUrl(String mwebUrl) {
        this.mwebUrl = mwebUrl;
    }

    public String getPayRequestCoreInfo() {
        if (tradeType == null) {
            return null;
        }else if (tradeType.equalsIgnoreCase(TradeType.APP.toString())) {
            return this.prepayId;
        }else if (tradeType.equalsIgnoreCase(TradeType.MWEB.toString())) {
            return this.mwebUrl;
        }else if (tradeType.equalsIgnoreCase(TradeType.NATIVE.toString())) {
            return this.codeUrl;
        }
       return null;
    }
}
