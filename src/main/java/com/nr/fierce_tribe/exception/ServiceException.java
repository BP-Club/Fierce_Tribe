package com.nr.fierce_tribe.exception;


import com.nr.fierce_tribe.entity.api.RestApiResult;

/**
 * @author: dlw
 * @description:
 * @create: 20120-01-06s 17:39
 **/
public class ServiceException extends RuntimeException implements RestApiResult {

    private int errorCode;

    public ServiceException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(String message) {
        super(message);
        this.errorCode = -1;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMsg() {
        return getMessage();
    }

    @Override
    public Object getData() {
        return null;
    }
}
