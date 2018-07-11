package edu.wyzc.paycore.wx.enums;

/**
 * Created by Allen on 2018/6/14.
 */
public enum TradeType {
    MWEB("MWEB","H5","H5支付"),
    APP("APP","APP","APP支付"),
    NATIVE("NATIVE","PC","PC扫码支付");
    private String wxType;
    private String ourPayWay;
    private String desc;

    public String getWxType() {
        return wxType;
    }

    public String getOurPayWay() {
        return ourPayWay;
    }

    public String getDesc() {
        return desc;
    }

    TradeType(String wxType, String ourPayWay, String desc) {
        this.wxType = wxType;
        this.ourPayWay = ourPayWay;
        this.desc = desc;
    }

    public static TradeType getByOurPayWay(String ourPayWay) {
        for (TradeType tradeType : TradeType.values()) {
            if (tradeType.getOurPayWay().equals(ourPayWay)) {
                return tradeType;
            }
        }
        return null;
    }
}
