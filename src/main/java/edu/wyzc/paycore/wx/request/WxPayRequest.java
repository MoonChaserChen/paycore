package edu.wyzc.paycore.wx.request;

import edu.wyzc.paycore.wx.ApiFieldWriter;
import edu.wyzc.paycore.wx.constants.WxPayConstants;
import edu.wyzc.paycore.wx.exceptions.InvalidWxRequestException;
import edu.wyzc.paycore.wx.model.WxRequestModel;
import edu.wyzc.paycore.wx.response.WxPayResponse;

import java.util.Map;

/**
 * Created by Allen on 2018/6/14.
 */
public class WxPayRequest implements WxRequest<WxPayResponse> {
    private WxRequestModel wxRequestModel;
    private String requestUrl;

    public WxPayRequest(WxRequestModel wxRequestModel) throws InvalidWxRequestException {
        requestUrl = WxPayConstants.URL_PAY_REQUEST;
        if (wxRequestModel == null) {
            throw new InvalidWxRequestException("Invalid wx request exception, wxRequestModel can't be null");
        }
        this.wxRequestModel = wxRequestModel;
    }

    @Override
    public Class<WxPayResponse> getResponseClass() {
        return WxPayResponse.class;
    }

    @Override
    public String getRequestUrl() {
        return requestUrl;
    }

    @Override
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    @Override
    public WxRequestModel getRequestModel() {
        return this.wxRequestModel;
    }

    @Override
    public void setRequestModel(WxRequestModel model) {
        this.wxRequestModel = model;
    }

    @Override
    public Map<String, String> getApiFieldsAsMap() {
        return ApiFieldWriter.write(this.wxRequestModel);
    }
}
