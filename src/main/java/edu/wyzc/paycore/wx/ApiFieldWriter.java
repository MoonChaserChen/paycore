package edu.wyzc.paycore.wx;

import edu.wyzc.paycore.WxHashMap;
import edu.wyzc.paycore.wx.mapping.ApiField;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by Allen on 2018/6/14.
 */
public class ApiFieldWriter {
    public static Map<String, String> write(Object object){
        WxHashMap result = new WxHashMap();
        Field[] declaredFields = object.getClass().getDeclaredFields();
        try {
            for (Field declaredField : declaredFields) {
                ApiField apiField = declaredField.getAnnotation(ApiField.class);
                if (null != apiField) {
                    PropertyDescriptor pd = new PropertyDescriptor(declaredField.getName(),object.getClass());
                    Method accessor = pd.getReadMethod();
                    if (!accessor.isAccessible()){
                        accessor.setAccessible(true);
                    }
                    Object value = accessor.invoke(object, (Object[]) null);
                    if (null != value) {
                        result.put(apiField.value(),value);
                    }
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
