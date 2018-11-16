package com.bianla.admin.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CookieUtil {

    public static final int COOKIE_MAX_AGE = 7 * 24 * 3600;

    public static final Long COOKIE_HALF_HOUR = 30 * 60l;


    private static final String COOKIE_KEY="bianla20181105";
    private static String DOMAIN_NAME= "localhost";//localhost;.17xs.org;

    //保存的cookie名称,登入有关cookie
    public static final String LOGIN_ACTION_USER_ID = "login_action_user_id";


    //保存的cookie有效时间
    public static final int EXPIRED_30MINUTE = 60*30;

    public static final int EXPIRED_DEFAULT_MINUTE = -1;

    public static int DAY = 24 * 60 * 60; //一天的秒数
    /**
     * 记住帐号密码的过期时间，缺省的时候是 30 天.
     */
    public static int EXPIRED_REMEBER = 30 * DAY;

    public static int YEAR = 365 *DAY; //一年

    /**
     * 取得 cookie 的值.
     *
     * @param cookieName cookie 名称
     * @param request    HttpServletRequest 对象
     * @return 如果找得到相应 cookie 的值，则返回该值，否则返回 null.
     */
    public static String retrieve(String cookieName, HttpServletRequest request, boolean IsEncrypt) {
        if (cookieName == null) {
            return null;
        }
        if(IsEncrypt){
            try{
                //对cookie解密
                cookieName = EncryptionUtil.encrypt(cookieName, COOKIE_KEY, EncryptionUtil.TYPE_DES).replaceAll("=", "");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            return null;
        }

        String cookieValue = null;
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookieName.equals(cookie.getName())) {
                cookieValue = cookie.getValue();
                break;
            }
        }
        if (cookieValue == null) {
            return null;
        }
        if(IsEncrypt){
            try{
                //对cookie解密
                cookieValue = EncryptionUtil.decrypt(cookieValue, COOKIE_KEY, EncryptionUtil.TYPE_DES);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return cookieValue;
    }

    /**
     * 创建新的 cookie .
     * <p>新的 cookie 的域默认为 binguo.com ，生命周期为 -1，即当前浏览器有效.</p>
     *
     * @param cookieName cookie 的名称
     * @param value      值
     * @param expired    过期时间，以秒为单位，预设值：CookieManager.EXPIRED_SESSION 和 CookieManager.EXPIRED_NEVER
     * @param response   HttpServletResponse 对象
     */
    public static void create(String cookieName, String value, int expired, HttpServletResponse response, boolean IsEncrypt) {
        try {
            value = URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if(IsEncrypt){
            try{
                //对cookie加密
                value = EncryptionUtil.encrypt(value, COOKIE_KEY, EncryptionUtil.TYPE_DES);
                cookieName = EncryptionUtil.encrypt(cookieName, COOKIE_KEY, EncryptionUtil.TYPE_DES).replaceAll("=", "");
            }catch(Exception e){
                //e.printStackTrace();
            }
        }

        Cookie cookie = new Cookie(cookieName, value);
        cookie.setMaxAge(expired);
        cookie.setPath("/");
        cookie.setDomain(DOMAIN_NAME);
        response.addCookie(cookie);
    }

    /**
     * 删除cookieName的cookie
     *
     * @param cookieName 要删除的cookie名字
     * @param response   HttpServletResponse 对象
     */
    public static void remove(String cookieName, HttpServletResponse response,boolean IsEncrypt) {
        if(IsEncrypt){
            try{
                //对cookie解密
                cookieName = EncryptionUtil.encrypt(cookieName, COOKIE_KEY, EncryptionUtil.TYPE_DES).replaceAll("=", "");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        cookie.setDomain(DOMAIN_NAME);
        response.addCookie(cookie);
    }



}