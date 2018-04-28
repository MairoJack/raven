package com.nevar.api.controller;


import com.nevar.api.exception.BusinessException;
import com.nevar.api.exception.ErrorCode;
import com.nevar.api.model.Constant;
import com.nevar.api.model.Result;
import com.nevar.api.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RevokeTokenController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @ResponseBody
    @RequestMapping(value = "/oauth/logout")
    public Result revokeToken(@RequestHeader(value = "Authorization") String authorization){
        if (authorization != null && authorization.startsWith(Constant.BEARER_AUTHENTICATION)){
            if(consumerTokenServices.revokeToken(authorization.split(" ")[1])){
                return ResultUtil.success("登出成功");
            }
        }
        throw new BusinessException(ErrorCode.LOGOUT_FAIL);
    }
}
