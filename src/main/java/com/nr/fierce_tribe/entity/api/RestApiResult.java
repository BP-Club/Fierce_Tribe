package com.nr.fierce_tribe.entity.api;

public interface RestApiResult {

    boolean isSuccess();

    int getErrorCode();

    String getErrorMsg();

    Object getData();

}