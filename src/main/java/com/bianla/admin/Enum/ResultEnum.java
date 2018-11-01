package com.bianla.admin.Enum;

/**
 * Created by admin on 2018/10/28.
 */
public enum ResultEnum {
    SUCCESS(1, "成功"), NOT_LOGIN(0, "未登录"), ERROR(-1, "服务器错误"), OTHER_ERROR(3, "其他错误"),
    EMPTY_DATA(4, "数据为空"), NOT_MORE_DATA(5, "没有更多数据了");
    private String msg;
    private int code;
    ResultEnum(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
