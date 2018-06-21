package edu.wyzc.paycore.wx.client;

import edu.wyzc.paycore.wx.exceptions.RequestErrorException;
import edu.wyzc.paycore.wx.request.WxRequest;
import edu.wyzc.paycore.wx.response.WxResponse;

import java.io.IOException;

/**
 * Created by Allen on 2018/6/13.
 */
public interface WxClient {
    <T extends WxResponse> T execute(WxRequest<T> request) throws IOException, RequestErrorException;
    String getSignedRequestParamsAsXml(WxRequest request);
}
