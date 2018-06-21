package edu.wyzc.paycore.wx.model;

import edu.wyzc.paycore.wx.enums.SignType;
import edu.wyzc.paycore.wx.enums.TradeType;
import edu.wyzc.paycore.wx.mapping.ApiField;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Allen on 2018/6/14.
 */
public class WxApiPayRequestModel extends WxApiRequestModel {
    @ApiField("device_info")
    private String deviceInfo;
    @ApiField("nonce_str")
    private String nonceStr;
    @ApiField("sign_type")
    private SignType signType;
    @ApiField("body")
    private String body;
    @ApiField("detail")
    private String detail;
    @ApiField("attach")
    private String attach;
    @ApiField("out_trade_no")
    private String outTradeNo;
    @ApiField("fee_type")
    private String feeType;
    @ApiField("total_fee")
    private long totalFeeFen;
    @ApiField("spbill_create_ip")
    private String spbillCreateIp;
    @ApiField("time_start")
    private Date timeStart;
    @ApiField("time_expire")
    private Date timeExpire;
    @ApiField("goods_tag")
    private String goodsTag;
    @ApiField("notify_url")
    private String notifyUrl;
    @ApiField("trade_type")
    private TradeType tradeType;
    @ApiField("product_id")
    private String productId;
    @ApiField("limit_pay")
    private String limitPay;
    @ApiField("openid")
    private String openId;
    @ApiField("scene_info")
    private String sceneInfo;

    public WxApiPayRequestModel(String body, String outTradeNo, long totalFeeFen, String spbillCreateIp, Date timeStart, Date timeExpire, String notifyUrl, TradeType tradeType) {
        nonceStr = UUID.randomUUID().toString().replace("-","");
        this.body = body;
        this.outTradeNo = outTradeNo;
        this.totalFeeFen = totalFeeFen;
        this.spbillCreateIp = spbillCreateIp;
        this.timeStart = timeStart;
        this.timeExpire = timeExpire;
        this.notifyUrl = notifyUrl;
        this.tradeType = tradeType;
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

    public SignType getSignType() {
        return signType;
    }

    public void setSignType(SignType signType) {
        this.signType = signType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public long getTotalFeeFen() {
        return totalFeeFen;
    }

    public void setTotalFeeFen(long totalFeeFen) {
        this.totalFeeFen = totalFeeFen;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(Date timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public TradeType getTradeType() {
        return tradeType;
    }

    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(String sceneInfo) {
        this.sceneInfo = sceneInfo;
    }
}
