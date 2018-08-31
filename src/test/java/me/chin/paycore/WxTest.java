package me.chin.paycore;

import me.chin.paycore.wx.client.DefaultWxClient;
import me.chin.paycore.wx.client.WxClient;
import me.chin.paycore.wx.enums.SignType;
import me.chin.paycore.wx.enums.TradeType;
import me.chin.paycore.wx.exceptions.RequestErrorException;
import me.chin.paycore.wx.model.WxApiOrderQueryModel;
import me.chin.paycore.wx.model.WxApiPayRequestModel;
import me.chin.paycore.wx.request.WxApiOrderQueryRequest;
import me.chin.paycore.wx.request.WxApiPayRequest;
import me.chin.paycore.wx.response.WxApiOrderQueryResponse;
import me.chin.paycore.wx.response.WxApiPayResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Allen on 2018/6/14.
 */
public class WxTest {
    private WxClient client;

    @Before
    public void before(){
        client = new DefaultWxClient("1500332452","wx3b6fc3be742ef3f2","YtXBmnuScZlIXkBvjRLFDbZHCX649n8D",new byte[0], SignType.MD5,null,0);
    }
    @Test
    public void testPayRequest() throws IOException, RequestErrorException {
        WxApiPayRequestModel model = new WxApiPayRequestModel("测试",String.valueOf(1234567893L),1L,
                "111.200.194.253",new Date(),new Date(new Date().getTime() + 1000 * 60 * 5),"http://1114df5c.ngrok.io/alipayPayNotify", TradeType.NATIVE);
        WxApiPayRequest request = new WxApiPayRequest(model);

        WxApiPayResponse execute = client.execute(request);
        String codeUrl = execute.getCodeUrl();
        System.out.println("codeUrl = " + codeUrl);
    }

    @Test
    public void testQuery() throws IOException, RequestErrorException {
        long outTradeNo = 1122564154289815808L;
        WxApiOrderQueryModel model = new WxApiOrderQueryModel(String.valueOf(outTradeNo));
        WxApiOrderQueryRequest request = new WxApiOrderQueryRequest(model);
        WxApiOrderQueryResponse execute = client.execute(request);
        System.out.println("execute = " + execute);
    }
}
