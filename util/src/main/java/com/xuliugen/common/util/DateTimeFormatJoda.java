package com.xuliugen.common.util;

import com.xuliugen.common.constant.datetime.ConstFormatDateTimeString;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 日期转换
 */
public interface DateTimeFormatJoda {

    DateTimeFormatter yyyyMMddHHmm = DateTimeFormat.forPattern(ConstFormatDateTimeString.yyyyMMddHHmm);

    DateTimeFormatter yyyy_MM_ddHHmmss = DateTimeFormat.forPattern(ConstFormatDateTimeString.yyyy_MM_ddHHmmss);

    DateTimeFormatter yyyy_MM_ddHHmm = DateTimeFormat.forPattern(ConstFormatDateTimeString.yyyy_MM_ddHHmm);

    DateTimeFormatter yyyyMMddHHmmss = DateTimeFormat.forPattern(ConstFormatDateTimeString.yyyyMMddHHmmss);

}
