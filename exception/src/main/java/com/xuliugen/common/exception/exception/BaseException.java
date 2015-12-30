package com.xuliugen.common.exception.exception;

import com.xuliugen.common.exception.exception.sub.SubException;

import java.util.Set;

/**
 * 基础异常，SystemException和BusinessException的父类
 * @author liugen.xu
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 3438322119670695654L;

    /**
     * 主异常编码对应的i18n配置文件中的key
     */
    public String code;

    /**
     * 主异常信息
     */
    public String message;

    /**
     * 异常解决方法
     */
    public String solution;

    /**
     * 子异常列表
     */
    public Set<SubException> subExceptions;

    /**
     * 无参数构造函数，会自动设置默认的code,无子异常
     */
    public BaseException() {
        super();
    }

    /**
     * @param message
     */
    public BaseException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * @param subExceptions 子异常列表(自动设置默认的code)
     */
    public BaseException(Set<SubException> subExceptions) {
        super();
        this.subExceptions = subExceptions;
    }

    /**
     * @param code          主异常编码对应的i18n配置文件中的key，
     *                      这个key将用于从国际化配置文件中读取国际化的message和solution
     *                      ，因此无需传入message和solution参数
     * @param subExceptions 子异常列表
     */
    public BaseException(String code, Set<SubException> subExceptions) {
        super();
        this.code = code;
        this.subExceptions = subExceptions;
    }

    /**
     * @param code    自定义的主异常编码，不对应i18n配置文件中的key
     * @param message 自定义的主异常显示信息
     */
    public BaseException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * @param code          自定义的主异常编码，不对应i18n配置文件中的key
     * @param message       自定义的主异常显示信息
     * @param subExceptions 子异常列表
     */
    public BaseException(String code, String message,
                         Set<SubException> subExceptions) {
        super(message);
        this.code = code;
        this.message = message;
        this.subExceptions = subExceptions;
    }

    /**
     * @param code     自定义的主异常编码，不对应i18n配置文件中的key
     * @param message  自定义的主异常显示信息
     * @param solution 自定义的异常解决方法
     */
    public BaseException(String code, String message, String solution) {
        super(message);
        this.code = code;
        this.message = message;
        this.solution = solution;
    }

    /**
     * @param code          自定义的主异常编码，不对应i18n配置文件中的key
     * @param message       自定义的主异常显示信息
     * @param solution      自定义的异常解决方法
     * @param subExceptions 子异常列表
     */
    public BaseException(String code, String message, String solution,
                         Set<SubException> subExceptions) {
        super(message);
        this.code = code;
        this.message = message;
        this.solution = solution;
        this.subExceptions = subExceptions;
    }

    public BaseException(Throwable cause) {
        super(cause);
        if (cause instanceof BaseException) {
            BaseException e = (BaseException) cause;
            this.code = e.code;
            this.message = e.message;
            this.solution = e.solution;
            this.subExceptions = e.subExceptions;
        }
    }

    public BaseException(Throwable cause, Set<SubException> subExceptions) {
        super(cause);
        if (cause instanceof BaseException) {
            BaseException e = (BaseException) cause;
            this.code = e.code;
            this.message = e.message;
            this.solution = e.solution;
            this.subExceptions = subExceptions;
        }
    }

    /**
     * @param cause         原始的异常信息
     * @param code          主异常编码对应的i18n配置文件中的key，
     *                      这个key将用于从国际化配置文件中读取国际化的message和solution
     *                      ，因此无需传入message和solution参数
     * @param subExceptions 子异常列表
     */
    public BaseException(Throwable cause, String code,
                         Set<SubException> subExceptions) {
        super(cause);
        this.code = code;
        this.subExceptions = subExceptions;
    }

    /**
     * @param cause         原始的异常信息
     * @param code          自定义的主异常编码，不对应i18n配置文件中的key
     * @param message       自定义的主异常显示信息
     * @param subExceptions 子异常列表
     */
    public BaseException(Throwable cause, String code, String message,
                         Set<SubException> subExceptions) {
        this(cause, subExceptions);
        this.code = code;
        this.message = message;
    }

    /**
     * @param cause    原始的异常信息
     * @param code     自定义的主异常编码，不对应i18n配置文件中的key
     * @param message  自定义的主异常显示信息
     * @param solution 自定义的异常解决方法
     */
    public BaseException(Throwable cause, String code, String message,
                         String solution, Set<SubException> subExceptions) {
        this(cause, subExceptions);
        this.code = code;
        this.message = message;
        this.solution = solution;
    }

}
