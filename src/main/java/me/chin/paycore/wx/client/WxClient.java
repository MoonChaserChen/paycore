package me.chin.paycore.wx.client;

import me.chin.paycore.wx.exceptions.RequestErrorException;
import me.chin.paycore.wx.request.WxApiRequest;
import me.chin.paycore.wx.response.WxApiResponse;


/**
 * Created by Allen on 2018/6/13.
 */
public interface WxClient {
    <T extends WxApiResponse> T execute(WxApiRequest<T> request) throws RequestErrorException;
    String getSignedRequestParamsAsXml(WxApiRequest request);
}
