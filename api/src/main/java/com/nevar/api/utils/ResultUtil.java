package com.nevar.api.utils;


import com.nevar.api.model.Result;

public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setStatus(0);
        result.setMessage("成功");
        result.setData(object);
        return result;
    }

    public static Result success(String msg) {
        Result result = new Result();
        result.setStatus(0);
        result.setMessage(msg);
        result.setData(null);
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setStatus(code);
        result.setMessage(msg);
        return result;
    }
}
