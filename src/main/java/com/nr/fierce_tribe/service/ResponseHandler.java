package com.nr.fierce_tribe.service;

import okhttp3.Response;

@FunctionalInterface
public interface ResponseHandler<T> {

    T handleResponse(Response response);

}
