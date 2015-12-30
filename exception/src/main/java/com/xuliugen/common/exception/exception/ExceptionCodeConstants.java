package com.xuliugen.common.exception.exception;

/**
 * @ClassName:ExceptionMessageConstants
 * @Description: TODO
 * @Author liugen.xu
 * @Date:2012-5-30 下午10:08:43
 * @Remarks:
 * @Version:V1.1
 */
public interface ExceptionCodeConstants {

    // 前缀=============================
    /**
     * ExceptionMessage的编码前缀
     */
    public static final String PREFIX_EXCEPTION_MESSAGE = "EM_";
    /**
     * ExceptionSolution的编码前缀
     */
    public static final String PREFIX_EXCEPTION_SOLUTION = "ES_";

    public static final String PREFIX_BUSINESS_EXCEPTION = "B";

    public static final String PREFIX_SYSTEM_EXCEPTION = "S";

    // ===============================

    // 用于显示的名称======================
    public static final String ERROR_CODE = "ErrorCode";
    public static final String SUB_ERROR_CODE = "SubErrorCode";
    public static final String ERROR_MESSAGE = "ErrorMessage";
    public static final String SUB_ERROR_MESSAGE = "SubErrorMessage";
    public static final String SOLUTION = "Solution";
    public static final String DETAILS = "Details";
    // ===============================

}
