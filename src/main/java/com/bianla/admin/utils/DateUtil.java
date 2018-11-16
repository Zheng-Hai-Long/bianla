package com.bianla.admin.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Created by ZHL on 2018/11/15.
 */
public class DateUtil {

    public static final String Default_Time_Format = "yyyy-MM-dd HH:mm:ss";

    public static final String Time_yyyyMMdd_Format = "yyyy-MM-dd";

    /**
     * 根据当前时间生成年月日STR yyyyMMdd
     * @return
     */
    public static String getCurrentYearMonthDay(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern(Time_yyyyMMdd_Format);
        LocalDate localDate = LocalDate.parse(LocalDate.now().toString(), df);
        return localDate.toString().replaceAll("-", "");
    }

    /**
     * 获取当前时间的时间戳
     * @return
     */
    public static String getCurrentTimestamp(){
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        return milliSecond+"";
    }

    /**
     * 当前时间与传入时间比较查询相差月份
     * @param dateStr
     * @return
     */
    public static int getMonth(String dateStr){
        LocalDate startDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(Default_Time_Format));
        LocalDate endDate = LocalDate.now();

        Period period = Period.between(startDate, endDate);
        int year = period.getYears();
        int month = period.getMonths();
        return year*12 + month;
    }

    /**
     * endDate-startDate 相差月份
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getMonth(String startDate, String endDate){
        LocalDate endDate2 = LocalDate.parse(startDate, DateTimeFormatter.ofPattern(Default_Time_Format));
        LocalDate startDate2 = LocalDate.parse(endDate, DateTimeFormatter.ofPattern(Default_Time_Format));

        Period period = Period.between(endDate2, startDate2);
        int year = period.getYears();
        int month = period.getMonths();
        return year*12 + month;
    }

}
