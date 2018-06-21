package edu.wyzc.paycore;

import com.alipay.api.internal.util.WebUtils;
import com.github.wxpay.sdk.WXPay;
import edu.wyzc.paycore.wx.MyConfig;
import edu.wyzc.paycore.wx.utils.WxPaySignUtils;
import edu.wyzc.util.utils.TransferUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Allen on 2018/6/13.
 */
public class CommonTest {
    /**
     * wx official sdk for paying
     * @throws Exception
     */
    @Test
    public void common() throws Exception {

        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<>();
        data.put("body", "扫码支付测试");
        data.put("out_trade_no", "2018090910595900000012");
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "111.200.194.253");
        data.put("notify_url", "http://www.example.com/wxpay/notify");
        data.put("trade_type", "NATIVE");
        data.put("product_id", "12");
//        Map<String, String> resp = wxpay.unifiedOrder(data);
//        System.out.println(resp);
    }

    @Test
    public void testMap2Xml() throws SAXException {
        Map<String, String> data = new HashMap<>();
        data.put("body", "扫码支付测试");
        data.put("out_trade_no", "2018090910595900000012");
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "111.200.194.253");
        data.put("notify_url", "http://www.example.com/wxpay/notify");
        data.put("trade_type", "NATIVE");
        data.put("product_id", "12");
        Map<String, String> map = TransferUtils.standardXml2Map(TransferUtils.map2StandardXml(data));
        System.out.println(map);
    }

    @Test
    public void testSignature(){
        Map<String, String> data = new HashMap<>();
        data.put("body", "扫码支付测试");
        data.put("out_trade_no", "2018090910595900000012");
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "111.200.194.253");
        data.put("notify_url", "http://www.example.com/wxpay/notify");
        data.put("trade_type", "NATIVE");
        data.put("product_id", "12");
        String signedXml = WxPaySignUtils.generateMD5SignedXml(data, "abc");
        Assertions.assertThat(WxPaySignUtils.isMD5SignatureValid(signedXml, "abc")).isEqualTo(true);
    }

    @Test
    public void testObject2XmlString(){
        Student s = new Student();
        s.setId(1);
        s.setName("Chen");
        String s1 = TransferUtils.object2XmlString(s, "student");
        System.out.println("s1 = " + s1);
    }

    /**
     * test wx pay by alipay-WebUtils
     * @throws IOException
     */
    @Test
    public void testRequestToWx() throws IOException {
        Map<String, String> data = new HashMap<>();
        data.put("appid", "wx3b6fc3be742ef3f2");
        data.put("mch_id", "1500332452");
        data.put("nonce_str", UUID.randomUUID().toString().replace("-",""));
        data.put("body", "扫码支付测试");
        data.put("out_trade_no", "2018090910595900000012");
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "111.200.194.253");
        data.put("notify_url", "http://www.example.com/wxpay/notify");
        data.put("trade_type", "NATIVE");
        data.put("product_id", "12");
        String requestWithSign = WxPaySignUtils.generateMD5SignedXml(data, "YtXBmnuScZlIXkBvjRLFDbZHCX649n8D");
        String result = WebUtils.doPost("https://api.mch.weixin.qq.com/pay/unifiedorder", "application/x-www-form-urlencoded;charset=UTF-8",
                requestWithSign.getBytes(), 3000, 15000, null, 0);
        System.out.println("result = " + result);
    }
}