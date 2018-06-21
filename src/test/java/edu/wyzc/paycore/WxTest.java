package edu.wyzc.paycore;

import edu.wyzc.paycore.wx.client.DefaultWxClient;
import edu.wyzc.paycore.wx.client.WxClient;
import edu.wyzc.paycore.wx.enums.SignType;
import edu.wyzc.paycore.wx.enums.TradeType;
import edu.wyzc.paycore.wx.exceptions.InvalidWxRequestException;
import edu.wyzc.paycore.wx.exceptions.RequestErrorException;
import edu.wyzc.paycore.wx.model.WxApiPayRequestModel;
import edu.wyzc.paycore.wx.request.WxApiPayRequest;
import edu.wyzc.paycore.wx.response.WxApiPayResponse;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Allen on 2018/6/14.
 */
public class WxTest {
    @Test
    public void testPayRequest() throws InvalidWxRequestException, IOException, RequestErrorException {
        WxApiPayRequestModel model = new WxApiPayRequestModel("测试",String.valueOf(1234567893L),1L,
                "118.200.194.253",new Date(),new Date(new Date().getTime() + 1000 * 60 * 5),"http://1114df5c.ngrok.io/alipayPayNotify", TradeType.NATIVE);
        WxApiPayRequest request = new WxApiPayRequest(model);
        WxClient client = new DefaultWxClient("1500332452","wx3b6fc3be742ef3f2","YtXBmnuScZlIXkBvjRLFDbZHCX649n8D",new byte[0], SignType.MD5,null,0);

        WxApiPayResponse execute = client.execute(request);
        String codeUrl = execute.getCodeUrl();
        System.out.println("codeUrl = " + codeUrl);
    }
}
