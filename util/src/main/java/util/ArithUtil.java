package util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 浮点数计算util,确保不会丢失精度.
 */
public class ArithUtil {
    /**
     * float默认的精度, 即绝对能保证的位数
     */
    private static final int DEFAULT_FLOAT_SCALE = 6;

    /**
     * double默认的精度, 即绝对能保证的位数
     */
    private static final int DEFAULT_DOUBLE__SCALE = 15;

    public static final DecimalFormat FORMAT_1 = new DecimalFormat("###########.##");

    /**
     * float 加法
     */
    public static float add(float v1, float v2) {
        BigDecimal b1 = new BigDecimal(Float.toString(v1));
        BigDecimal b2 = new BigDecimal(Float.toString(v2));
        return b1.add(b2).floatValue();
    }

    /**
     * float 减法
     */
    public static float sub(float v1, float v2) {
        BigDecimal b1 = new BigDecimal(Float.toString(v1));
        BigDecimal b2 = new BigDecimal(Float.toString(v2));
        return b1.subtract(b2).floatValue();
    }

    /**
     * float 乘法
     */
    public static float mul(float v1, float v2) {
        BigDecimal b1 = new BigDecimal(Float.toString(v1));
        BigDecimal b2 = new BigDecimal(Float.toString(v2));
        return b1.multiply(b2).floatValue();
    }

    /**
     * float 除法,四舍五入
     */
    public static float div(float v1, float v2) {
        return div(v1, v2, DEFAULT_FLOAT_SCALE);
    }

    /**
     * float 除法 自定义精确到小数点后几位, 最多精确到小数点后六位
     */
    public static float div(float v1, float v2, int scale) {
        if (v2 == 0.0f) {
            return 0.0f;
        }
        BigDecimal b1 = new BigDecimal(Float.toString(v1));
        BigDecimal b2 = new BigDecimal(Float.toString(v2));

        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    /**
     * float 四舍五入 提供精确地小数位四舍五入处理, 最多精确到小数点后六位
     */
    public static float round(float v, int scale) {
        return div(v, 1, scale);
    }

    /*************************************************************************************************************************************************/
    /* double */
    /*************************************************************************************************************************************************/

    /**
     * double 加法
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * double 减法
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * double 乘法
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * double 除法 默认小数点位数.
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEFAULT_DOUBLE__SCALE);
    }

    /**
     * double 除法 自定义精确到小数点后几位.
     */
    public static double div(double v1, double v2, int scale) {
        if (v2 == 0.0) {
            return 0.0;
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * double 四舍五入 提供精确地小数位四舍五入处理.
     */
    public static double round(double v, int scale) {
        return div(v, 1, scale);
    }

    /**
     * 不损失精度将float转为double
     */
    public static double parseDouble(float f) {
        BigDecimal b1 = new BigDecimal(Float.toString(f));
        return b1.doubleValue();
    }

    /**
     * 转换成保留两位小数的百分数,不包含百分符号. 例如: 0.0111 ——> 1.11
     */
    public static String parsePercentWith2DecimalPlaces(float f) {
        if (f >= Float.POSITIVE_INFINITY || f <= Float.NEGATIVE_INFINITY) {
            return "不能表示的浮点数,是被除数为0造成的.";
        }
        float p = round(f, 4) * 100;
        return String.valueOf(p);
    }
}
