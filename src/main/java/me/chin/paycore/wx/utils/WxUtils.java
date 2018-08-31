package me.chin.paycore.wx.utils;

import me.chin.paycore.wx.ApiFieldReader;
import me.chin.paycore.wx.model.WxApiPayNotifyModel;

/**
 * Created by Allen on 2018/6/25.
 */
public class WxUtils {
    public static WxApiPayNotifyModel getPayNotifyModel(String notifyXmlStr) {
        return ApiFieldReader.readFromXml(WxApiPayNotifyModel.class, notifyXmlStr);
    }
}
