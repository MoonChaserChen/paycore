package me.chin.paycore.wx.exceptions;

/**
 * Created by Allen on 2018/6/13.
 */
public class UnsupportedSignTypeException extends RuntimeException {
    public UnsupportedSignTypeException(String message) {
        super(message);
    }

    public UnsupportedSignTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
