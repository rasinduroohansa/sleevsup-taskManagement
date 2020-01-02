package com.biz.sleevsup.exception.handler;

import com.biz.sleevsup.response.GenericResponse;
import com.biz.sleevsup.utilites.ResponseCodes;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public GenericResponse handleRuntimeException(RuntimeException ex) {
         return new GenericResponse(ex.getMessage(), ResponseCodes.SERVERERROR.code);
    }
}
