package com.bianla.admin.utils;


import com.bianla.admin.Enum.ResultEnum;
import com.bianla.admin.dto.Result;

/**
 * Created by admin on 2018/9/16.
 */
public class ResultUtil<T> {

    public static Result EMPTY_DATA(){
        Result result = new Result();
        result.setCode(ResultEnum.EMPTY_DATA.getCode());
        result.setMsg(ResultEnum.EMPTY_DATA.getMsg());
        return result;
    }

    public Result SUCCESS( T t){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(t);
        return result;
    }

    public static Result SUCCESS(){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return result;
    }

    public static Result ERROR(int code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result ERROR(){
        Result result = new Result();
        result.setCode(ResultEnum.ERROR.getCode());
        result.setMsg(ResultEnum.ERROR.getMsg());
        return result;
    }

    public static Result NOTLOGIN(){
        Result result = new Result();
        result.setCode(ResultEnum.NOT_LOGIN.getCode());
        result.setMsg(ResultEnum.NOT_LOGIN.getMsg());
        return result;
    }
}
