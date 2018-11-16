package com.bianla.admin.utils;


import com.bianla.admin.Enum.ResultEnum;
import com.bianla.admin.dto.Result;

/**
 * Created by admin on 2018/9/16.
 */
public class ResultUtil<T> {

    public static Result EMPTY_DATA(){
        return new Result(ResultEnum.EMPTY_DATA);
    }

    public Result SUCCESS( T t){
        return new Result(ResultEnum.SUCCESS, t);
    }

    public static Result SUCCESS(){
        return new Result(ResultEnum.SUCCESS);
    }

    public static Result ERROR(int code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result ERROR(){
        return new Result(ResultEnum.ERROR);
    }

    public static Result NOTLOGIN(){
        return new Result(ResultEnum.NOT_LOGIN);
    }
}
