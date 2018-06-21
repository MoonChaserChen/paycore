package edu.wyzc.paycore.wx.utils;

import edu.wyzc.util.utils.TransferUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;

/**
 * Created by Allen on 2018/6/21.
 */
public abstract class AbstractWxPost implements IWxPost {
    public static final String HTTP_METHOD_POST = "POST";

    protected HttpURLConnection getConnection(String url, String charset, Proxy proxy) throws IOException {
        HttpURLConnection conn;
        if (proxy != null) {
            conn = (HttpsURLConnection) new URL(url).openConnection(proxy);
        } else {
            conn = (HttpsURLConnection) new URL(url).openConnection();
        }
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Accept", "text/xml,text/javascript,text/html");
        conn.setRequestProperty("User-Agent", "aop-sdk-java");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
        conn.setRequestMethod(HTTP_METHOD_POST);
        return conn;
    }

    protected HttpURLConnection getConnection(String url, String charset, String proxyHost, int proxyPort) throws IOException {
        Proxy proxy = null;
        if (StringUtils.isNotBlank(proxyHost)) {
            proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        }
        return getConnection(url, charset, proxy);
    }

    protected String getResponse(HttpURLConnection conn, byte[] requestContent) throws IOException {
        try (OutputStream outputStream = conn.getOutputStream()) {
            outputStream.write(requestContent);
        }
        try (InputStream errorStream = conn.getErrorStream()) {
            if (null != errorStream) {
                throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());
            }
        }
        try (InputStream inputStream = conn.getInputStream()) {
            return IOUtils.toString(inputStream);
        }
    }

    public String doPost(String url, Map<String, String> paramMap, String charset, int connectTimeout, int readTimeout) throws IOException {
        String orderedString = TransferUtils.map2OrderedString(paramMap);
        return doPost(url, orderedString.getBytes(), charset, connectTimeout, readTimeout);
    }


}
