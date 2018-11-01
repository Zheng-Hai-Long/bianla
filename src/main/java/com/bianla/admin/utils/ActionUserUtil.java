package com.bianla.admin.utils;

import com.bianla.admin.dto.Result;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2018/10/28.
 */
public class ActionUserUtil {

    public static void login(Integer actionUserId, HttpServletResponse response, HttpServletRequest request){
        CookieUtil.setCookie(request, response, CookieUtil.LOGIN_ACTION_USER_ID, actionUserId+"", CookieUtil.COOKIE_HALF_HOUR, true);
    }

    public static Result getUserId(HttpServletRequest request){
        String userId = CookieUtil.getCookieValue(request, CookieUtil.LOGIN_ACTION_USER_ID, true);
        if(StringUtils.isBlank(userId)){
            return ResultUtil.NOTLOGIN();
        }
        ResultUtil util = new ResultUtil();
        return util.SUCCESS(userId);

    }
}
