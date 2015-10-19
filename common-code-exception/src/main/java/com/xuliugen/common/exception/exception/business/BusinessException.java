package com.xuliugen.common.exception.exception.business;

import com.xuliugen.common.exception.exception.BaseException;
import com.xuliugen.common.exception.exception.sub.SubException;

import java.util.Set;

public class BusinessException extends BaseException {

    private static final long serialVersionUID = -140076445751602150L;

    /**
     * 无参数构造函数，会自动设置默认的code
     */
    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    /**
     * @param subExceptions 子错误列表(自动设置默认的code)
     */
    public BusinessException(Set<SubException> subExceptions) {
        super();
        this.subExceptions = subExceptions;
    }

    /**
     * @param code          主错误编码对应的i18n配置文件中的key，
     *                      这个key将用于从国际化配置文件中读取国际化的message和solution
     *                      ，因此无需传入message和solution参数
     * @param subExceptions 子错误列表
     */
    public BusinessException(String code, Set<SubException> subExceptions) {
        super(code, subExceptions);
    }

    /**
     * @param code    自定义的主错误编码，不对应i18n配置文件中的key
     * @param message 自定义的主错误显示信息
     */
    public BusinessException(String code, String message) {
        super(code, message);
    }

    /**
     * @param code          自定义的主错误编码，不对应i18n配置文件中的key
     * @param message       自定义的主错误显示信息
     * @param subExceptions 子错误列表
     */
    public BusinessException(String code, String message,
                             Set<SubException> subExceptions) {
        super(code, message, subExceptions);
    }

    /**
     * @param code     自定义的主错误编码，不对应i18n配置文件中的key
     * @param message  自定义的主错误显示信息
     * @param solution 自定义的错误解决方法
     */
    public BusinessException(String code, String message, String solution) {
        super(code, message, solution);
    }

    /**
     * @param code          自定义的主错误编码，不对应i18n配置文件中的key
     * @param message       自定义的主错误显示信息
     * @param solution      自定义的错误解决方法
     * @param subExceptions 子错误列表
     */
    public BusinessException(String code, String message, String solution,
                             Set<SubException> subExceptions) {
        super(code, message, solution, subExceptions);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    /**
     * @param cause         原始的异常信息
     * @param subExceptions 子错误列表
     */
    public BusinessException(Throwable cause, Set<SubException> subExceptions) {
        super(cause, subExceptions);
    }

    public BusinessException(Throwable cause, String code,
                             Set<SubException> subExceptions) {
        super(cause, code, subExceptions);
    }

    public BusinessException(Throwable cause, String code, String message,
                             Set<SubException> subExceptions) {
        super(cause, code, message, subExceptions);
    }

    public BusinessException(Throwable cause, String code, String message,
                             String solution, Set<SubException> subExceptions) {
        super(cause, code, message, solution, subExceptions);
    }

}
