package edu.wyzc.paycore;

import edu.wyzc.paycore.wx.enums.TradeType;
import edu.wyzc.paycore.wx.exceptions.InvalidWxRequestException;
import edu.wyzc.paycore.wx.model.WxPayRequestModel;
import edu.wyzc.paycore.wx.request.WxPayRequest;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

/**
 * Created by Allen on 2018/6/14.
 */
public class ApiFieldTest {
    @Test
    public void testApiField() throws InvalidWxRequestException {
        WxPayRequestModel model = new WxPayRequestModel("测试",String.valueOf(123456789L),1L,
                "111.200.194.253",new Date(),new Date(),"http://www.baidu.com", TradeType.NATIVE);
        WxPayRequest request = new WxPayRequest(model);
        Map<String, String> apiFieldsAsMap = request.getApiFieldsAsMap();
        System.out.println("apiFieldsAsMap = " + apiFieldsAsMap);
    }
}
