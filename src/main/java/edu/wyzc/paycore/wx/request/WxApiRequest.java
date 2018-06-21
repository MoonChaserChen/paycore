package edu.wyzc.paycore.wx.request;

import edu.wyzc.paycore.wx.ApiFieldHandler;
import edu.wyzc.paycore.wx.model.WxApiRequestModel;
import edu.wyzc.paycore.wx.response.WxApiResponse;

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
