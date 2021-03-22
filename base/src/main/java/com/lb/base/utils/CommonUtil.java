package com.lb.base.utils;

import android.text.TextUtils;

import java.math.BigDecimal;

/**
 * Create by liub on 2021/3/4
 * Describe:
 * 公用的方法
 */
public class CommonUtil {

    /**
     * 格式化为指定位小数的数字,返回未使用科学计数法表示的具有指定位数的字符串。
     * 该方法舍入模式：向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为向上舍入的舍入模式。
     * <pre>
     * 	"3.1415926", 1			--> 3.1
     * 	"3.1415926", 3			--> 3.142
     * 	"3.1415926", 4			--> 3.1416
     * 	"3.1415926", 6			--> 3.141593
     * 	"1234567891234567.1415926", 3	--> 1234567891234567.142
     * </pre>
     * @param number 类型的数字对象
     * @param precision  小数精确度总位数,如2表示两位小数
     * @return 返回数字格式化后的字符串表示形式(注意返回的字符串未使用科学计数法)
     */
    public static String keepPrecision(String number, int precision) {
        BigDecimal bg = new BigDecimal(number);
        return bg.setScale(precision, BigDecimal.ROUND_HALF_UP).toPlainString();
    }
    public static double keepPrecision(double number, int precision) {
        BigDecimal bg = new BigDecimal(number);
        return bg.setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static float keepPrecision(float number, int precision) {
        BigDecimal bg = new BigDecimal(number);
        return bg.setScale(precision, BigDecimal.ROUND_HALF_UP).floatValue();
    }
    /**
     * 校验邮箱
     *
     * @param paramString
     * @return
     */
    public static boolean isValidEmail(String paramString) {

        String regex = "[a-zA-Z0-9_\\.]{1,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
        if (paramString.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 校验ＱＱ
     *
     * @param paramString
     * @return
     */
    public static boolean isValidQQ(String paramString) {
        String regex = "^[1-9](\\d){4,9}$";
        if (paramString.matches(regex)) {
            return true;
        }
        return false;
    }

    /**
     * 校验车牌号
     *
     * @param paramString
     * @return
     */
    public static boolean isValidPlatnum(String paramString) {
        if (TextUtils.isEmpty(paramString)) return false;
        String regex = "^[\u4e00-\u9fa5]{1}[A-Z_a-z]{1}[A-Z_0-9_a-z]{5}$";
        if (paramString.matches(regex)) {
            return true;
        }
        return false;
    }

    /**
     * 校验手机号
     *
     * @param paramString
     * @return
     */
    public static boolean isValidMobiNumber(String paramString) {
        // String regex = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        if (paramString == null) return false;
        String regex = "^1\\d{10}$";
        if (paramString.matches(regex)) {
            return true;
        }
        return false;
    }
}
