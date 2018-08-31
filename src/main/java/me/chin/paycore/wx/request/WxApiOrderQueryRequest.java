package me.chin.paycore.wx.request;

import me.chin.paycore.wx.ApiFieldWriter;
import me.chin.paycore.wx.constants.WxPayConstants;
import me.chin.paycore.wx.exceptions.InvalidWxRequestException;
import me.chin.paycore.wx.model.WxApiOrderQueryModel;
import me.chin.paycore.wx.model.WxApiRequestModel;
import me.chin.paycore.wx.response.WxApiOrderQueryResponse;

import java.util.Map;

/**
 * Created by Allen on 2018/6/25.
 */
public class WxApiOrderQueryRequest implements WxApiRequest<WxApiOrderQueryResponse> {
    private WxApiRequestModel model;
    private String requestUrl;

    public WxApiOrderQueryRequest(WxApiOrderQueryModel model) {
        this.requestUrl = WxPayConstants.URL_PAY_ORDER_QUERY;
        if (model == null) {
            throw new InvalidWxRequestException("Invalid wx request exception, wxRequestModel can't be null");
        }
        this.model = model;
    }

    @Override
    public Map<String, String> getApiFieldsAsMap() {
        return ApiFieldWriter.write(this.model);
    }

    @Override
    public Class<WxApiOrderQueryResponse> getResponseClass() {
        return WxApiOrderQueryResponse.class;
    }

    @Override
    public String getRequestUrl() {
        return this.requestUrl;
    }

    @Override
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    @Override
    public WxApiRequestModel getRequestModel() {
        return this.model;
    }

    @Override
    public void setRequestModel(WxApiRequestModel model) {
        this.model = model;
    }
}
