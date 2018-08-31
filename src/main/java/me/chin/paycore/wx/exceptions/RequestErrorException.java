package me.chin.paycore.wx.exceptions;

/**
 * Created by Allen on 2018/6/21.
 */
public class RequestErrorException extends Exception {
    public RequestErrorException() {
    }

    public RequestErrorException(String message) {
        super(message);
    }

    public RequestErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
