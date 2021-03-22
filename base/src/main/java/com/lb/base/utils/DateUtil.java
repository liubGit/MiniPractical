package com.lb.base.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Create by liub on 2021/3/4
 * Describe:
 * 日期工具
 */
public class DateUtil {

    /** 日期格式：yyyy-MM-dd HH:mm:ss **/
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /** 日期格式：yyyy-MM-dd HH:mm **/
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    /** 日期格式：yyyy-MM-dd **/
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    /** 日期格式：HH:mm:ss **/
    public static final String HH_MM_SS = "HH:mm:ss";

    /** 日期格式：HH:mm **/
    public static final String HH_MM = "HH:mm";

    private final static long MINUTE = 60 * 1000;// 1分钟
    private final static long HOUR = 60 * MINUTE;// 1小时
    private final static long DAY = 24 * HOUR;// 1天
    private final static long MONTH = 31 * DAY;// 月
    private final static long YEAR = 12 * MONTH;// 年

    /** Log输出标识 **/
    private static final String TAG = DateUtil.class.getSimpleName();



    /**
     * 根据指定格式，获取现在时间
     */
    public static String getNowDateFormat(String format) {
        final Date currentTime = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(currentTime);
    }

    /**
     * 将日期格式化成友好的字符串：几分钟前、几小时前、几天前、几月前、几年前、刚刚
     *
     * @param date
     * @return
     */
    public static String formatFriendly(Date date) {
        if (date == null) {
            return null;
        }
        long diff = new Date().getTime() - date.getTime();
        long r = 0;
        if (diff > YEAR) {
            r = (diff / YEAR);
            return r + "年前";
        }
        if (diff > MONTH) {
            r = (diff / MONTH);
            return r + "个月前";
        }
        if (diff > DAY) {
            r = (diff / DAY);
            return r + "天前";
        }
        if (diff > HOUR) {
            r = (diff / HOUR);
            return r + "个小时前";
        }
        if (diff > MINUTE) {
            r = (diff / MINUTE);
            return r + "分钟前";
        }
        return "刚刚";
    }

    /**
     * 将日期以yyyy-MM-dd HH:mm:ss格式化
     *
     * @param dateL
     *            日期
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String formatDateTime(String dateL, String formater) {
        if (!TextUtils.isEmpty(dateL)) {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formater);

            Date getDate = null;
            try {
                getDate = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).parse(dateL);
            } catch (ParseException e) {
                e.printStackTrace();
                return dateL;
            }

            return simpleDateFormat.format(getDate);
        }
        return dateL;
    }


    /**
     * 把yyyy-MM-dd'T'HH:mm:ssZ类型日期转成yyyy.MM.dd类型
     *
     * @param str
     * @return
     */
    public static String parseStrToDate(String str,String formater) {
        if (str != null && str.length() > 0) {
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(str);
            } catch (Exception ex) {
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formater);
            return simpleDateFormat.format(date);
        } else {
            return null;
        }
    }

    /**
     * 计算两个时间相隔分钟
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long getIntervalMinutes(String startTime, String endTime) {
        if (!TextUtils.isEmpty(startTime) && !TextUtils.isEmpty(endTime)) {
            try {
                final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                final Date startDate = format.parse(startTime);
                final Calendar start = Calendar.getInstance();
                start.clear();
                start.setTime(startDate);

                final Date endDate = format.parse(endTime);
                final Calendar end = Calendar.getInstance();
                end.clear();
                end.setTime(endDate);

                // 把时间转成毫秒
                final long time1 = start.getTimeInMillis();
                final long time2 = end.getTimeInMillis();

                // 计算两个时间相差多少毫秒
                final long diff = time1 - time2;

                // 把相差的毫秒转成分钟
                final long diffMin = diff / (60 * 1000);

                {/*
                // 相差小时
                long diffHours = diff / (60 * 60 * 1000);
                System.out.println("Difference in hours " + diffHours);

                // 相差天
                long diffDays = diff / (24 * 60 * 60 * 1000);
            */
                }

                return diffMin;
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }
}
