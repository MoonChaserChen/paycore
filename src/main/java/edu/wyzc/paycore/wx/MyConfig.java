package edu.wyzc.paycore.wx;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.*;

/**
 * Created by Allen on 2018/6/13.
 */
public class MyConfig implements WXPayConfig {

    private byte[] certData;

    public MyConfig() throws IOException {
        /*String certPath = "/path/to/apiclient_cert.p12";
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.readFromXml(this.certData);
        certStream.close();*/
        certData = null;
    }

    public String getAppID() {
        return "wx3b6fc3be742ef3f2";
    }

    public String getMchID() {
        return "1500332452";
    }

    public String getKey() {
        return "YtXBmnuScZlIXkBvjRLFDbZHCX649n8D";
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }
}