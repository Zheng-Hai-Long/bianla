package com.bianla.admin.exception;

/**
 * Created by admin on 2018/9/16.
 */
public class AuctionUserException extends RuntimeException {
    private Integer code;

    public AuctionUserException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
