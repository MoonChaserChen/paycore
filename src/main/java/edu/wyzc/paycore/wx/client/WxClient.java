package edu.wyzc.paycore.wx.client;

import edu.wyzc.paycore.wx.exceptions.RequestErrorException;
import edu.wyzc.paycore.wx.request.WxApiRequest;
import edu.wyzc.paycore.wx.response.WxApiResponse;

import java.io.IOException;

/**
 * Created by Allen on 2018/6/13.
 */
public interface WxClient {
    <T extends WxApiResponse> T execute(WxApiRequest<T> request) throws IOException, RequestErrorException;
    String getSignedRequestParamsAsXml(WxApiRequest request);
}
