package edu.wyzc.paycore.wx.exceptions;

/**
 * Created by Allen on 2018/6/14.
 */
public class InvalidWxRequestException extends RuntimeException {
    public InvalidWxRequestException() {
    }

    public InvalidWxRequestException(String message) {
        super(message);
    }

    public InvalidWxRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
