package com.nr.fierce_tribe.exception;


import com.nr.fierce_tribe.entity.api.RestApiResult;
import com.nr.fierce_tribe.entity.api.RestApiResultImpl;
import com.nr.fierce_tribe.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.UndeclaredThrowableException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public RestApiResult serviceErrorHandler(ServiceException e) {
        log.error("", e);
        return RestApiResultImpl.buildFromException(e);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestApiResult defaultErrorHandler(Exception e) {
        if (e instanceof UndeclaredThrowableException) {
            e = (Exception) ((UndeclaredThrowableException) e).getUndeclaredThrowable();
        }
        log.error("", e);
        return new RestApiResultImpl(false, -1, e.getMessage(), null);
    }

}
