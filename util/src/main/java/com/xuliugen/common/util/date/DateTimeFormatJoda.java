package com.xuliugen.common.util.date;

import com.xuliugen.common.constant.datetime.ConstFormatDateTimeString;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by liugen.xu on 15/7/3.
 */
public interface DateTimeFormatJoda {

    DateTimeFormatter yyyyMMddHHmm = DateTimeFormat.forPattern(ConstFormatDateTimeString.yyyyMMddHHmm);

    DateTimeFormatter yyyy_MM_ddHHmmss = DateTimeFormat.forPattern(ConstFormatDateTimeString.yyyy_MM_ddHHmmss);

    DateTimeFormatter yyyy_MM_ddHHmm = DateTimeFormat.forPattern(ConstFormatDateTimeString.yyyy_MM_ddHHmm);

    DateTimeFormatter yyyyMMddHHmmss = DateTimeFormat.forPattern(ConstFormatDateTimeString.yyyyMMddHHmmss);

}
