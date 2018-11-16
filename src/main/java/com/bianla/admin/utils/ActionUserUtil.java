package com.bianla.admin.utils;

import com.bianla.admin.Enum.ResultEnum;
import com.bianla.admin.dto.Result;
import com.bianla.admin.entity.ActionUser;
import com.bianla.admin.service.IActionUserService;
import com.bianla.admin.service.RedisService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by admin on 2018/10/28.
 */
public class ActionUserUtil {
    public static RedisService redisService = SpringContextUtil.getBean(RedisService.class);

    public static IActionUserService actionUserService = SpringContextUtil.getBean(IActionUserService.class);

    public static String login(Integer actionUserId, HttpServletResponse response, HttpServletRequest request){
        //CookieUtil.create(CookieUtil.LOGIN_ACTION_USER_ID, actionUserId+"", CookieUtil.COOKIE_HALF_HOUR, response, true);
        //生成token
        String ip = getUserIP(request);
        String token = UUID.randomUUID() + "";
        String showToken = MD5Util.MD5Encode(ip + token);
        redisService.set(showToken, actionUserId, CookieUtil.COOKIE_HALF_HOUR);
        return token;
    }

    public static Result getUserId(String token, HttpServletRequest request, HttpServletResponse response){
        //String userId = CookieUtil.retrieve(CookieUtil.LOGIN_ACTION_USER_ID, request, true);
        String ip = getUserIP(request);
        String showToken = MD5Util.MD5Encode(ip + token);
        Object userId = redisService.get(showToken);
        if(userId == null){
            return ResultUtil.NOTLOGIN();
        }
        ActionUser actionUser = actionUserService.queryById(Integer.valueOf(userId.toString()));
        if(actionUser == null){
            return new Result(ResultEnum.UserInvalid);
        }
        //CookieUtil.create(CookieUtil.LOGIN_ACTION_USER_ID, userId+"", CookieUtil.COOKIE_HALF_HOUR, response, true);
        redisService.set(showToken, userId, CookieUtil.COOKIE_HALF_HOUR);
        ResultUtil util = new ResultUtil();
        return util.SUCCESS(userId);

    }

    /**
     * 取得用户的 IP 地址.
     *
     * @param request
     *            WEB 请求
     * @return
     */
    public static String getUserIP(HttpServletRequest request) {
        String ipaddress = request.getHeader("X-Real-IP");
        if (ipaddress == null) {
            ipaddress = request.getHeader("X-Forwarded-For");
        }
        if (ipaddress == null) {
            ipaddress = request.getRemoteAddr();
        } else {
            int index = ipaddress.indexOf(',');
            if (index != -1) {
                ipaddress = ipaddress.substring(0, index);
            }
        }

        return ipaddress;
    }
}
