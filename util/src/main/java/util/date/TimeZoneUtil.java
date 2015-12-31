package util.date;

import java.text.ParseException;
import java.util.*;

/**
 * 时区帮助类
 */
public class TimeZoneUtil {

    public static final String TIME_ZONE_CHINA = "Asia/Shanghai";
    public static final String TIME_ZONE_AMERICA_NEWYORK = "America/New_York";
    public static final String TIME_ZONE_AMERICA_LOS_ANGELES = "America/Los_Angeles";
    public static final String TIME_ZONE_JAPAN = "Asia/Tokyo";
    public static final String TIME_ZONE_GEMANY = "Europe/Berlin";
    public static final String TIME_ZONE_FRANCE = "Europe/Pairs";
    public static final String TIME_ZONE_ITALY = "Europe/Rome";
    public static final String TIME_ZONE_CANADA_VANCOUVERV = "America/Vancouver";
    public static final String TIME_ZONE_CANADA_TORONTO = "America/Toronto";
    public static final String TIME_ZONE_CANADA_MONTREAL = "America/Montreal";

    /**
     * 免费TimeZoneAPI，地址:http://www.worldweatheronline.com/time-zone-api.aspx
     */
    public static final String TIME_ZONE_FREE_API_PREFIX = "http://api.worldweatheronline.com/free/v1/tz.ashx?";
    public static String TIME_ZONE_FREE_API_KEY = "046e81b16ed7a488468e78ad000d452d49fa36e3";


    /**
     * 东部标准时间
     */

    public static final String TIME_ZONE_EST = "EST";
    /**
     * 中央标准时间
     */
    public static final String TIME_ZONE_CST = "CST";
    /**
     * 太平洋标准时间（冬令时）Pacific Standard Time
     */
    public static final String TIME_ZONE_PST = "PST";

    /**
     * 太平洋标准时间（夏令时）Pacific Daylight Time
     */
    public static final String TIME_ZONE_PDT = "PDT";

    /**
     * 世界协调时间
     */
    public static final String TIME_ZONE_UTC = "UTC";

    /**
     * 格林威治时间
     */
    public static final String TIME_ZONE_GMT = "GMT";

    /**
     * 夏威夷-阿留申标准时区
     */
    public static final String TIME_ZONE_HST = "HST";

    /**
     * 山地标准时区
     */
    public static final String TIME_ZONE_MST = "MST";

    public static Map<String, String> timeZoneMap = null;

    /**
     * 美国的州与该州所在时区对应关系
     */
    public static Map<String, TimeZone> usaStateTimeZoneMap = null;

    static {
        timeZoneMap = getTimeZoneMap();// 因为该方法每次返回的结果都一样，所以放在一个静态变量中
    }

    /**
     * 获取中国时区，即中国标准时间
     * @return
     */
    public static TimeZone getChinaTimeZone() {
        return TimeZone.getTimeZone(TIME_ZONE_CHINA);
    }


    /**
     * 获取日本时区，即日本标准时间
     * @return
     */
    public static TimeZone getJapanTimeZone() {
        return TimeZone.getTimeZone(TIME_ZONE_JAPAN);
    }

    /**
     * 获取美国纽约时区，即东部标准时间
     * @return
     */
    public static TimeZone getAmericaNewYorkTimeZone() {
        return TimeZone.getTimeZone(TIME_ZONE_AMERICA_NEWYORK);
    }

    /**
     * 获取美国洛杉矶时区，即太平洋标准时间
     * @return
     */
    public static TimeZone getAmericaLosAngelesTimeZone() {
        return TimeZone.getTimeZone(TIME_ZONE_AMERICA_LOS_ANGELES);
    }

    /**
     * 获取太平洋标准时间
     * @return
     */
    public static TimeZone getPST() {
        return TimeZone.getTimeZone(TIME_ZONE_PST);
    }

    /**
     * 获取当前日期的太平洋标准时间，区分夏令时和冬令时
     * @return
     */
    public static TimeZone getPSTWithDaylight() {
        if (isDaylightTimeInUSA()) {
            return TimeZone.getTimeZone(TIME_ZONE_GMT + "-0700");
        } else {
            return TimeZone.getTimeZone(TIME_ZONE_PST);
        }
    }

    /**
     * 获取指定日期的太平洋标准时间，区分夏令时和冬令时
     * @return
     */
    public static TimeZone getPSTWithDaylight(Date date) {
        if (isDaylightTimeInUSA(date)) {
            return TimeZone.getTimeZone(TIME_ZONE_GMT + "-0700");
        } else {
            return TimeZone.getTimeZone(TIME_ZONE_PST);
        }
    }

    /**
     * 获取东部标准时间
     * @return
     */
    public static TimeZone getEST() {
        return TimeZone.getTimeZone(TIME_ZONE_EST);
    }

    /**
     * 获取中央标准时间
     * @return
     */
    public static TimeZone getCST() {
        return TimeZone.getTimeZone(TIME_ZONE_CST);
    }

    /**
     * 获取夏威夷-阿留申标准时区
     * @return
     */
    public static TimeZone getHST() {
        return TimeZone.getTimeZone(TIME_ZONE_HST);
    }

    /**
     * 获取山地标准时区
     * @return
     */
    public static TimeZone getMST() {
        return TimeZone.getTimeZone(TIME_ZONE_MST);
    }

    /**
     * 获取加拿大温哥华时区，即太平洋标准时间
     * @return
     */
    public static TimeZone getCanadaVancouverTimeZone() {
        return TimeZone.getTimeZone(TIME_ZONE_CANADA_VANCOUVERV);
    }

    /**
     * 获取加拿大多伦多时区，即东部标准时间
     * @return
     */
    public static TimeZone getCanadaTorontoTimeZone() {
        return TimeZone.getTimeZone(TIME_ZONE_CANADA_TORONTO);
    }

    /**
     * 获取加拿大蒙特利尔时区，即东部标准时间
     * @return
     */
    public static TimeZone getCanadaMontrealTimeZone() {
        return TimeZone.getTimeZone(TIME_ZONE_CANADA_MONTREAL);
    }

    /**
     * 获取德国时区，即中欧时间
     * @return
     */
    public static TimeZone getGermanyTimeZone() {
        return TimeZone.getTimeZone(TIME_ZONE_GEMANY);
    }

    /**
     * 获取法国时区，即中欧时间
     * @return
     */
    public static TimeZone getFranceTimeZone() {
        return TimeZone.getTimeZone(TIME_ZONE_FRANCE);
    }

    /**
     * 获取意大利时区，即中欧时间
     * @return
     */
    public static TimeZone getItalyTimeZone() {
        return TimeZone.getTimeZone(TIME_ZONE_ITALY);
    }

    /**
     * 获取世界标准时间
     * @return
     */
    public static TimeZone getWorldStandardTimeZone() {
        return getUTC();
    }

    /**
     * 获取协调世界时间
     * @return
     */
    public static TimeZone getUTC() {
        return TimeZone.getTimeZone(TIME_ZONE_UTC);
    }

    /**
     * 获取格林威治时间<br>
     * <p/>
     * GMT（格林尼治标准时间）是指位于伦敦郊区的皇家格林尼治天文台的标准时间，因为本初子午线被定义在通过那里的经线。
     * 理论上来说，格林尼治标准时间的正午是指当太阳横穿格林尼治子午线时的时间。由于地球在它的椭圆轨道里的运动速度不均匀，
     * 这个时刻可能和实际的太阳时相差16分钟。 地球每天的自转是有些不规则的，而且正在缓慢减速。所以，格林尼治时间已经
     * 不再被作为标准时间使用。现在的标准时间——协调世界时（UTC）——由原子钟提供。
     * 自1924年2月5日开始，格林尼治天文台每隔一小时会向全世界发放调时信息
     * @return
     */
    public static TimeZone getGMT() {
        return TimeZone.getTimeZone(TIME_ZONE_GMT);
    }

    /**
     * 获取本地时区，这个时区由代码运行环境机器设置的默认时区决定
     * @return
     */
    public static TimeZone getLocalTimeZone() {
        return TimeZone.getDefault();
    }

    /**
     * 获取受支持的所有可用 ID
     * 用来作为页面显示的时区下拉列表
     * 以绝对时区显示（不考虑夏令时）
     * @return map 存储时区列表+偏移量的map(可用来显示如Hongkong,TIME_ZONE_GMT+08:00)
     * 实际使用时，传给服务器是零时区，值传递时区id就可以了，不传递偏移量
     */
    public static Map<String, String> getTimeZoneMap() {

        if (timeZoneMap != null) {
            return timeZoneMap;
        }

        String[] zoneIds = TimeZone.getAvailableIDs();
        int length = zoneIds.length;
        TimeZone timeZone = null;
        // 存储时区列表+偏移量到map中
        Map<String, String> map = new HashMap<String, String>(650);
        long offset = 0L;
        String diplayOffset = "";
        for (int i = 0; i < length; i++) {
            // 获取给定 ID 的 TimeZone
            timeZone = TimeZone.getTimeZone(zoneIds[i]);
            // 返回添加到 UTC 以获取此时区与标准时间的时间偏移量（以毫秒为单位）。
            offset = timeZone.getRawOffset();
            // 对偏移量做显示，如GMT-09:30、TIME_ZONE_GMT+09:30
            diplayOffset = appendTimeZoneSuffix(offset, true);
            // 存储到map中，形式为Hongkong---TIME_ZONE_GMT+08:00
            map.put(zoneIds[i], diplayOffset);
        }
        return map;
    }

    /**
     * 计算两个时区之间的时间差,以小时为单位，返回String类型的值
     * @param firstTimeZone  第一个时区（被减数）
     * @param secondTimeZone 第二时区（减数）
     * @return 时间差，比如+01:00表示第一个时区比第二时区早1个小时,-02:30表示第一个时区比第二个时区晚2个半小时
     */
    public static String getTimeDifferenceInHoursString(TimeZone firstTimeZone,
                                                        TimeZone secondTimeZone) {

        long firstOffset = 0L;
        long secondOffset = 0L;
        String displayOffset = "";

        // 返回添加到 UTC 以获取此时区中的标准时间的时间偏移量（以毫秒为单位）。
        firstOffset = firstTimeZone.getRawOffset();
        secondOffset = secondTimeZone.getRawOffset();
        // 对偏移量做显示，如GMT-09:30、TIME_ZONE_GMT+09:30
        displayOffset = appendTimeZoneSuffix(firstOffset - secondOffset, false);
        return displayOffset;
    }

    /**
     * 计算两个时区之间的时间差，返回double类型的值，以小时为单位
     * @param firstTimeZone  第一个时区（被减数）
     * @param secondTimeZone 第二时区（减数）
     * @return 时间差，比如1.0表示第一个时区比第二时区早1个小时,-2.5表示第一个时区比第二个时区晚2个半小时
     */
    public static double getTimeDifferenceInHours(TimeZone firstTimeZone,
                                                  TimeZone secondTimeZone) {

        // 返回添加到 UTC 以获取此时区中的标准时间的时间偏移量（以毫秒为单位）。
        long firstOffset = firstTimeZone.getRawOffset();
        long secondOffset = secondTimeZone.getRawOffset();
        double diff = firstOffset - secondOffset;
        double diffHour = (diff) / 3600000d;

        return diffHour;
    }

    /**
     * 添加时区偏移量
     * @param offset          偏移量（以毫秒为单位）
     * @param isNeedGMTPrefix 显示时是否需要带GMT前缀
     * @return 日期
     */
    private static String appendTimeZoneSuffix(long offset,
                                               boolean isNeedGMTPrefix) {
        // 将偏移量转化为小时（小数去除不要）
        long hour = Long.valueOf((offset / 3600000));
        // 偏移量对小时取余数，得到小数（以毫秒为单位）
        double decimals = offset % 3600000;
        // 显示为09:30分钟形式
        double decimalsZone = (decimals / 3600000) * 60 / 100;
        String sAdd = "";
        if (hour >= 0) {
            sAdd = "+";
        } else {
            sAdd = "-";
        }
        hour = hour > 0 ? hour : -hour;
        String sHour = hour + "";
        if (sHour.length() == 1) {
            sHour = '0' + sHour;
        }

        decimalsZone = decimalsZone < 0 ? -decimalsZone : decimalsZone;
        String sDecimalsZone = decimalsZone + "";
        sDecimalsZone = sDecimalsZone.substring(2);
        if (sDecimalsZone.length() == 1) {
            sDecimalsZone = sDecimalsZone + '0';
        } else if (sDecimalsZone.length() >= 3) {
            sDecimalsZone = sDecimalsZone.substring(0, 2);
        }
        if (isNeedGMTPrefix) {
            return "TIME_ZONE_GMT" + sAdd + sHour + ':' + sDecimalsZone;
        } else {
            return sAdd + sHour + ':' + sDecimalsZone;
        }

    }

    /**
     * 时区时间转换:将当前时间（可能为其他时区）转化成目标时区对应的时间
     * @param sourceDateString 要转换的String格式的时间,支持常见的日期格式
     * @param sourceTimeZone   入参时间的时区
     * @param targetTimeZone   要转换成目标时区（一般是是世界标准时区：取值UTC）
     * @return Calendar 转化成UTC时区后的Calendar格式的时间
     * @throws ParseException
     */
    public static Calendar transformTimeZone(String sourceDateString,
                                             TimeZone sourceTimeZone, TimeZone targetTimeZone)
            throws ParseException {
        Date sourceDate = DateUtil.transformStringDate(sourceDateString);
        Calendar calendar = transformTimeZone(sourceDate, sourceTimeZone,
                targetTimeZone);
        return calendar;
    }

    /**
     * 时区时间转换:将当前时间（可能为其他时区）转化成目标时区对应的时间
     * @param sourceDate     要转换的Date格式的时间
     * @param sourceTimeZone 入参时间的时区
     * @param targetTimeZone 要转换成目标时区（一般是是世界标准时区：取值UTC）
     * @return Calendar 转化时区后的时间
     */
    public static Calendar transformTimeZone(Date sourceDate,
                                             TimeZone sourceTimeZone, TimeZone targetTimeZone) {
        // 校验入参是否合法
        if (sourceTimeZone == null || sourceDate == null || sourceDate == null) {
            throw new IllegalArgumentException(
                    "all parameters can not be empty");
        }

        Long targetTime = sourceDate.getTime() - sourceTimeZone.getRawOffset()
                + targetTimeZone.getRawOffset();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(targetTime));
        calendar.setTimeZone(targetTimeZone);
        return calendar;
    }

    /**
     * 时区时间转换:将当前时间（可能为其他时区）转化成目标时区对应的时间
     * @param sourceDate     需要转换的Calendar格式的时间
     * @param sourceTimeZone 入参时间的时区id,如Asia/Shanghai
     * @param targetTimeZone 要转换成目标时区id（一般是是零时区：取值UTC）,如America/New_York
     * @return Calendar 转化时区后的时间
     */
    public static Calendar transformTimeZone(Calendar sourceDate,
                                             TimeZone sourceTimeZone, TimeZone targetTimeZone) {

        return transformTimeZone(sourceDate.getTime(), sourceTimeZone,
                targetTimeZone);
    }

    /**
     * 时区时间转换:将当前时间（可能为其他时区）转化成目标时区对应的时间
     * @param sourceTime     时间格式可以常见格式
     * @param sourceTimeZone 入参时间的时区
     * @return Claendar 转化成UTC时区后的Calendar格式的时间
     * @throws ParseException
     */
    public static Calendar transformTimeZoneToUTC(String sourceTime,
                                                  TimeZone sourceTimeZone) throws ParseException {
        Date sourceDate = DateUtil.transformStringDate(sourceTime);
        return transformTimeZone(sourceDate, sourceTimeZone,
                TimeZoneUtil.getUTC());
    }

    /**
     * 时区时间转换:将时间（可能为其他时区）转化成目标时区对应的时间
     * @param sourceDate     需要转换的Date格式的时间
     * @param sourceTimeZone 入参时间的时区
     * @return Calendar 转化成UTC时区后的Calendar格式的时间
     */
    public static Calendar transformTimeZoneToUTC(Date sourceDate,
                                                  TimeZone sourceTimeZone) {
        return transformTimeZone(sourceDate, sourceTimeZone,
                TimeZoneUtil.getUTC());
    }

    /**
     * 时区时间转换:将时间（可能为其他时区）转化成国际标准时区对应的时间
     * @param sourceDate     需要转换的Calendar格式的时间
     * @param sourceTimeZone 入参时间的时区
     * @return Calendar 转化成UTC时区后的Calendar格式的时间
     */
    public static Calendar transformTimeZoneToUTC(Calendar sourceDate,
                                                  TimeZone sourceTimeZone) {
        return transformTimeZone(sourceDate.getTime(), sourceTimeZone,
                TimeZoneUtil.getUTC());
    }

    /**
     * 时区时间转换:将中国时间转化成太平洋时区对应的时间
     * @param sourceDate     需要转换的Calendar格式的时间
     * @param sourceTimeZone 入参时间的时区
     * @return Calendar 转化成PST时区后的Calendar格式的时间
     */
    public static Calendar transformChinaTimeZoneToPST(Calendar sourceDate) {
        return transformTimeZone(sourceDate.getTime(),
                TimeZoneUtil.getChinaTimeZone(), TimeZoneUtil.getPST());
    }


    /**
     * 时区时间转换:将中国时间转化成太平洋时区对应的时间
     * @param sourceDate     需要转换的Calendar格式的时间
     * @param sourceTimeZone 入参时间的时区
     * @return Calendar 转化成PST时区后的Calendar格式的时间
     * @throws ParseException
     */
    public static Calendar transformChinaTimeZoneToPST(String sourceDate)
            throws ParseException {
        return transformTimeZone(DateUtil.transformStringDate(sourceDate),
                TimeZoneUtil.getChinaTimeZone(), TimeZoneUtil.getPST());
    }

    /**
     * 时区时间转换:将太平洋时间转化成中国时区对应的时间
     * @param sourceDate     需要转换的Calendar格式的时间
     * @param sourceTimeZone 入参时间的时区
     * @return Calendar 转化成北京时间后的Calendar格式的时间
     */
    public static Calendar transformPSTToChinaTimeZone(Calendar sourceDate) {
        return transformTimeZone(sourceDate.getTime(),
                TimeZoneUtil.getChinaTimeZone(), TimeZoneUtil.getPST());
    }

    /**
     * 时区时间转换:将太平洋时间转化成中国时区对应的时间
     * @param sourceDate     需要转换的String格式的时间
     * @param sourceTimeZone 入参时间的时区
     * @return Calendar 转化成北京时间后的Calendar格式的时间
     * @throws ParseException
     */
    public static Calendar transformPSTToChinaTimeZone(String sourceDate)
            throws ParseException {
        return transformTimeZone(DateUtil.transformStringDate(sourceDate),
                TimeZoneUtil.getPST(), TimeZoneUtil.getChinaTimeZone());
    }

    /**
     * 判断给定的时间是不是美国的夏令时,判断依据：<br>
     * 美国原本于每年4月的第一个星期日凌晨2时起至10月的最后一个星期日凌晨2时实施夏时制；但经美国国会2005年通过的能源法案，
     * 自2007年起延长夏时制，开始日期从每年4月的第一个星期日，提前到<B>3月的第二个星期日</B>，结束日期从每年10月的最后一个星期日，延后到<
     * B>11月的第一个星期日</B>。
     * 美国夏时制实行与否，完全由各州各郡自己决定
     * @return
     */
    public static boolean isDaylightTimeInUSA() {
        return isDaylightTimeInUSA(DateUtil.getNow());
    }

    /**
     * 判断给定的时间是不是美国的夏令时,判断依据：<br>
     * 美国原本于每年4月的第一个星期日凌晨2时起至10月的最后一个星期日凌晨2时实施夏时制；<br>
     * 但经美国国会2005年通过的能源法案，
     * 自2007年起延长夏时制，开始日期从每年4月的第一个星期日，提前到<B>3月的第二个星期日</B>，结束日期从每年10月的最后一个星期日，延后到<
     * B>11月的第一个星期日</B>。
     * 美国夏时制实行与否，完全由各州各郡自己决定
     * @param dateString 需要检测的日期，可以是常见的日期格式
     * @return
     * @throws ParseException
     */
    public static boolean isDaylightTimeInUSA(String dateString)
            throws ParseException {
        Date date = DateUtil.transformStringDate(dateString);
        return isDaylightTimeInUSA(date);
    }

    public static boolean isDaylightTimeInUSA(Date dateNeedCheck) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(dateNeedCheck);
        ca.setFirstDayOfWeek(Calendar.SUNDAY);
        int year = ca.get(Calendar.YEAR);
        // int month = ca.get(Calendar.MONTH) + 1;
        // 3月的第二个星期日
        Calendar daylightSavingTimeBeginDay = DateUtil.getSecondSundayOfMonth(
                year, 3);
        // 11月的第一个星期日
        Calendar daylightSavingTimeEndDay = DateUtil.getFirstSundayOfMonth(
                year, 11);

        // System.out.println(Format(format18,
        // daylightSavingTimeBeginDay.getTime()));
        // System.out.println(Format(format18, dateNeedCheck.getTime()));
        // System.out.println(Format(format18,
        // daylightSavingTimeEndDay.getTime().getTime()));
        //
        // System.out.println(daylightSavingTimeBeginDay.getTime().getTime());
        // System.out.println(dateNeedCheck.getTime());
        // System.out.println(daylightSavingTimeEndDay.getTime().getTime());

        long startDayInSecond = daylightSavingTimeBeginDay.getTime().getTime() / 1000;
        long endDayInSecond = daylightSavingTimeEndDay.getTime().getTime() / 1000;
        long dateNeedCheckInSecond = dateNeedCheck.getTime() / 1000;
        if (startDayInSecond <= dateNeedCheckInSecond
                && dateNeedCheckInSecond <= endDayInSecond) {
            return true;
        }
        return false;
    }

    /**
     * 查询给定的日期是否在给定时区的夏令时中
     * @param timeZone
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static boolean isInDaylightTime(TimeZone timeZone, String dateString)
            throws ParseException {
        Date date = DateUtil.transformStringDate(dateString);
        return timeZone.inDaylightTime(date);
    }

    /**
     * 查询给定的日期是否在给定时区的夏令时中
     * @param timeZone
     * @param date
     * @return
     * @throws ParseException
     */
    public static boolean isInDaylightTime(TimeZone timeZone, Date date)
            throws ParseException {
        return timeZone.inDaylightTime(date);
    }

    /**
     * 查询给定的日期是否在系统默认时区的夏令时中
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static boolean isInDaylightTime(String dateString)
            throws ParseException {
        Date date = DateUtil.transformStringDate(dateString);
        return TimeZone.getDefault().inDaylightTime(date);
    }


    /**
     * 根据字符串类型的时区偏移量获取时区
     * @param offSetInString
     * @return
     */
    public static TimeZone getTimeZoneByOffSet(String offSetInString) {
        String timeZoneID = "";
        Short offSetInShort = Short.parseShort(offSetInString);
        if (offSetInShort > 0) {
            timeZoneID = "GMT+" + offSetInShort;
        } else {
            timeZoneID = "GMT" + offSetInShort;
        }
        return TimeZone.getTimeZone(timeZoneID);
    }


    /**
     * 根据short类型的时区偏移量获取时区
     * @param offSetInString
     * @return
     */
    public static TimeZone getTimeZoneByOffSet(short offSetInShort) {
        String timeZoneID = "";
        if (offSetInShort > 0) {
            timeZoneID = "GMT+" + offSetInShort;
        } else {
            timeZoneID = "GMT" + offSetInShort;
        }
        return TimeZone.getTimeZone(timeZoneID);
    }

}