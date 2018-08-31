package me.chin.paycore.wx.utils;

import com.google.common.base.Preconditions;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by Allen on 2018/6/21.
 */
public class WxProxyPost extends AbstractWxPost {
    private static IWxPost singleton;

    private String proxyHost;
    private int proxyPort;

    private WxProxyPost(String proxyHost, int proxyPort) {
        Preconditions.checkNotNull(proxyHost, "proxyHost can not be null for WxProxyPost,You may want to use WxPost instead");
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
    }

    public static IWxPost getSingleton(String proxyHost, int proxyPort) {
        if (singleton == null) {
            singleton = new WxProxyPost(proxyHost, proxyPort);
        }
        return singleton;
    }



    @Override
    public String doPost(String url, byte[] requestContent, String charset, int connectTimeout, int readTimeout) throws IOException {
        HttpURLConnection conn = null;
        try {
            conn = getConnection(url, charset, this.proxyHost, this.proxyPort);
            conn.setConnectTimeout(connectTimeout);
            conn.setReadTimeout(readTimeout);
            return getResponse(conn, requestContent);
        } finally {
            if (null != conn) {
                conn.disconnect();
            }
        }
    }
}
