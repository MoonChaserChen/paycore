package me.chin.paycore.wx.mapping;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Allen on 2018/6/14.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD })
public @interface ApiField {

    /** wx xml tag name **/
    String value() default "";

}
