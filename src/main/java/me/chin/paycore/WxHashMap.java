package me.chin.paycore;

import me.chin.paycore.wx.constants.WxPayConstants;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * Created by Allen on 2018/6/14.
 */
public class WxHashMap extends HashMap<String, String> {
    private static final long serialVersionUID = -1277791390393392630L;

    public WxHashMap() {
        super();
    }

    public WxHashMap(Map<? extends String, ? extends String> m) {
        super(m);
    }

    public String put(String key, Object value) {
        String strValue;

        if (value == null) {
            strValue = null;
        } else if (value instanceof String) {
            strValue = (String) value;
        } else if (value instanceof Integer) {
            strValue = ((Integer) value).toString();
        } else if (value instanceof Long) {
            strValue = ((Long) value).toString();
        } else if (value instanceof Float) {
            strValue = ((Float) value).toString();
        } else if (value instanceof Double) {
            strValue = ((Double) value).toString();
        } else if (value instanceof Boolean) {
            strValue = ((Boolean) value).toString();
        } else if (value instanceof Date) {
            DateFormat format = new SimpleDateFormat(WxPayConstants.WX_DATE_FORMAT);
            format.setTimeZone(TimeZone.getTimeZone(WxPayConstants.DATE_TIMEZONE));
            strValue = format.format((Date) value);
        } else {
            strValue = value.toString();
        }

        return this.put(key, strValue);
    }

    public String put(String key, String value) {
        if (StringUtils.isNoneEmpty(key, value)) {
            return super.put(key, value);
        }
        return null;
    }
}
