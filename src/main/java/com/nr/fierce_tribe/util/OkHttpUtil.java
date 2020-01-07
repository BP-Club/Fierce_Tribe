package com.nr.fierce_tribe.util;

import com.nr.fierce_tribe.exception.ServiceException;
import com.nr.fierce_tribe.service.ResponseHandler;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class OkHttpUtil {

    private static final OkHttpClient CLIENT;

    static {
        CLIENT = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS) //连接超时
                .writeTimeout(50, TimeUnit.SECONDS) //写超时
                .readTimeout(50, TimeUnit.SECONDS) //读超时
                .build();
    }

    public static <T> T get(String url, Map<String, String> headers, Map<String, Object> params, ResponseHandler<T> responseHandler) {
        Request.Builder builder = new Request.Builder();

        if (!CollectionUtils.isEmpty(headers)) {
            headers.forEach(builder::header);
        }

        if (!CollectionUtils.isEmpty(params)) {
            StringBuilder stringBuilder = new StringBuilder("?");
            params.forEach((k, v) -> stringBuilder.append(k).append("=").append(v).append("&"));
            String param = stringBuilder.toString();
            url += param.substring(0, param.length() - 1);
        }

        Request request = builder.url(url).build();

        try (Response response = CLIENT.newCall(request).execute()){
//            if (!response.isSuccessful()) {
//                log.error("HTTP GET 请求失败：{}, {}", response.code(), response.message());
//                log.error("request: {}", request.url().toString());
//                throw new ServiceException(response.message());
//            }
            return responseHandler.handleResponse(response);
        } catch (IOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public static <T> T post(String url, Map<String, String> headers, String jsonParams, ResponseHandler<T> responseHandler) {
        Request.Builder builder = new Request.Builder();
        if (!CollectionUtils.isEmpty(headers)) {
            headers.forEach(builder::header);
        }
        if (!StringUtils.isEmpty(jsonParams)) {
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);
            builder.post(body);
        }
        Request request = builder.url(url).build();
        try (Response response = CLIENT.newCall(request).execute()){
            if (!response.isSuccessful()) {
                log.error("HTTP POST 请求失败：{}", response.code());
                log.error("request: {}", request.url().toString());
                throw new ServiceException(response.message());
            }
            return responseHandler.handleResponse(response);
        } catch (IOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public static <T> T put(String url, Map<String, String> headers, String jsonParams, ResponseHandler<T> responseHandler) {
        Request.Builder builder = new Request.Builder();
        if (!CollectionUtils.isEmpty(headers)) {
            headers.forEach(builder::header);
        }
        if (!StringUtils.isEmpty(jsonParams)) {
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);
            builder.put(body);
        }
        Request request = builder.url(url).build();
        try (Response response = CLIENT.newCall(request).execute()){
            if (!response.isSuccessful()) {
                log.error("HTTP PUT 请求失败：{}", response.code());
                log.error("request: {}", request.url().toString());
                throw new ServiceException(response.message());
            }
            return responseHandler.handleResponse(response);
        } catch (IOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}