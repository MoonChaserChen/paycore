package me.chin.paycore.wx.request;

import me.chin.paycore.wx.ApiFieldHandler;
import me.chin.paycore.wx.model.WxApiRequestModel;
import me.chin.paycore.wx.response.WxApiResponse;

/**
 * Created by Allen on 2018/6/13.
 */
public interface WxApiRequest<T extends WxApiResponse> extends ApiFieldHandler {
    Class<T> getResponseClass();
    String getRequestUrl();
    void setRequestUrl(String requestUrl);
    WxApiRequestModel getRequestModel();
    void setRequestModel(WxApiRequestModel model);
}
