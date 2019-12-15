package com.moliniao.util;

import com.moliniao.constant.SystemConstant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: created by limingzhou
 * @date: 2019/12/15
 * @description: com.moliniao.util
 */
public class OrderIdUtil {

    private static DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static DateTimeFormatter YYYYMMDDHHMMSS = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static LocalDateTime strToDateTime(String timeStr) {
        return LocalDateTime.parse(timeStr, YYYY_MM_DD_HH_MM_SS);
    }

    public static String getOrderId() {
        LocalDateTime dateTime = LocalDateTime.now();
        return SystemConstant.STU_ORDER_NO_PREFIX + dateTime.format(YYYYMMDDHHMMSS);
    }
}
