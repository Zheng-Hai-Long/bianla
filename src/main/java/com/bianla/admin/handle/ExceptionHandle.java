package com.bianla.admin.handle;

import com.bianla.admin.dto.Result;
import com.bianla.admin.exception.AuctionUserException;
import com.bianla.admin.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 2018/9/16.
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof AuctionUserException){
            AuctionUserException girlException = (AuctionUserException) e;
            return ResultUtil.ERROR(girlException.getCode(), girlException.getMessage());
        }
        return ResultUtil.ERROR(-1, "未知错误");
    }
}
