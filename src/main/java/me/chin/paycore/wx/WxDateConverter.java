package me.chin.paycore.wx;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import me.chin.paycore.wx.constants.WxPayConstants;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Allen on 2018/6/25.
 */
public class WxDateConverter implements Converter{

    /**
     * java 2 xml
     * @param source
     * @param writer
     * @param context
     */
    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        writer.setValue(DateFormatUtils.format((Date) source,WxPayConstants.WX_DATE_FORMAT));
    }

    /**
     * xml 2 java
     * @param reader
     * @param context
     * @return
     */
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        String value = reader.getValue();
        try {
            return DateUtils.parseDate(value, WxPayConstants.WX_DATE_FORMAT);
        } catch (ParseException e) {
            throw new ConversionException(e.getMessage(),e);
        }
    }

    /**
     * convert type
     * @param type
     * @return
     */
    @Override
    public boolean canConvert(Class type) {
        return Date.class.isAssignableFrom(type);
    }
}
