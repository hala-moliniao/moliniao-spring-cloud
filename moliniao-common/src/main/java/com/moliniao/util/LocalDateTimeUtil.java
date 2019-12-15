package com.moliniao.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author: created by limingzhou
 * @date: 2019/11/28
 * @description: 时间操作工具类
 */
public class LocalDateTimeUtil {

    private static Pattern PATTERN =Pattern.compile("^[-\\+]?[.\\d]*$");
    private static DateTimeFormatter dtfymdhms = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static DateTimeFormatter dtfymd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static DateTimeFormatter dtfHms = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static LocalDateTime getDateTimeOfTimestamp(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    public static LocalDateTime strToDateTime(String timeStr){
        return LocalDateTime.parse(timeStr,dtfymdhms);
    }

    public static String dateToStrYMD(LocalDateTime dateTime){
        return dateTime.format(dtfymd);
    }

    public static String dateToStrYMDHMS() {
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(dtfymdhms);
    }

    public static int dateBetweenMinutes(LocalDateTime startTime, LocalDateTime endTime){
        Duration duration= Duration.between(startTime,endTime);
        return (int)duration.toMinutes();
    }

    public static String dateToStrHms(LocalDateTime dateTime){
        return dateTime.format(dtfHms);
    }


    /**
     * 校验日期格式
     * @author zw
     * @param  * @param null
     * @return
     * @throws
     * @since
     * @date 2019/2/25 21:01
     */
    public static boolean isValidDate(String str,String formatDate) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        if (StringUtils.isBlank(formatDate)) {
            formatDate = "yyyy-MM-dd";
        }
        boolean convertSuccess=true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy-MM-dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat(formatDate);
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess=false;
        }
        return convertSuccess;
    }

    /**
     * 日期转换
     * @author zw
     * @param  * @param null
     * @return
     * @throws
     * @since
     * @date 2019/2/25 21:07
     */
    public static String dateFormatZh2En(String date) {
        if (StringUtils.isBlank(date)) {
            return date;
        }
        date = date.replace("年","-");
        date = date.replace("月","-");
        date = date.replace("日","");
        date = date.replace(".","-");
        return date;
    }

    /**
     * 计算年龄
     * @param birthDay
     * @return
     * @throws Exception
     */
    public static Integer getAge(Date birthDay) {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            //出生日期晚于当前时间，无法计算
            return null;
        }
        //当前年份
        int yearNow = cal.get(Calendar.YEAR);
        //当前月份
        int monthNow = cal.get(Calendar.MONTH);
        //当前日期
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        //计算整岁数
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    //当前日期在生日之前，年龄减一
                    age--;
                }
            }else{
                //当前月份在生日之前，年龄减
                age--;
            } }
            return age;
    }
}
