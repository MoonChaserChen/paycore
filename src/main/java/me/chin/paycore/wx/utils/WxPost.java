package me.chin.paycore.wx.utils;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by Allen on 2018/6/21.
 */
public class WxPost extends AbstractWxPost {

    private static IWxPost wxPost;

    private WxPost() {
    }

    public static IWxPost getSingleton() {
        if (wxPost == null) {
            wxPost = new WxPost();
        }
        return wxPost;
    }

    @Override
    public String doPost(String url, byte[] requestContent, String charset, int connectTimeout, int readTimeout) throws IOException {
        HttpURLConnection conn = null;
        try {
            conn = getConnection(url, charset, null, 0);
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