package edu.wyzc.paycore.wx.request;

import edu.wyzc.paycore.wx.ApiFieldHandler;
import edu.wyzc.paycore.wx.model.WxRequestModel;
import edu.wyzc.paycore.wx.response.WxResponse;

/**
 * Created by Allen on 2018/6/13.
 */
public interface WxRequest<T extends WxResponse> extends ApiFieldHandler {
    Class<T> getResponseClass();
    String getRequestUrl();
    void setRequestUrl(String requestUrl);
    WxRequestModel getRequestModel();
    void setRequestModel(WxRequestModel model);
}
