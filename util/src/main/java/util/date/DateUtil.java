package util.date;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

    /**
     * :
     */
    private final static String DATE_SEPARATOR_COLON = ":";
    /**
     * -
     */
    private final static String DATE_SEPARATOR_MINUS = "-";

    private final static String DATE_SEPARATOR_SLASH = "/";
    /**
     * ,
     */
    private final static String DATE_SEPARATOR_COMMA = ",";
    /**
     * T
     */
    private final static String DATE_SEPARATOR_T = "T";
    /**
     * +
     */
    private final static String DATE_SEPARATOR_PLUS = "+";
    /**
     * AM
     */
    private final static String DATE_SEPARATOR_AM = "AM";

    /**
     * am
     */
    private final static String DATE_SEPARATOR_AM_LOWER_CASE = "am";

    /**
     * PM
     */
    private final static String DATE_SEPARATOR_PM = "PM";

    /**
     * pm
     */
    private final static String DATE_SEPARATOR_PM_LOWER_CASE = "pm";

    /**
     * .
     */
    private final static String DATE_SEPARATOR_DOT = ".";
    private final static String DATE_SEPARATOR_SPACE = " ";

    /**
     * GMT
     */
    private final static String DATE_SEPARATOR_GMT = "GMT";

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public final static String DATE_FROMAT_STRING1 = "yyyy-MM-dd HH:mm:ss";
    /**
     * MM/dd/yy
     */
    public final static String DATE_FROMAT_STRING2 = "MM/dd/yy";
    /**
     * yyyy-MM-dd
     */
    public final static String DATE_FROMAT_STRING3 = "yyyy-MM-dd";
    /**
     * MMddyy
     */
    public final static String DATE_FROMAT_STRING4 = "MMddyy";
    /**
     * yyMMdd
     */
    public final static String DATE_FROMAT_STRING5 = "yyMMdd";
    /**
     * yyyy-MM-dd-HH
     */
    public final static String DATE_FROMAT_STRING6 = "yyyy-MM-dd-HH";
    /**
     * HHmmssSSS
     */
    public final static String DATE_FROMAT_STRING7 = "HHmmssSSS";
    /**
     * yyyy-MM-ddTHH:mm:ss
     */
    public final static String DATE_FROMAT_STRING8 = "yyyy-MM-ddTHH:mm:ss";
    /**
     * MMM dd, yyyy
     */
    public final static String DATE_FROMAT_STRING9 = "MMM dd, yyyy"; // Feb
    // 09,2014
    /**
     * MM/dd/yyyy
     */
    public final static String DATE_FROMAT_STRING10 = "MM/dd/yyyy";
    /**
     * yyyy-MM-dd'T'HH:mm:ssZZ 2013-01-20T15:30:00+0800
     */
    public final static String DATE_FROMAT_STRING11 = "yyyy-MM-dd'T'HH:mm:ssZZ";

    /**
     * dd/MM/yyyy
     */
    public final static String DATE_FROMAT_STRING12 = "dd/MM/yyyy";
    /**
     * yyyy-MM-dd HH:mm
     */
    public final static String DATE_FROMAT_STRING13 = "yyyy-MM-dd HH:mm";
    /**
     * MM-dd-yyyy
     */
    public final static String DATE_FROMAT_STRING14 = "MM-dd-yyyy";
    /**
     * MM/dd/yyyy HH:mm:ss
     */
    public final static String DATE_FROMAT_STRING15 = "MM/dd/yyyy HH:mm:ss";
    /**
     * yyyyMMdd
     */
    public final static String DATE_FROMAT_STRING16 = "yyyyMMdd";
    /**
     * yyyy-MM-ddTHH
     */
    public final static String DATE_FROMAT_STRING17 = "yyyy-MM-ddTHH";
    /**
     * yyyy-MM-dd HH:mm:ssSSS
     */
    public final static String DATE_FROMAT_STRING18 = "yyyy-MM-dd HH:mm:ssSSS";

    public final static String FROMAT_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
    /**
     * yyyy/MM/dd
     */
    public final static String DATE_FROMAT_STRING19 = "yyyy/MM/dd";
    /**
     * dd/MMM/yyy:HH:mm:ss Z
     */
    public final static String DATE_FROMAT_STRING20 = "dd/MMM/yyy:HH:mm:ss Z"; // 27/Feb/2014:10:19:35
    // +0800
    /**
     * MMM dd,yyyy HH:mm:ss a z Feb 10, 2014 9:29:05 PM PST
     */
    public final static String DATE_FROMAT_STRING21 = "MMM dd,yyyy HH:mm:ss a z";

    /**
     * dd MMM, yyyy HH:mm:ss a z
     */
    public final static String DATE_FROMAT_STRING22 = "dd MMM, yyyy HH:mm:ss a z"; // 20
    // Apr,
    // 2014
    // 9:40:39
    // PM
    // JST
    /**
     * dd-MMM-yy HH:mm:ss a z
     */
    public final static String DATE_FROMAT_STRING23 = "dd-MMM-yy HH:mm:ss a z"; // 17-Apr-14
    // 1:55:53
    // PM
    // PDT
    /**
     * dd MMM yyyy HH:mm:ss z
     */
    public final static String DATE_FROMAT_STRING24 = "dd MMM yyyy HH:mm:ss z"; // 23
    // Apr
    // 2014
    // 02:08:36
    // BDT
    /**
     * MMM dd yyyy HH:mm:ss z
     */
    public final static String DATE_FROMAT_STRING25 = "MMM dd yyyy HH:mm:ss z"; // 23
    // Apr
    // 2014
    // 03:08:36
    // GMT+02:00
    /**
     * dd.MM.yyyy HH:mm:ss z
     */
    public final static String DATE_FROMAT_STRING26 = "dd.MM.yyyy HH:mm:ss z"; // 23.04.2014
    // 03:08:36
    // GMT+02:00

    /**
     * yyyy-MM-dd'T'HH:mm:sszz 2014-07-16T13:56:39+02:00
     */
    public final static String DATE_FROMAT_STRING27 = "yyyy-MM-dd'T'HH:mm:ss Z";

    /**
     * MMM dd, yyyy, HH:mm a Feb 10, 2014 9:29 PM
     */
    public final static String DATE_FROMAT_STRING28 = "MMM dd, yyyy, HH:mm a";

    /**
     * yyyy-MM-dd'T'HH:mm:ss az 2014-04-20T4:29:59 PM+09:00
     */
    public final static String DATE_FROMAT_STRING29 = "yyyy-MM-dd'T'HH:mm:ss aZ";

    public final static DateFormat format_yyyyMMdd_HHmmss = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
    public final static DateFormat format_yyyyMMddHHmmssSSS = new SimpleDateFormat(FROMAT_yyyyMMddHHmmssSSS);
    public final static DateFormat format2 = new SimpleDateFormat("MM/dd/yy");
    public final static DateFormat format_yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
    public final static DateFormat format4 = new SimpleDateFormat("MMddyy");
    public final static DateFormat format5 = new SimpleDateFormat("yyMMdd");
    public final static DateFormat format6 = new SimpleDateFormat(
            "yyyy-MM-dd-HH");
    public final static DateFormat format7 = new SimpleDateFormat("HHmmssSSS");
    public final static DateFormat format8 = new SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss");
    public final static DateFormat format9 = new SimpleDateFormat(
            DATE_FROMAT_STRING9, Locale.ENGLISH);
    public final static DateFormat format10 = new SimpleDateFormat("MM/dd/yyyy");
    /**
     * yyyy-MM-dd'T'HH:mm:ssZZ 2013-01-20T15:30:00+0800
     */
    public final static DateFormat format11 = new SimpleDateFormat(
            DATE_FROMAT_STRING11);
    public final static DateFormat format12 = new SimpleDateFormat("dd/MM/yyyy");
    public final static DateFormat format13 = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm");
    public final static DateFormat format14 = new SimpleDateFormat("MM-dd-yyyy");
    public final static DateFormat format15 = new SimpleDateFormat(
            "MM/dd/yyyy HH:mm:ss");
    public final static DateFormat format16 = new SimpleDateFormat("yyyyMMdd");
    public final static DateFormat format17 = new SimpleDateFormat(
            "yyyy-MM-dd'T'HH");
    public final static DateFormat format18 = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ssSSS");
    public final static DateFormat format19 = new SimpleDateFormat("yyyy/MM/dd");
    public final static DateFormat format20 = new SimpleDateFormat(
            DATE_FROMAT_STRING20, Locale.ENGLISH);
    public final static DateFormat format21 = new SimpleDateFormat(
            DATE_FROMAT_STRING21, Locale.ENGLISH);
    public final static DateFormat format22 = new SimpleDateFormat(
            DATE_FROMAT_STRING22, Locale.ENGLISH);
    public final static DateFormat format23 = new SimpleDateFormat(
            DATE_FROMAT_STRING23, Locale.ENGLISH);
    public final static DateFormat format24 = new SimpleDateFormat(
            DATE_FROMAT_STRING24, Locale.ENGLISH);
    public final static DateFormat format25 = new SimpleDateFormat(
            DATE_FROMAT_STRING25, Locale.ENGLISH);
    public final static DateFormat format26 = new SimpleDateFormat(
            DATE_FROMAT_STRING26, Locale.ENGLISH);

    /**
     * yyyy-MM-dd'T'HH:mm:sszz 2014-07-16T13:56:39+02:00
     */
    public final static DateFormat format27 = new SimpleDateFormat(
            DATE_FROMAT_STRING27);

    /**
     * MMM dd, yyyy, HH:mm a Feb 10, 2014 9:29 PM
     */
    public final static DateFormat format28 = new SimpleDateFormat(
            DATE_FROMAT_STRING28);

    /**
     * yyyy-MM-dd'T'HH:mm:ss az 2014-04-20T4:29:59 PM+09:00
     */
    public final static DateFormat format29 = new SimpleDateFormat(
            DATE_FROMAT_STRING29);

    /*
     * New Year's Day ---元旦----1月1日 Memorial Day ---阵亡将士纪念日---5月的最后一个星期一
     * Independence Day ---独立日---7月4日 Labor Day ---劳动节---9月第一个星期一 Veteran's Day
     * ---退伍军人节---10月的第四星期一 Thanksgiving Day ---感恩节---11月的第四个星期四 Christmas Day
     * ---圣诞节---12月25日
     */
    public final static String[] Holidays = new String[]{"1-1", "5-5-1",
            "7-4", "9-1-1", "10-4-1", "11-4-4", "12-25"};

    /**
     * 将任意格式的String类型的日期转换成Date
     * (目前支持系统中已经定义的所有日期格式)
     * @param dateString 要转换的日期
     * @return
     */
    public static Date transformStringDate(String dateString)
            throws ParseException {

        // 字符串预处理
        if (StringUtils.isBlank(dateString) || "null".equals(dateString)) {
            return parseDateStringToDate(format_yyyyMMdd_HHmmss, "1970-01-01 00:00:00");
        }
        dateString = preproccessDataString(dateString);

        dateString = dateString.trim();
        Date date = null;
        DateFormat dateFormat = null;
        if (isLengthEqualDateFormatStringLength(dateString, DATE_FROMAT_STRING1)
                && dateString.contains(DATE_SEPARATOR_COLON)
                && dateString.contains(DATE_SEPARATOR_MINUS)
                && !dateString.contains(DATE_SEPARATOR_T)) {
            dateFormat = format_yyyyMMdd_HHmmss;
        } else if (isLengthEqualDateFormatStringLength(dateString,
                DATE_FROMAT_STRING2)
                && dateString.contains(DATE_SEPARATOR_SLASH)) {
            dateFormat = format2;
        } else if (isLengthEqualDateFormatStringLength(dateString,
                DATE_FROMAT_STRING3)
                && dateString.contains(DATE_SEPARATOR_MINUS)) {
            // 因为DATE_FROMAT_STRING3和DATE_FROMAT_STRING14无法在外形上做区分，所以只能通过以下方式做语义上的区分
            date = parseDateStringToDate(format14, dateString);
            if (date == null) {
                return parseDateStringToDate(format_yyyyMMdd, dateString);
            }
            int month = transformDateToCalendar(date).get(Calendar.MONTH) + 1;
            if (month == Integer.parseInt(dateString.substring(0, 2))) {
                return date;
            } else {
                date = parseDateStringToDate(format_yyyyMMdd, dateString);
            }
            return date;
        } else if (isLengthEqualDateFormatStringLength(dateString,
                DATE_FROMAT_STRING4)
                && !dateString.contains(DATE_SEPARATOR_COLON)
                && !dateString.contains(DATE_SEPARATOR_MINUS)
                && !dateString.contains(DATE_SEPARATOR_SLASH)) {
            // 因为DATE_FROMAT_STRING4和DATE_FROMAT_STRING5无法在外形上做区分，所以只能通过以下方式做语义上的区分
            date = parseDateStringToDate(format4, dateString);
            int month = transformDateToCalendar(date).get(Calendar.MONTH) + 1;
            if (month == Integer.parseInt(dateString.substring(0, 2))) {
                return date;
            } else {
                date = parseDateStringToDate(format5, dateString);
            }
            return date;
        } else if (isLengthEqualDateFormatStringLength(dateString,
                DATE_FROMAT_STRING6)
                && dateString.contains(DATE_SEPARATOR_MINUS)
                && !dateString.contains(DATE_SEPARATOR_T)) {
            dateFormat = format6;
        } else if ((dateString.length() == DATE_FROMAT_STRING7.length())
                && !dateString.contains(DATE_SEPARATOR_COLON)
                && !dateString.contains(DATE_SEPARATOR_MINUS)
                && !dateString.contains(DATE_SEPARATOR_SLASH)) {
            date = parseDateStringToDate(format7, dateString);
            dateFormat = format7;
        } else if (isLengthEqualDateFormatStringLength(dateString,
                DATE_FROMAT_STRING8)
                && dateString.contains(DATE_SEPARATOR_COLON)
                && dateString.contains(DATE_SEPARATOR_MINUS)
                && dateString.contains(DATE_SEPARATOR_T)) {
            dateFormat = format8;
        } else if (dateString.contains(DATE_SEPARATOR_COMMA)
                && !isContainsAMOrPM(dateString)) {
            date = parseDateStringToDate(format9, dateString);
            int year = transformDateToCalendar(date).get(Calendar.YEAR);
            if (year == Integer.parseInt(dateString.substring(
                    dateString.length() - 4, dateString.length()))) {
                return date;
            }
            dateFormat = format9;
        } else if (isLengthEqualDateFormatStringLength(dateString,
                DATE_FROMAT_STRING10)
                && dateString.contains(DATE_SEPARATOR_SLASH)) {
            // 因为DATE_FROMAT_STRING10(MM/dd/yyyy)、DATE_FROMAT_STRING12(dd/MM/yyyy)
            // 和DATE_FROMAT_STRING19(yyyy/MM/dd)无法在外形上做区分，所以只能通过以下方式做语义上的区分
            date = parseDateStringToDate(format12, dateString);
            int year = transformDateToCalendar(date).get(Calendar.YEAR);
            int month = transformDateToCalendar(date).get(Calendar.MONTH) + 1;
            boolean isDATE_FROMAT_STRING19 = !dateString.substring(0, 4)
                    .contains(DATE_SEPARATOR_SLASH);
            if (isDATE_FROMAT_STRING19
                    && year != Integer.parseInt(dateString.substring(0, 4))) {
                date = parseDateStringToDate(format19, dateString);
            } else {
                int month2 = Integer.parseInt(dateString
                        .split(DATE_SEPARATOR_SLASH)[1]);
                if (month == month2) {
                    return date;
                } else {
                    date = parseDateStringToDate(format10, dateString);
                }
            }
            return date;
        } else if (dateString.contains(DATE_SEPARATOR_COLON)
                && dateString.contains(DATE_SEPARATOR_MINUS)
                && dateString.contains(DATE_SEPARATOR_T)
                && !isContainsAMOrPM(dateString)
                && !isEndWithTimeZoneAbbreviation(dateString)
                && isEndWithTimeZoneOffSetInHour(dateString)) {
            dateString = changePostFixTimeZoneFormate(dateString);
            dateFormat = format11;
        } else if (isLengthEqualDateFormatStringLength(dateString,
                DATE_FROMAT_STRING13)
                && dateString.contains(DATE_SEPARATOR_COLON)
                && dateString.contains(DATE_SEPARATOR_MINUS)) {
            dateFormat = format13;
        } else if (isLengthEqualDateFormatStringLength(dateString,
                DATE_FROMAT_STRING15)
                && dateString.contains(DATE_SEPARATOR_COLON)
                && dateString.contains(DATE_SEPARATOR_SLASH)) {
            dateFormat = format15;
        } else if (isLengthEqualDateFormatStringLength(dateString,
                DATE_FROMAT_STRING16)
                && !dateString.contains(DATE_SEPARATOR_COLON)
                && !dateString.contains(DATE_SEPARATOR_MINUS)
                && !dateString.contains(DATE_SEPARATOR_SLASH)) {
            date = parseDateStringToDate(format16, dateString);
            int year = transformDateToCalendar(date).get(Calendar.YEAR);
            if (year == Integer.parseInt(dateString.substring(0, 4))) {
                return date;
            }
        } else if (isLengthEqualDateFormatStringLength(dateString,
                DATE_FROMAT_STRING17)
                && dateString.contains(DATE_SEPARATOR_MINUS)
                && dateString.contains(DATE_SEPARATOR_T)) {
            dateFormat = format17;
        } else if (isLengthEqualDateFormatStringLength(dateString,
                DATE_FROMAT_STRING18)
                && dateString.contains(DATE_SEPARATOR_COLON)
                && dateString.contains(DATE_SEPARATOR_MINUS)) {
            dateFormat = format18;
        } else if (dateString.contains(DATE_SEPARATOR_COLON)
                && dateString.contains(DATE_SEPARATOR_SLASH)) {
            String flag = dateString.substring(dateString.length() - 5,
                    dateString.length() - 4);
            if (flag.equals(DATE_SEPARATOR_PLUS)) {
                dateFormat = format20;
            }
        } else if (isMatchFormate21Or22(dateString)) {
            date = parseDateStringToDate(format22, dateString);

            if (date == null) {
                return parseDateStringToDate(format21, dateString);
            }

            int day = transformDateToCalendar(date).get(Calendar.DAY_OF_MONTH);
            if (day == Integer
                    .parseInt(dateString.split(DATE_SEPARATOR_SPACE)[0])) {
                return date;
            }
        } else if (isMatchFormate23(dateString)) {
            dateFormat = format23;
        } else if (isMatchFormate24Or25(dateString)) {
            date = parseDateStringToDate(format24, dateString);
            if (date == null) {
                return parseDateStringToDate(format25, dateString);
            }
            int day = transformDateToCalendar(date).get(Calendar.DAY_OF_MONTH);
            if (day == Integer
                    .parseInt(dateString.split(DATE_SEPARATOR_SPACE)[0])) {
                return date;
            }
        } else if (isMatchFormate26(dateString)) {
            dateFormat = format26;
        } else if (isMatchFormate28(dateString)) {
            dateFormat = format28;
        } else if (isMatchFormate29(dateString)) {
            dateFormat = format29;
            dateString = changePostFixTimeZoneFormate(dateString);
        }
        return transformDateStringToDate(dateFormat, dateString);
    }

    /**
     * 对输入的dateString进行预处理
     * @param dateString
     * @return
     */
    private static String preproccessDataString(String dateString) {
        if (dateString.contains("Z")) {
            dateString = dateString.replace("Z", "");
        }
        return dateString;
    }

    /**
     * 判断是否以+XX:XX(或-XX:XX)，+XXXX(或-XXXX)这种以小时为单位的时间偏移量结尾
     * @param dateString
     * @return
     */
    private static boolean isEndWithTimeZoneOffSetInHour(String dateString) {
        if (isEndWithTimeZoneOffSetInHourLen5(dateString)
                || isEndWithTimeZoneOffSetInHourLen6(dateString)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否以+XX:XX(或-XX:XX)这种以小时为单位的时间偏移量结尾
     * @param dateString
     * @return
     */
    private static boolean isEndWithTimeZoneOffSetInHourLen6(String dateString) {
        String postFix = dateString.substring(dateString.length() - 6,
                dateString.length());
        if (postFix.length() == 6
                && (postFix.contains(DATE_SEPARATOR_PLUS) || postFix
                .contains(DATE_SEPARATOR_MINUS))
                && postFix.contains(DATE_SEPARATOR_COLON)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否以+XXXX(或-XXXX)这种以小时为单位的时间偏移量结尾
     * @param dateString
     * @return
     */
    private static boolean isEndWithTimeZoneOffSetInHourLen5(String dateString) {
        String postFix = dateString.substring(dateString.length() - 5,
                dateString.length());
        if (postFix.length() == 5
                && (postFix.contains(DATE_SEPARATOR_PLUS) || postFix
                .contains(DATE_SEPARATOR_MINUS))
                && !postFix.contains(DATE_SEPARATOR_COLON)) {
            return true;
        }
        return false;
    }

    /**
     * 将以+XX:XX(或-XX:XX)形式结尾的暁去掉其中的:替换成+XXXX(或-XXXX)形式,因为SimpleDateFormat中只有+
     * XXXX(或-XXXX)这种形式（用z表示）
     * @param dateString
     * @return
     */
    private static String changePostFixTimeZoneFormate(String dateString) {
        if (isEndWithTimeZoneOffSetInHourLen6(dateString)) {
            String postFix = dateString.substring(dateString.length() - 6,
                    dateString.length());
            postFix = postFix.replace(DATE_SEPARATOR_COLON, "");
            dateString = dateString.substring(0, dateString.length() - 6)
                    + postFix;
        }

        return dateString;
    }

    /**
     * 获取含有时区信息的日期字符串中的以小时表示的时区信息（例如：+0900或-0430）
     * @param dateString
     * @return
     */
    public static String getTimeZoneOffSetInHour(String dateString) {
        if (dateString != null
                && (dateString.contains(DATE_SEPARATOR_T) || dateString
                .contains(DATE_SEPARATOR_GMT))) {
            String postFixLen6 = dateString.substring(dateString.length() - 6,
                    dateString.length());
            String postFixLen5 = dateString.substring(dateString.length() - 5,
                    dateString.length());
            String changedPostFix = changePostFixTimeZoneFormate(postFixLen6);
            if (changedPostFix.length() == 5) {
                return changedPostFix;
            } else if ((postFixLen5.contains(DATE_SEPARATOR_PLUS) || postFixLen5
                    .contains(DATE_SEPARATOR_MINUS))
                    && !postFixLen5.contains(DATE_SEPARATOR_COLON)) {
                return postFixLen5;
            }
        }
        return "";
    }

    /**
     * 获取传入的以小时表示时区信息与标准时区的以毫秒表示的时间差(与标准时间（UTC）的时间差)
     * @param timeZoneOffSetInHour 以小时表示的时区信息
     * @return
     */
    public static long getTimeZoneOffSetInMillisecond(String dateString) {
        String timeZoneOffSetInHour = getTimeZoneOffSetInHour(dateString);
        if (timeZoneOffSetInHour.length() == 5) {
            String flag = timeZoneOffSetInHour.substring(0, 1);
            Integer hour = Integer.parseInt(timeZoneOffSetInHour
                    .substring(1, 3));
            Integer minute = Integer.parseInt(timeZoneOffSetInHour.substring(3,
                    5));
            if (DATE_SEPARATOR_MINUS.equals(flag)) {
                hour = -hour;
                minute = -minute;
            }
            return hour * 60 * 60 * 1000 + minute * 60 * 1000;
        }
        return 0;
    }

    /**
     * 获得输入时间与太平洋标准时间的偏移量（考虑了夏令时问题）
     * @param sourceDate
     * @return
     */
    public static long getPSTTimeZoneOffSetInMillsecond(Calendar sourceDate) {
        TimeZone sourceTimeZone = sourceDate.getTimeZone();
        Date date = sourceDate.getTime();
        long standardOffSet = sourceTimeZone.getRawOffset();
        String timeZoneName = sourceTimeZone.getDisplayName(true,
                TimeZone.SHORT);
        if (TimeZoneUtil.isDaylightTimeInUSA(date)
                && timeZoneName.equalsIgnoreCase(TimeZoneUtil.TIME_ZONE_PDT)) {
            standardOffSet = standardOffSet + (60 * 60 * 1000);
        }

        TimeZone pstTimeZone = TimeZoneUtil.getPSTWithDaylight(date);
        long pstOffSet = pstTimeZone.getRawOffset();
        return standardOffSet - pstOffSet;
    }

    public static String transformToPSTDateString(String dateString)
            throws ParseException {

        Date sourceDateTime = DateUtil.transformStringDate(dateString);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sourceDateTime);

        // 如果输入的时间不是1970-01-01 00:00:00，则对输入的时间进行时区转化处理
        if (sourceDateTime.getTime() > 0) {
            long sourceDateOffSet = DateUtil
                    .getPSTTimeZoneOffSetInMillsecond(calendar);

            sourceDateTime.setTime(sourceDateTime.getTime() - sourceDateOffSet);
        }

        String targetDateTimePST = DateUtil.Format(DateUtil.format_yyyyMMdd_HHmmss,
                sourceDateTime);

        return targetDateTimePST;
    }

    public static Calendar transformDateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static boolean isMatchFormate21Or22(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return false;
        }
        if (isContainsAMOrPM(dateString)
                && isEndWithTimeZoneAbbreviation(dateString)
                && dateString.contains(DATE_SEPARATOR_COLON)
                && dateString.contains(DATE_SEPARATOR_COMMA)
                && !dateString.contains(DATE_SEPARATOR_MINUS)
                && !dateString.contains(DATE_SEPARATOR_DOT)) {
            return true;
        }
        return false;
    }

    /**
     * 是否匹配 MMM dd, yyyy, HH:mm a 例如:Feb 10, 2014 9:29 PM
     * @param dateString
     * @return
     */
    private static boolean isMatchFormate28(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return false;
        }
        if (isLengthEqualDateFormatStringLength(dateString,
                DATE_FROMAT_STRING28)
                && isContainsAMOrPM(dateString)
                && !isEndWithTimeZoneAbbreviation(dateString)
                && dateString.contains(DATE_SEPARATOR_COMMA)
                && dateString.contains(DATE_SEPARATOR_COLON)) {
            return true;
        }
        return false;
    }

    private static boolean isMatchFormate29(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return false;
        }
        if (isContainsAMOrPM(dateString)
                && !isEndWithTimeZoneAbbreviation(dateString)
                && isEndWithTimeZoneOffSetInHour(dateString)
                && dateString.contains(DATE_SEPARATOR_MINUS)
                && dateString.contains(DATE_SEPARATOR_COLON)) {
            return true;
        }
        return false;
    }

    public static boolean isMatchFormate23(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return false;
        }
        if (isContainsAMOrPM(dateString)
                && isEndWithTimeZoneAbbreviation(dateString)
                && dateString.contains(DATE_SEPARATOR_MINUS)
                && !dateString.contains(DATE_SEPARATOR_COMMA)
                && !dateString.contains(DATE_SEPARATOR_DOT)) {
            return true;
        }
        return false;
    }

    public static boolean isMatchFormate24Or25(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return false;
        }
        if (!isContainsAMOrPM(dateString)
                && isEndWithTimeZoneAbbreviation(dateString)
                && !dateString.contains(DATE_SEPARATOR_MINUS)
                && !dateString.contains(DATE_SEPARATOR_COMMA)
                && !dateString.contains(DATE_SEPARATOR_DOT)) {
            return true;
        }
        return false;
    }

    public static boolean isMatchFormate26(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return false;
        }
        if (!isContainsAMOrPM(dateString)
                && isEndWithTimeZoneAbbreviation(dateString)
                && dateString.contains(DATE_SEPARATOR_DOT)
                && !dateString.contains(DATE_SEPARATOR_MINUS)
                && !dateString.contains(DATE_SEPARATOR_COMMA)) {
            return true;
        }
        return false;
    }

    /**
     * 判断输入的日期类型的字符串是否含有‘AM’、'am'或者‘PM’、'pm',如果是小写则去替换成大写
     * @param dateString
     * @return
     */
    private static boolean isContainsAMOrPM(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return false;
        }
        if (dateString.contains(DATE_SEPARATOR_PM_LOWER_CASE)
                || dateString.contains(DATE_SEPARATOR_AM_LOWER_CASE)) {
            dateString.replace(DATE_SEPARATOR_PM_LOWER_CASE, DATE_SEPARATOR_PM);
            dateString.replace(DATE_SEPARATOR_AM_LOWER_CASE, DATE_SEPARATOR_AM);
            return true;
        } else if (dateString.contains(DATE_SEPARATOR_AM)
                || dateString.contains(DATE_SEPARATOR_PM)) {
            return true;
        }
        return false;
    }

    /**
     * 判断输入的日期类型的字符串是否以时区缩写(PST、PDT、BDT等)结尾
     * @param dateString
     * @return
     */
    private static boolean isEndWithTimeZoneAbbreviation(String dateString) {
        if (StringUtils.isEmpty(dateString)
                || !dateString.contains(DATE_SEPARATOR_SPACE)) {
            return false;
        }
        String[] splits = dateString.split(DATE_SEPARATOR_SPACE);
        String endString = splits[splits.length - 1];
        if (endString.contains(DATE_SEPARATOR_T)) {
            return true;
        }
        return false;
    }

    /**
     * 将任意格式的String类型的日期转换成Calendar
     * (目前支持系统中已经定义的所有日期格式)
     * @param dateString 要转换的日期
     * @return
     */
    public static Calendar transformStringDateToCalendar(String dateString)
            throws ParseException {
        Date date = transformStringDate(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 考虑两位的月份和日期只有一位时，比如08月写8,01日写1
     * @param dateFormatString
     * @return
     */
    private static boolean isLengthEqualDateFormatStringLength(
            String inputDateString, String dateFormatString) {
        return (inputDateString.length() == dateFormatString.length()
                || inputDateString.length() == dateFormatString.length() - 1 || inputDateString
                .length() == dateFormatString.length() - 2);
    }

    public static String getIso() {
        return DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(new Date());
    }

    public static TimeZone getCNTimezone() {
        return TimeZone.getTimeZone("Asia/Shanghai");
    }

    public static int getWeek(String time) {
        Date date = null;
        if (time == null) {
            date = new Date();
        } else {
            date = DateUtil.rFormat(DateUtil.format_yyyyMMdd, time);
        }
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK) - 1;
    }

    // 计算给定日期为当年的第几周
    public static String getWeekly(String date) {
        Calendar c = Calendar.getInstance();
        String[] ds = date.split("-");
        int year = Integer.parseInt(ds[0]);
        int month = Integer.parseInt(ds[1]);
        int day = Integer.parseInt(ds[2]);
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);// 在格里高利历和罗马儒略历中一年中的第一个月是 JANUARY，它为
        // 0,所以要减去1
        c.set(Calendar.DAY_OF_MONTH, day);
        String sWeekly = null;
        int iWeekly = c.get(Calendar.WEEK_OF_YEAR);
        // 处理跨年的情况
        Integer[] days = {24, 25, 26, 27, 27, 28, 29, 30, 31};
        if (iWeekly == 1 && month == 12 && ArrayUtils.contains(days, day)) {// 如果12月的最后某一天已经到了第二年的第一周则年份加1
            year = year + 1;
        }
        if (iWeekly < 10) {
            sWeekly = year + "0" + iWeekly;
        } else {
            sWeekly = year + "" + iWeekly + "";
        }
        return sWeekly;
    }

    // 计算给定日期为当年的第几周

    /**
     * @param date
     * @param is_monday 是否以周作为一周的开始，否则以周日为一周的开始
     * @return
     */
    public static String getWeekly(String date, boolean is_monday) {
        // Calendar c = Calendar.getInstance();
        Calendar c = new GregorianCalendar();
        if (is_monday) {// add by weizi 是否需要以星期一作为一周的开始,否则是星期日为一周的开始
            c.setFirstDayOfWeek(Calendar.MONDAY);
        } else {
            c.setFirstDayOfWeek(Calendar.SUNDAY);
        }
        String[] ds = date.split("-");
        int year = Integer.parseInt(ds[0]);
        int month = Integer.parseInt(ds[1]);
        int day = Integer.parseInt(ds[2]);
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);// 在格里高利历和罗马儒略历中一年中的第一个月是 JANUARY，它为
        // 0,所以要减去1
        c.set(Calendar.DAY_OF_MONTH, day);
        String sWeekly = null;
        int iWeekly = c.get(Calendar.WEEK_OF_YEAR);
        // 处理跨年的情况
        Integer[] days = {24, 25, 26, 27, 27, 28, 29, 30, 31};
        if (iWeekly == 1 && month == 12 && ArrayUtils.contains(days, day)) {// 如果12月的最后某一天已经到了第二年的第一周则年份加1
            year = year + 1;
        }
        if (iWeekly < 10) {
            sWeekly = year + "0" + iWeekly;
        } else {
            sWeekly = year + "" + iWeekly + "";
        }
        return sWeekly;
    }

    /**
     * 计算date距今有多少天.不包括周六周末
     */
    public static int getWeekdayInterval(Date date) {
        List<String> holidays = Arrays.asList(Holidays);
        Calendar now = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int d = (int) ((now.getTimeInMillis() - calendar.getTimeInMillis()) / (24 * 60 * 60 * 1000));
        int n = 0;
        for (int i = 0; i < d; i++) {
            calendar.add(Calendar.DATE, 1);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int week = calendar.get(Calendar.WEEK_OF_MONTH);
            int week_day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            if (holidays.contains(month + "-" + day)
                    || holidays.contains(month + "-" + week + "-" + week_day)
                    || week_day == 0 || week_day == 6) {
                n++;
            }
        }
        d = d - n;
        return d;
    }

    /**
     * 计算date距今有多少天.不包括周六周末
     */
    public static int getInterval(Date date) {
        Calendar now = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int d = (int) ((now.getTimeInMillis() - calendar.getTimeInMillis()) / (24 * 60 * 60 * 1000));
        int n = 0;
        for (int i = 0; i < d; i++) {
            calendar.add(Calendar.DATE, 1);
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            if (week == 1 || week == 7) {
                n++;
            }
        }
        d = d - n + 1;
        return d;
    }

    /**
     * 计算date距今有多少天.包括周六周末
     */
    public static int getIntervalIncludeWeekend(Date date) {
        Calendar now = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int d = (int) ((now.getTimeInMillis() - calendar.getTimeInMillis()) / (24 * 60 * 60 * 1000));
        return d;
    }

    /**
     * 计算两个String类型日期的时间间隔
     * @param start_date
     * @param end_date
     * @return
     */
    public static int getInterval(String start_date, String end_date) {
        int d = 0;
        if (start_date != null && end_date != null) {
            Date date1 = getDateFromStr(format_yyyyMMdd, start_date);
            Date date2 = getDateFromStr(format_yyyyMMdd, end_date);
            d = getInterval(date1, date2);
        }
        return d;
    }

    /**
     * 计算2个日期相隔多少天
     */
    public static int getInterval(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return 0;
        }
        int d = 0;
        if (date1.compareTo(date2) < 0) {
            d = Integer.parseInt(DurationFormatUtils.formatPeriod(
                    date1.getTime(), date2.getTime(), "d"));
        } else {
            d = 0 - Integer.parseInt(DurationFormatUtils.formatPeriod(
                    date2.getTime(), date1.getTime(), "d"));
        }
        return d;
    }

    public static long getDelay(int hour, int min) {
        if (hour == -1) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long delay = calendar.getTime().getTime() - new Date().getTime();
        if (delay <= 0) {
            delay = delay + 24 * 60 * 60 * 1000;
        }
        return delay;
    }

    public static XMLGregorianCalendar dateToXml(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        XMLGregorianCalendar sdate = null;
        try {
            sdate = DatatypeFactory.newInstance().newXMLGregorianCalendar();
            sdate.setYear(calendar.get(Calendar.YEAR));
            sdate.setMonth(calendar.get(Calendar.MONTH) + 1);
            sdate.setDay(calendar.get(Calendar.DAY_OF_MONTH));
            sdate.setHour(calendar.get(Calendar.HOUR_OF_DAY));
            sdate.setMinute(calendar.get(Calendar.MINUTE));
            sdate.setSecond(calendar.get(Calendar.SECOND));
            sdate.setTimezone(calendar.get(Calendar.ZONE_OFFSET) / 60000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sdate;
    }

    /**
     * if(null == calendar) return "";
     * if(null == format) default use format_yyyyMMdd_HHmmss
     */
    public static String xmlToDate(XMLGregorianCalendar calendar,
                                   DateFormat format) {
        if (null == calendar) {
            return "";
        }
        if (null == format) {
            format = format_yyyyMMdd_HHmmss;
        }

        return Format(format, calendar.toGregorianCalendar().getTime());
    }

    public static String ToPre(String today) {
        today = today.trim();
        if (today.contains(" ")) {
            return today;
        }
        return today + " 00:00:00";
    }

    public static String ToAft(String today) {
        today = today.trim();
        if (today.contains(" ")) {
            return today;
        }
        return today + " 23:59:59";
    }

    public static String ToSht(String today) {
        today = today.trim();
        if (today.contains(" ")) {
            return today.split(" ")[0];
        }
        return today;
    }

    public static String getISO8601Now() {
        return DateFormatUtils.format(DateUtil.getNow(),
                "yyyy-MM-dd HH:mm:ss ZZ");
    }

    public static String getNow(DateFormat format) {
        return Format(format, Calendar.getInstance().getTime().getTime());
    }

    /**
     * 获取zone和locale的long
     * @param zone
     * @param locale
     * @param preday
     * @return
     */
    public static long getNow(String zone, String locale, int preday) {
        GregorianCalendar ca = new GregorianCalendar(
                TimeZone.getTimeZone(zone), new Locale(locale));
        ca.setTimeInMillis(new Date().getTime() - (long) preday * 24
                * 60 * 60 * 1000);
        return ca.getTime().getTime();
    }

    /**
     * 获取具体format的date的long
     * @param format
     * @param date
     * @return
     */
    public static long getNow(DateFormat format, String date) {
        return parseDateStringToDate(format, date).getTime();
    }

    /**
     * 获取日期
     */
    public static String getLocale(String zone, DateFormat format, int preday) {
        String time = preDay(preday, format);
        return getTimeZone(zone, time, format);
    }

    public static String getNow(String zone, String locale, String format,
                                int preday) {
        GregorianCalendar ca = new GregorianCalendar(
                TimeZone.getTimeZone(zone), new Locale(locale));
        ca.setTimeInMillis(new Date().getTime() - (long) preday * 24
                * 60 * 60 * 1000);
        int month = ca.get(Calendar.MONTH) + 1;
        int date = ca.get(Calendar.DATE);
        int year = ca.get(Calendar.YEAR);
        String dd = (date > 9 ? "" : "0") + date;
        String mm = (month > 9 ? "" : "0") + month;
        String yyyy = "" + year;
        format = format.replace("yyyy", yyyy);
        format = format.replace("MM", mm);
        format = format.replace("dd", dd);
        String d = "" + date;
        String m = "" + month;
        String yy = "" + yyyy.substring(2);
        format = format.replace("yy", yy);
        format = format.replace("M", m);
        format = format.replace("d", d);
        return format;
    }

    public static Date getNow() {
        return Calendar.getInstance().getTime();
    }

    public static int getYear() {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        return ca.get(Calendar.YEAR);
    }

    public static int getYear(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.YEAR);
    }

    public static String getMonth() {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        int month = ca.get(Calendar.MONTH) + 1;
        return "" + ca.get(Calendar.YEAR) + (month > 9 ? month : ("0" + month));
    }

    public static String getMonth(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        int month = ca.get(Calendar.MONTH) + 1;
        return "" + ca.get(Calendar.YEAR) + (month > 9 ? month : ("0" + month));
    }

    public static int getMonthInt() {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        return ca.get(Calendar.MONTH) + 1;
    }

    public static int getMonthInt(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.MONTH) + 1;
    }

    public static int getDayInt() {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        return ca.get(Calendar.DAY_OF_MONTH);
    }

    public static int getDayInt(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.DAY_OF_MONTH);
    }

    public static int getHourInt() {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        return ca.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinuteInt() {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        return ca.get(Calendar.MINUTE);
    }

    public static String preMonth(Date date, int m) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - m);
        return Format(format_yyyyMMdd, calendar.getTime());
    }

    public static String getDate() {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        int day = ca.get(Calendar.DATE);
        return day > 9 ? String.valueOf(day) : ("0" + day);
    }

    public static String getDay() {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        int month = ca.get(Calendar.MONTH) + 1;
        int day = ca.get(Calendar.DATE);
        return ca.get(Calendar.YEAR) + "-"
                + (month > 9 ? month : ("0" + month)) + "-"
                + (day > 9 ? day : ("0" + day));
    }

    public static String toChinaString(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        int month = ca.get(Calendar.MONTH) + 1;
        int day = ca.get(Calendar.DATE);
        return "" + ca.get(Calendar.YEAR) + "年"
                + (month > 9 ? month : ("0" + month)) + "月"
                + (day > 9 ? day : ("0" + day)) + "日";
    }

    public static String aftYears(int n) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH) + 1;
        int day = ca.get(Calendar.DATE);
        return (year + n) + (month < 10 ? "-0" : "-") + month
                + (day < 10 ? "-0" : "-") + day + " 00:00:00";
    }

    public static String aftDays(DateFormat cdf, DateFormat rdf, String date,
                                 int n) {
        try {
            Date da = parseDateStringToDate(cdf, date);
            if (null == da) {
                return null;
            }
            Calendar c = Calendar.getInstance();
            c.clear();
            c.setTime(da);
            c.add(Calendar.DAY_OF_MONTH, n);
            return Format(rdf, c.getTime());
        } catch (Exception e) {
        }
        return null;
    }

    public static String preDay(int n, DateFormat format) {
        Date dateNow = DateUtil.getNow();
        Date datePre = DateUtils.addDays(dateNow, 0 - n);
        return Format(format, datePre);
    }

    public static String preDayWithoutweekend(Date compareDate, int n) {
        Date preDate = compareDate;
        int pred = 0;
        while (Math.abs(n) != pred) {
            Calendar c = Calendar.getInstance();
            c.clear();
            c.setTime(preDate);
            c.add(Calendar.DAY_OF_MONTH, n > 0 ? -1 : 1);
            preDate = c.getTime();
            int week_day = c.get(Calendar.DAY_OF_WEEK) - 1;
            if (week_day == 6 || week_day == 0) {
                continue;
            }
            pred++;
        }
        return Format(DateUtil.format_yyyyMMdd, preDate);
    }

    public static String preDays(int n) {
        Calendar ca = Calendar.getInstance();
        ca.clear();
        ca.setTime(new Date());
        ca.add(Calendar.DAY_OF_MONTH, 0 - n);
        return Format(format_yyyyMMdd, ca.getTime());
    }

    public static String preDays(String time, DateFormat format, int n) {
        Calendar ca = Calendar.getInstance();
        ca.clear();
        ca.setTime(DateUtil.parseDateStringToDate(DateUtil.format_yyyyMMdd, time));
        ca.add(Calendar.DAY_OF_MONTH, 0 - n);
        return Format(format, ca.getTime());
    }

    public static String preDay(Date date, DateFormat format, int n) {
        Calendar ca = Calendar.getInstance();
        ca.clear();
        ca.setTime(date);
        ca.add(Calendar.DAY_OF_MONTH, 0 - n);
        return Format(format, ca.getTime());
    }

    public static String preHour(Date date, DateFormat format, int n) {
        Calendar ca = Calendar.getInstance();
        ca.clear();
        ca.setTime(date);
        ca.add(Calendar.HOUR_OF_DAY, 0 - n);
        return Format(format, ca.getTime());
    }

    public static String preHour(String time, DateFormat format, int n) {
        Calendar ca = Calendar.getInstance();
        ca.clear();
        ca.setTime(DateUtil.parseDateStringToDate(format, time));
        ca.add(Calendar.HOUR_OF_DAY, 0 - n);
        return Format(format, ca.getTime());
    }

    public static String getTimeZone(String timezone, String time,
                                     DateFormat format) {
        try {
            time = time.trim();
            if (time.endsWith(":00")) {
                time = time.substring(0, time.length() - 3) + "00";
            }
            Date date = parseDateStringToDate(format, time);
            Calendar ca = Calendar.getInstance();
            ca.clear();
            ca.setTimeInMillis(date.getTime());
            format.setTimeZone(TimeZone.getTimeZone(timezone));
            time = Format(format, ca.getTime());
            format.setTimeZone(TimeZone.getDefault());
        } catch (Exception e) {
        }
        return time;
    }

    public static String preHours(int hour, DateFormat format) {
        if (format == null) {
            format = format_yyyyMMdd;
        }
        Calendar ca = Calendar.getInstance();
        ca.clear();
        ca.setTimeInMillis(new Date().getTime() - (long) hour * 60
                * 60 * 1000);
        return Format(format, ca.getTime());
    }

    /**
     * 以当前日期为基准往前往后跳跃几天
     */
    public static String skipDays(int n) {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DAY_OF_MONTH, n);
        return Format(format_yyyyMMdd, ca.getTime());
    }

    public static String aftMins(int n) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH) + 1;
        int day = ca.get(Calendar.DATE);
        int hour = ca.get(Calendar.HOUR_OF_DAY);
        int min = ca.get(Calendar.MINUTE) + n;
        int sec = ca.get(Calendar.SECOND);
        return year + (month < 10 ? "-0" : "-") + month
                + (day < 10 ? "-0" : "-") + day + " " + (hour < 10 ? "0" : "")
                + hour + ":" + (min < 10 ? "0" : "") + min + ":"
                + (sec < 10 ? "0" : "") + sec;
    }

    public static String Hours() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        return year + "-" + (month < 10 ? "0" : "") + month + "-"
                + (date < 10 ? "0" : "") + date + "-" + (hour < 10 ? "0" : "")
                + hour;
    }

    public final static String[][] MONTHS = new String[][]{
            {"01", "Jan", "January", "Januar", "Gennaio", "Janvier", "janv",
                    "Enero"},
            {"02", "Feb", "February", "Februar", "Febbraio", "Février",
                    "févr", "Febrero"},
            {"03", "Mar", "March", "März", "Marzo", "Mars", "marzo"},
            {"04", "Apr", "April", "April", "Aprile", "Avril", "avr", "abril"},
            {"05", "May", "May", "Mai", "Maggio", "Mai", "mayo"},
            {"06", "Jun", "June", "Juni", "Giugno", "Juin", "junio"},
            {"07", "Jul", "July", "Juli", "Luglio", "Juillet", "juil", "julio"},
            {"08", "Aug", "August", "August", "Agosto", "Août", "agosto"},
            {"09", "Sep", "September", "September", "Settembre", "Septembre",
                    "septiembre"},
            {"10", "Oct", "October", "Oktober", "Ottobre", "Octobre",
                    "octubre"},
            {"11", "Nov", "November", "November", "Novembre", "Novembre",
                    "noviembre"},
            {"12", "Dec", "December", "Dezember", "Dicembre", "Décembre",
                    "déc", "diciembre"}};

    public static String TransferMonth(String month) {
        if (null == month) {
            return null;
        }
        for (String[] m : MONTHS) {
            for (int i = 1; i < m.length; i++) {
                if (month.equalsIgnoreCase(m[i])) {
                    return m[0];
                }
            }
        }
        return null;
    }

    /**
     * 转换
     * @param time
     * @return
     */
    public static String Format(DateFormat format, Timestamp time) {
        synchronized (format) {
            String t = "";
            try {
                t = format.format(time);
            } catch (Exception e) {
                return t;
            }
            return t;
        }
    }

    public static String Format(DateFormat format, Date time) {
        synchronized (format) {
            String t = "";
            try {
                t = format.format(time).replace("24:", "00:");
            } catch (Exception e) {
                return t;
            }
            return t;
        }
    }

    public static String Format(DateFormat format, long time) {
        synchronized (format) {
            String t = "";
            try {
                t = format.format(time);
            } catch (Exception e) {
                return t;
            }
            return t;
        }
    }

    public static String DFormat(Date time) {
        String t = "";
        try {
            t = Format(format_yyyyMMdd_HHmmss, time).split(" ")[0];
        } catch (Exception e) {
            return t;
        }
        return t;
    }

    /**
     * 逆转换
     * @param format
     * @param time
     * @return
     */
    public static Date rFormat(DateFormat format, String time) {
        if (time == null || time.trim().equals("")) {
            return null;
        }
        if (time.indexOf(" ") == -1) {
            time += " 00:00:00";
        }
        String[] ts = StringUtils.split(time, "-");
        if (ts[1].length() == 1) {
            ts[1] = "0" + ts[1];
        }
        String[] ds = StringUtils.split(ts[2], " ");
        if (ds[0].length() == 1) {
            ds[0] = "0" + ds[0];
        }
        String[] ms = StringUtils.split(ds[1], ":");
        if (ms[0].length() == 1) {
            ms[0] = "0" + ms[0];
        }
        if (ms[1].length() == 1) {
            ms[1] = "0" + ms[1];
        }
        if (ms[2].length() == 1) {
            ms[2] = "0" + ms[2];
        }
        time = ts[0] + "-" + ts[1] + "-" + ds[0] + " " + ms[0] + ":" + ms[1]
                + ":" + ms[2];
        Date date = parseDateStringToDate(format, time.substring(0, 19));
        return date;
    }

    /**
     * 将指定格式的String类型的日期转换成Date
     * @param format     要转换的格式，应该与要转换的日期格式对应
     * @param dateString 要转换的日期
     * @return
     */
    public static Date parseDateStringToDate(DateFormat format,
                                             String dateString) {
        if (format != null) {
            synchronized (format) {
                try {
                    return format.parse(dateString);
                } catch (ParseException e) {
                    return null;
                }
            }
        } else {
//			String message = "format is null,the dataString is " + dateString;
            return null;
        }

    }

    public static int getWeekOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    public static int getMaxWeekNumOfYear(int year) {
        Calendar c = new GregorianCalendar();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        return getWeekOfYear(c.getTime());
    }

    public static Date transformDateStringToDate(DateFormat format,
                                                 String dateString) throws ParseException {
        if (format != null) {
            synchronized (format) {
                try {
                    return format.parse(dateString);
                } catch (ParseException e) {
                    throw e;
                }
            }
        } else {
            // 如果出现异常则把无法解析的dateString记录下来，作为异常的信息抛出
            String message = "format is null,the dataString is " + dateString;
            throw new ParseException(message, 1);
        }

    }

    /**
     * 将指定格式的String类型的日期转换成Date
     * @param format     要转换的格式，应该与要转换的日期格式对应
     * @param dateString 要转换的日期
     * @return
     */
    public static Date parseDateStringToDate(DateFormat format, String time,
                                             TimeZone timeZone) {
        synchronized (format) {
            try {
                format.setTimeZone(timeZone);
                return format.parse(time);
            } catch (ParseException e) {
                return null;
            }
        }
    }

    public static String transferDate(String date, String format,
                                      DateFormat tformat) {
        try {
            return Format(tformat, new SimpleDateFormat(format).parse(date));
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 根据输入的日期，来获取此日期所在周的开始日期，截止日期
     * @param date
     * @param isFirst
     * @param isMonday
     * @return
     */
    public static String getDayOfWeek(String date, boolean isFirst,
                                      boolean isMonday) {
        Calendar calFirst = Calendar.getInstance();
        Date dd = getDateFromStr(format_yyyyMMdd, date);
        calFirst.setTime(dd);
        Date firstDate = getFirstDayOfWeek(calFirst.getTime(), isMonday);
        return isFirst ? Format(format_yyyyMMdd, firstDate) : preDays(
                Format(format_yyyyMMdd, firstDate), format_yyyyMMdd, -6);
    }

    /**
     * 计算一年中某周的第一天和最后一天
     * @param year
     * @param week
     * @param first
     * @return
     */
    public static String getDayOfWeek(int year, int week, boolean isFirst) {
        return getDayOfWeek(year, week, isFirst, true);
    }

    /**
     * 计算一年中某周的第一天和最后一天<br>
     * 扩展:可以设置周的起始日期<br>
     * @param year
     * @param week
     * @param isFirst true为求出入周的开始日期，false为求last日期
     * @param m       日期是否是以星期一开始,否的话,默认为星期日为一周的开始日期<br>
     * @return isMonday
     */
    public static String getDayOfWeek(int year, int week, boolean isFirst,
                                      boolean isMonday) {
        Calendar calFirst = Calendar.getInstance();
        calFirst.set(year, 0, 7);// 设置为 ：year-0月-7号
        Date firstDate = getFirstDayOfWeek(calFirst.getTime(), isMonday);
        Calendar firstDateCal = Calendar.getInstance();
        firstDateCal.setTime(firstDate);
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, firstDateCal.get(Calendar.DATE));
        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, (week - 1) * 7);
        firstDate = getFirstDayOfWeek(cal.getTime(), isMonday);
        return isFirst ? Format(format_yyyyMMdd, firstDate) : aftDays(6,
                Format(format_yyyyMMdd, firstDate));
    }

    private static Date getFirstDayOfWeek(Date date, boolean monday) {
        Calendar c = new GregorianCalendar();
        if (monday) {// add by weizi 是否需要以星期一作为一周的开始,否则是星期日为一周的开始
            c.setFirstDayOfWeek(Calendar.MONDAY);
        }
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        return c.getTime();
    }

    /**
     * 拿到当月第一天
     * add by troy 13.08.01
     */
    public static String getFirstDayOfMonth(String time, DateFormat format) {
        Calendar c = new GregorianCalendar();
        c.setTime(DateUtil.rFormat(format, time));
        c.set(Calendar.DAY_OF_MONTH, 1);
        return Format(format, c.getTime());
    }

    /**
     * 拿到当月最后一天
     * add by troy 13.08.01
     */
    public static String getLastDayOfMonth(String time, DateFormat format) {
        Calendar c = new GregorianCalendar();
        c.setTime(DateUtil.rFormat(format, time));
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DAY_OF_MONTH, -1);
        return Format(format, c.getTime());
    }

    /**
     * 从固定时间往后推n天
     * @param n
     * @param time
     * @return
     */
    public static String aftDays(int n, String time) {
        Date date = rFormat(DateUtil.format_yyyyMMdd, time);
        Date dateAfter = DateUtils.addDays(date, n);
        return Format(format_yyyyMMdd, dateAfter);
    }

    /**
     * 从固定时间往后推n天
     * @param n
     * @param time
     * @return
     */
    public static Date aftDays(int n, Date date) {
        // Calendar ca = Calendar.getInstance();
        // ca.clear();
        // ca.setTimeInMillis(date.getTime() + (long) n * 24 * 60 * 60 * 1000);
        // return new Date(ca.getTime().getTime());
        // 以上代码可能会因为夏令时和物冬令时的切换造成：用带00:00:00格式的日期进行换算时在夏令时会多出一天来.
        // 比如： Date date1=DateUtil.getDateFromStr(DateUtil.format_yyyyMMdd,
        // "2014-03-15"); Date date11= DateUtil.aftDays(-7,date1);
        // 的输出结果是2014-03-07,而不是2014-03-08,所有替换成使用org.apache.commons.lang.time.DateUtils进行转换
        return DateUtils.addDays(date, n);
    }

    /**
     * 拿到当月最后一天
     * add by troy 13.08.01
     */
    public static String aftMonths(String time, DateFormat format, int m) {
        Calendar c = new GregorianCalendar();
        c.setTime(DateUtil.rFormat(format, time));
        c.add(Calendar.MONTH, m);
        return Format(format, c.getTime());
    }

    /**
     * 返回当前时间min分钟前的时间
     * @param min
     * @return
     */
    public static String preMins(int min) {
        return preMins(format8, min);
    }

    /**
     * 返回当前时间min分钟前的时间
     * @param min
     * @return
     */
    public static String preMins(DateFormat format, int min) {
        Calendar ca = Calendar.getInstance();
        ca.clear();
        ca.setTimeInMillis(new Date().getTime() - (long) min * 60
                * 1000);
        return Format(format, ca.getTime());
    }

    /**
     * 将字符串转换为Date
     * @param format
     * @param s
     * @return
     */
    public static Date getDateFromStr(DateFormat format, String s) {
        if (s == null || s.trim().equals("")) {
            return null;
        }
        if (format == null) {
            if (s.length() == 10) {
                format = format_yyyyMMdd;
            } else if (s.length() == 16) {
                format = format13;
            } else {
                format = format_yyyyMMdd_HHmmss;
            }
        }
        return parseDateStringToDate(format, s);
    }

    /**
     * 获取当前月份上一个月的天数
     * @return
     */
    public static int getDaysOfPreMonth() {
        // 取得系统当前时间
        Calendar cal = Calendar.getInstance();
        // 取得系统当前时间所在月第一天时间对象
        cal.set(Calendar.DAY_OF_MONTH, 1);
        // 日期减一,取得上月最后一天时间对象
        cal.add(Calendar.DAY_OF_MONTH, -1);
        // 输出上月最后一天日期
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 月所属季
     */
    public static int getSeasonInt(int month) {
        return (month - 1) / 3 + 1;
    }

    /**
     * 当前年月的最后一天,以整数形式返回
     */
    public static int getLastDayOfMonthInInt(int year, int month) {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.YEAR, year);
        ca.set(Calendar.MONTH, month - 1);
        ca.set(Calendar.DATE, 1);
        ca.roll(Calendar.DATE, -1);
        return ca.get(Calendar.DATE);
    }

    /**
     * 30 Aug 20131:37
     * Monday, July 2, 2012
     * August 22, 2012
     * 注:必须保证月份是英文的,年份是四位
     * @param edate
     * @return
     */
    public static String date_format(String edate) {
        edate = edate.replaceAll(",", " ").replaceAll("-", " ")
                .replace(".", " ").replaceAll(" +", " ");
        String[] dates = edate.split(" ");
        String year = null;
        String month = null;
        String day = null;
        for (String date : dates) {
            if (date.matches("^20\\d{2,}[\\s\\S]*")) {
                year = date.substring(0, 4);
            } else if (date.matches("[A-Za-z]+$")
                    && 0 == Integer.parseInt(month)) {
                month = DateUtil.TransferMonth(date);
            } else if (date.matches("^\\d{1,2}")) {
                day = date;
            }
        }
        if (StringUtils.isNotBlank(day) && day.length() == 1) {
            day = "0" + day;
        }
        return year + "-" + month + "-" + day;
    }

    /**
     * 将字符串转换为java.sql.Date
     * @param format
     * @param s
     * @return
     */
    public static java.sql.Date getSqlDateFromStr(DateFormat format, String s,
                                                  boolean need_default) {
        Date utilDate = getDateFromStr(format, s);
        return utilDate_to_sqlDate(utilDate, need_default);
    }

    public static java.sql.Date utilDate_to_sqlDate(Date utilDate,
                                                    boolean need_default) {
        if (utilDate == null) {
            if (need_default) {
                return new java.sql.Date(0);// 1970-01-01
            }
            return null;
        }
        return new java.sql.Date(utilDate.getTime());
    }

    public static Date getFirstDateOfSeason(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(date.getTime());
        int month = ca.get(Calendar.MONTH);
        month = month - month % 3;
        ca.set(Calendar.MONTH, month);
        ca.set(Calendar.DATE, 1);
        return ca.getTime();
    }

    public static Date getLastDateOfSeason(Date date) {
        Date d = getFirstDateOfSeason(date);
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(d.getTime());
        int month = ca.get(Calendar.MONTH);
        ca.set(Calendar.MONTH, month + 3);
        ca.add(Calendar.DAY_OF_MONTH, -1);
        // ca.setTimeInMillis(ca.getTimeInMillis()-(long)24*60*60*1000);
        return ca.getTime();
    }

    public static int getTotalDaysOfSeason(Date date) {
        Date df = getFirstDateOfSeason(date);
        Date dl = getLastDateOfSeason(date);
        return getInterval(df, dl) + 1;

    }

    public static Date getFirstDateOfWeek(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(date.getTime());
        ca.setFirstDayOfWeek(Calendar.SUNDAY);
        ca.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return ca.getTime();
    }

    public static Date getLastDateOfWeek(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(date.getTime());
        ca.setFirstDayOfWeek(Calendar.SUNDAY);
        ca.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        return ca.getTime();
    }

    public static int getSeasonByDate(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(date.getTime());
        int month = ca.get(Calendar.MONTH);
        return month / 3 + 1;
    }

    public static String[] firstAndLastDateOfWeek(int year, int week) {
        String date[] = new String[2];
        Calendar ca = Calendar.getInstance();
        ca.setFirstDayOfWeek(Calendar.SATURDAY);
        ca.set(Calendar.YEAR, year);
        ca.set(Calendar.WEEK_OF_YEAR, week);
        ca.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        date[0] = DateUtil.Format(DateUtil.format_yyyyMMdd, ca.getTime());
        ca.set(Calendar.DATE, ca.get(Calendar.DATE) + 6);
        date[1] = DateUtil.Format(DateUtil.format_yyyyMMdd, ca.getTime());
        return date;
    }

    /**
     * 获取当前日期是一年中的第几周，以周日为一周的开始
     * @param date
     * @return 返回格式为yyyy-xx,比如2014-3,2014-23
     */
    public static String getWeekOfYear(String date) {
        Date d = DateUtil.getDateFromStr(DateUtil.format_yyyyMMdd, date);
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(d.getTime());
        int month = ca.get(Calendar.MONTH);
        int year = ca.get(Calendar.YEAR);
        ca.setFirstDayOfWeek(Calendar.SUNDAY);
//		ca.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        int week = ca.get(Calendar.WEEK_OF_YEAR);

        if (week == 1 && month == 11) {// 如果12月的最后某一天已经到了第二年的第一周则年份加1
            year = year + 1;
        }
        return String.valueOf(year) + "-" + String.valueOf(week);

    }

    public static List<String> getDateWeekInterval(String beginDate,
                                                   String endDate, int week) throws ParseException {
        List<String> dates = new ArrayList<String>();
        dates.add(beginDate);
        for (int i = 0; i < 100; i++) {
            beginDate = DateUtil.aftDays(7 * week, beginDate);
            boolean isBefore = beginDate.equals(endDate)
                    || DateUtil.parseDateStringToDate(DateUtil.format_yyyyMMdd,
                    beginDate).before(
                    parseDateStringToDate(format_yyyyMMdd, endDate));
            if (isBefore) {
                dates.add(beginDate);
            } else {
                break;
            }
        }
        return dates;
    }

    public static List<String> splitByDay(String sdate, String edate) {
        List<String> days = new ArrayList<String>();
        for (int i = 0; DateUtil.preDays(sdate, format_yyyyMMdd, i).compareTo(edate) <= 0; i--) {
            days.add(DateUtil.preDays(sdate, format_yyyyMMdd, i));
        }
        return days;
    }

    /**
     * 以String形式返回指定年、月的第二个星期日的日期
     * @param year
     * @param month
     * @return
     */
    public static String getSecondSundayOfMonthInString(int year, int month) {
        Calendar cal = getSecondSundayOfMonth(year, month);
        return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1)
                + "-" + cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定年月的第二个星期日的日期
     * @param year
     * @param month
     * @return
     */
    public static Calendar getSecondSundayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1, 0, 0, 0);// 日期设置为月份的第1天
        // 如果weekDay =1 是周日
        int weekDay = cal.get(Calendar.DAY_OF_WEEK);
        int sunDay = Calendar.SUNDAY;
        int sumDay = 0;
        if (weekDay == sunDay) {
            sumDay = 7;
        } else {
            sumDay = (7 - weekDay + sunDay) + 7;
        }
        cal.add(Calendar.DAY_OF_MONTH, sumDay);
        return cal;
    }

    /**
     * 获取指定年月的第二个星期日的日期
     * @param year
     * @param month
     * @return
     */
    public static Calendar getFirstSundayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1, 23, 59, 59);// 日期设置为今年的5月1日
        // 如果weekDay =1 是周日
        int weekDay = cal.get(Calendar.DAY_OF_WEEK);
        int sunDay = Calendar.SUNDAY;
        int sumDay = 0;
        if (weekDay == sunDay) {
            sumDay = 0;
        } else {
            sumDay = (7 - weekDay + sunDay);
        }
        cal.add(Calendar.DAY_OF_MONTH, sumDay);
        return cal;
    }

    public static String getFirstSundayOfMonthInString(int year, int month) {
        Calendar cal = getFirstSundayOfMonth(year, month);
        return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1)
                + "-" + cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取季度开始时间
     * @param quarter
     * @return 格式为MM-dd类型的日期
     */
    public static String getQuarterStartDate(int quarter) {
        String date = null;
        switch (quarter) {
            case 1:
                date = "01-01";
                break;
            case 2:
                date = "04-01";
                break;
            case 3:
                date = "07-01";
                break;
            case 4:
                date = "10-01";
                break;
        }
        return date;
    }

    /**
     * 获取季度开始时间
     * @param quarter
     * @return 格式为MM-dd类型的日期
     */
    public static String getQuarterEndDate(int quarter) {
        String date = null;
        switch (quarter) {
            case 1:
                date = "03-31";
                break;
            case 2:
                date = "06-30";
                break;
            case 3:
                date = "09-30";
                break;
            case 4:
                date = "12-31";
                break;
        }
        return date;
    }

    /**
     * get first date of given month and year
     * @param year
     * @param month
     * @return
     */
    public String getFirstDayOfMonth(int year, int month) {
        String monthStr = month < 10 ? "0" + month : String.valueOf(month);
        return year + "-" + monthStr + "-" + "01";
    }

    /**
     * get the last date of given month and year
     * @param year
     * @param month
     * @return
     */
    public String getLastDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return calendar.get(Calendar.YEAR) + "-"
                + (calendar.get(Calendar.MONTH) + 1) + "-"
                + calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * get Calendar of given year
     * @param year
     * @return
     */
    private static Calendar getCalendarFormYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        return cal;
    }

    /**
     * get start date of given week no of a year,the first day of week is Sunday
     * @param year
     * @param weekNo
     * @return
     */
    public static String getStartDayByWeekOfYear(int year, int weekNo) {
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        int monthInt = cal.get(Calendar.MONTH) + 1;
        String monthString = monthInt < 10 ? "0" + monthInt : monthInt + "";
        int dayOfMontyInt = cal.get(Calendar.DAY_OF_MONTH);
        String dayOfMonth = dayOfMontyInt < 10 ? "0" + dayOfMontyInt
                : dayOfMontyInt + "";
        return cal.get(Calendar.YEAR) + "-" + monthString + "-" + dayOfMonth;

    }

    /**
     * get the end day of given week no of a year.,the first day of week is Sunday
     * @param year
     * @param weekNo
     * @return
     */
    public static String getEndDayByWeekOfYear(int year, int weekNo) {
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.add(Calendar.DAY_OF_WEEK, 6);
        int monthInt = cal.get(Calendar.MONTH) + 1;
        String monthString = monthInt < 10 ? "0" + monthInt : monthInt + "";
        int dayOfMontyInt = cal.get(Calendar.DAY_OF_MONTH);
        String dayOfMonth = dayOfMontyInt < 10 ? "0" + dayOfMontyInt
                : dayOfMontyInt + "";
        return cal.get(Calendar.YEAR) + "-" + monthString + "-" + dayOfMonth;
    }

    public static String getYearAndMonth(String time) {
        if (StringUtils.isNotBlank(time) && time.length() >= 7) {
            return time.substring(0, 7);
        }
        return "";
    }
}