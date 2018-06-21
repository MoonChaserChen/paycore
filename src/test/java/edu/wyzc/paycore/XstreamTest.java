package edu.wyzc.paycore;

import edu.wyzc.paycore.wx.ApiFieldReader;
import edu.wyzc.paycore.wx.response.WxApiPayResponse;
import org.junit.Test;

/**
 * Created by Allen on 2018/6/20.
 */
public class XstreamTest {
    @Test
    public void testParse(){
        String xmlData = "<xml><return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "<return_msg><![CDATA[OK]]></return_msg>\n" +
                "<appid><![CDATA[wx3b6fc3be742ef3f2]]></appid>\n" +
                "<mch_id><![CDATA[1500332452]]></mch_id>\n" +
                "<nonce_str><![CDATA[aGrASBmqjeUOgGbi]]></nonce_str>\n" +
                "<sign><![CDATA[BEB59EB235CFA845116D070E1D529120]]></sign>\n" +
                "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "<prepay_id><![CDATA[wx20125115708065867f7893602447440971]]></prepay_id>\n" +
                "<trade_type><![CDATA[NATIVE]]></trade_type>\n" +
                "<code_url><![CDATA[weixin://wxpay/bizpayurl?pr=WYHYEEE]]></code_url>\n" +
                "</xml>";
        WxApiPayResponse read = ApiFieldReader.readFromXml(WxApiPayResponse.class, xmlData);
        System.out.println("readFromXml = " + read);
    }
}
