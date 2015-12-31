package util;

import com.xuliugen.common.constant.ConstPunctuation;
import com.xuliugen.common.constant.datetime.ConstFormatDateTimeString;
import org.joda.time.DateTime;

/**
 * 日志工具类
 */
public class LogUtil {

    /**
     * 获取TraceId
     * @param identityId      标识ID
     * @param entryMethodName 入口方法名
     * @return
     */
    public static String getTraceId(String identityId, String entryMethodName) {
        String startTime = DateTime.now().toString(ConstFormatDateTimeString.mmssSSS);
        identityId = identityId != null ? identityId.toString() : "null";
        entryMethodName = entryMethodName != null ? entryMethodName : "null";
        return identityId + ConstPunctuation.MINUS + entryMethodName + ConstPunctuation.MINUS + startTime;
    }

    /**
     * 获取TraceId
     * @param identityId      标识ID
     * @param entryMethodName 入口方法名
     * @return
     */
    public static String getTraceId(Object identityId, String entryMethodName) {
        String startTime = DateTime.now().toString(ConstFormatDateTimeString.mmssSSS);
        identityId = identityId != null ? identityId.toString() : "null";
        entryMethodName = entryMethodName != null ? entryMethodName : "null";
        return identityId + ConstPunctuation.MINUS + entryMethodName + ConstPunctuation.MINUS + startTime;
    }

    /**
     * 获取TraceId
     * @param entryMethodName 入口方法名
     * @return
     */
    public static String getTraceId(String entryMethodName) {
        String startTime = DateTime.now().toString(ConstFormatDateTimeString.mmssSSS);
        entryMethodName = entryMethodName != null ? entryMethodName : "null";
        return entryMethodName + ConstPunctuation.MINUS + startTime;
    }

}
