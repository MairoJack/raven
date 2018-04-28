package com.nevar.api.exception;

import com.nevar.api.model.Result;
import com.nevar.api.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            return ResultUtil.error(businessException.getCode(), businessException.getMessage());
        } else if(e instanceof BindException) {
            FieldError error = ((BindException) e).getBindingResult().getFieldError();
            return ResultUtil.error(1000, error.getDefaultMessage());
        } else {
            log.error("【系统异常】{}", e.getMessage());
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
