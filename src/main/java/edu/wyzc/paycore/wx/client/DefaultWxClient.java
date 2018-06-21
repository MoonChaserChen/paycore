package edu.wyzc.paycore.wx.client;

import edu.wyzc.paycore.wx.ApiFieldHandler;
import edu.wyzc.paycore.wx.ApiFieldReader;
import edu.wyzc.paycore.wx.ApiFieldWriter;
import edu.wyzc.paycore.wx.constants.WxPayConstants;
import edu.wyzc.paycore.wx.enums.SignType;
import edu.wyzc.paycore.wx.exceptions.RequestErrorException;
import edu.wyzc.paycore.wx.mapping.ApiField;
import edu.wyzc.paycore.wx.request.WxApiRequest;
import edu.wyzc.paycore.wx.response.WxApiResponse;
import edu.wyzc.paycore.wx.utils.IWxPost;
import edu.wyzc.paycore.wx.utils.WxPaySignUtils;
import edu.wyzc.paycore.wx.utils.WxPost;
import edu.wyzc.paycore.wx.utils.WxProxyPost;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Allen on 2018/6/13.
 */
public class DefaultWxClient implements WxClient, ApiFieldHandler{

    protected static final Logger logger = LoggerFactory.getLogger(DefaultWxClient.class);

    @ApiField("mch_id")
    private String mchId;
    @ApiField("appid")
    private String appId;
    @ApiField("sign_type")
    private SignType signType;

    private String appKey;
    private byte[] certData;
    private String charset = WxPayConstants.DEFAULT_CHARSET;

    private int connectTimeout = 3000;
    private int readTimeout = 15000;

    private String proxyHost;
    private int proxyPort;

    public DefaultWxClient(String mchId, String appId, String appKey, byte[] certData, SignType signType, String proxyHost, int proxyPort) {
        this.mchId = mchId;
        this.appId = appId;
        this.appKey = appKey;
        this.certData = certData;
        this.signType = signType;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
    }

    public DefaultWxClient(String mchId, String appId, String appKey, String certDataPath, SignType signType, String proxyHost, int proxyPort) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(certDataPath)) {
            this.mchId = mchId;
            this.appId = appId;
            this.appKey = appKey;
            this.certData = IOUtils.toByteArray(fileInputStream);
            this.signType = signType;
            this.proxyHost = proxyHost;
            this.proxyPort = proxyPort;
        }
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public byte[] getCertData() {
        return certData;
    }

    public void setCertData(byte[] certData) {
        this.certData = certData;
    }

    public SignType getSignType() {
        return signType;
    }

    public void setSignType(SignType signType) {
        this.signType = signType;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    @Override
    public <T extends WxApiResponse> T execute(WxApiRequest<T> request) throws IOException, RequestErrorException {
        String result = getWxPost().doPost(request.getRequestUrl(), getSignedRequestParamsAsXml(request).getBytes(), this.charset, this.connectTimeout, this.readTimeout);
        // TODO handle fault response here
        if (!WxPaySignUtils.isMD5SignatureValid(result, this.appKey)) {
            logger.error("===== get invalid info after requesting pay, system may be under attack! response:{}", result);
            throw new RequestErrorException("get invalid info after requesting pay, system may be under attack!");
        }
        return ApiFieldReader.readFromXml(request.getResponseClass(),result);
    }

    @Override
    public String getSignedRequestParamsAsXml(WxApiRequest request) {
        Map<String, String> requestParam = request.getApiFieldsAsMap();
        requestParam.putAll(getApiFieldsAsMap());
        return WxPaySignUtils.generateSignedXml(requestParam, appKey, signType);
    }

    @Override
    public Map<String, String> getApiFieldsAsMap() {
        return ApiFieldWriter.write(this);
    }

    private IWxPost getWxPost(){
        return StringUtils.isBlank(this.proxyHost) ? WxPost.getSingleton() : WxProxyPost.getSingleton(this.proxyHost, this.proxyPort);
    }
}
