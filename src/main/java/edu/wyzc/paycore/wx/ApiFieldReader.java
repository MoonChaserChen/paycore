package edu.wyzc.paycore.wx;

import com.thoughtworks.xstream.XStream;
import edu.wyzc.paycore.wx.constants.WxPayConstants;
import edu.wyzc.paycore.wx.mapping.ApiField;

import java.lang.reflect.Field;

/**
 * Created by Allen on 2018/6/20.
 */
public class ApiFieldReader {
    public static <T> T readFromXml(Class<T> clazz, String xmlData){
        XStream xStream = new XStream();
        xStream.registerConverter(new WxDateConverter());
        xStream.ignoreUnknownElements();
        xStream.alias(WxPayConstants.XML_TAG, clazz);
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            ApiField apiField = declaredField.getAnnotation(ApiField.class);
            if (null != apiField) {
                xStream.aliasField(apiField.value(),clazz,declaredField.getName());
            }
        }
        return (T) xStream.fromXML(xmlData);
    }
}
