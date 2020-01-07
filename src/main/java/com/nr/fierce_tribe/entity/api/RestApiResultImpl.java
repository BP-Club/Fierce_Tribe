package com.nr.fierce_tribe.entity.api;

import com.nr.fierce_tribe.entity.api.RestApiResult;

import java.util.HashMap;

public class RestApiResultImpl extends HashMap<String, Object> implements RestApiResult {

    public static final RestApiResult DEFAULT_TRUE = new RestApiResultImpl();

    public static RestApiResult buildFromException(RestApiResult e) {
        return new RestApiResultImpl(false, e.getErrorCode(), e.getErrorMsg(), null);
    }

    public RestApiResultImpl(Boolean success, Integer errorCode, String errorMsg, Object data) {
        super(4);
        this.put("success", success);
        this.put("errorCode", errorCode);
        this.put("errorMsg", errorMsg);
        this.put("data", data);
    }

    public RestApiResultImpl(Object data){
        super(4);
        this.put("success", true);
        this.put("errorCode", 0);
        this.put("errorMsg", "");
        this.put("data", data);
    }

    private RestApiResultImpl(){
        super(4);
        this.put("success", true);
        this.put("errorCode", 0);
        this.put("errorMsg", "");
        this.put("data", null);
    }

    @Override
    public boolean isSuccess() {
        return Boolean.parseBoolean(get("success").toString());
    }

    @Override
    public int getErrorCode() {
        return Integer.parseInt(get("errorCode").toString());
    }

    @Override
    public String getErrorMsg() {
        return get("errorMsg").toString();
    }

    @Override
    public Object getData() {
        return get("data");
    }

}
