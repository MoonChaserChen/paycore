package me.chin.paycore.wx.utils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Allen on 2018/6/21.
 */
public interface IWxPost {
    String doPost(String url, byte[] requestContent, String charset, int connectTimeout, int readTimeout) throws IOException;

    String doPost(String url, Map<String, String> paramMap, String charset, int connectTimeout, int readTimeout) throws IOException;
}
