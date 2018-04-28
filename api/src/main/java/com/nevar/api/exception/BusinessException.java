package com.nevar.api.exception;

public class BusinessException extends RuntimeException{
    private Integer code;

    public BusinessException(ErrorCode resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
