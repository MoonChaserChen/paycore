package edu.wyzc.paycore.wx.request;

import edu.wyzc.paycore.wx.ApiFieldWriter;
import edu.wyzc.paycore.wx.constants.WxPayConstants;
import edu.wyzc.paycore.wx.exceptions.InvalidWxRequestException;
import edu.wyzc.paycore.wx.model.WxApiRequestModel;
import edu.wyzc.paycore.wx.response.WxApiPayResponse;

import java.util.Map;

/**
 * Created by Allen on 2018/6/14.
 */
public class WxApiPayRequest implements WxApiRequest<WxApiPayResponse> {
    private WxApiRequestModel wxRequestModel;
    private String requestUrl;

    public WxApiPayRequest(WxApiRequestModel wxRequestModel) throws InvalidWxRequestException {
        requestUrl = WxPayConstants.URL_PAY_REQUEST;
        if (wxRequestModel == null) {
            throw new InvalidWxRequestException("Invalid wx request exception, wxRequestModel can't be null");
        }
        this.wxRequestModel = wxRequestModel;
    }

    @Override
    public Class<WxApiPayResponse> getResponseClass() {
        return WxApiPayResponse.class;
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
    public WxApiRequestModel getRequestModel() {
        return this.wxRequestModel;
    }

    @Override
    public void setRequestModel(WxApiRequestModel model) {
        this.wxRequestModel = model;
    }

    @Override
    public Map<String, String> getApiFieldsAsMap() {
        return ApiFieldWriter.write(this.wxRequestModel);
    }
}
