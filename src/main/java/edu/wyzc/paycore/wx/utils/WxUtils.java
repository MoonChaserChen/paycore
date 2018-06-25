package edu.wyzc.paycore.wx.utils;

import edu.wyzc.paycore.wx.ApiFieldReader;
import edu.wyzc.paycore.wx.model.WxApiPayNotifyModel;

/**
 * Created by Allen on 2018/6/25.
 */
public class WxUtils {
    public static WxApiPayNotifyModel getPayNotifyModel(String notifyXmlStr) {
        return ApiFieldReader.readFromXml(WxApiPayNotifyModel.class, notifyXmlStr);
    }
}
