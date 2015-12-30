package com.xuliugen.common.exception.exception.system;

import com.xuliugen.common.exception.exception.BaseException;
import com.xuliugen.common.exception.exception.sub.SubException;

import java.util.Set;


public class SystemException extends BaseException {

    private static final long serialVersionUID = -1212272784792901500L;

    public SystemException() {
        super();
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(Set<SubException> subExceptions) {
        super(subExceptions);
    }

    public SystemException(String code, Set<SubException> subExceptions) {
        super(code, subExceptions);
    }

    public SystemException(String code, String message,
                           Set<SubException> subExceptions) {
        super(code, message, subExceptions);
    }

    public SystemException(String code, String message, String solution,
                           Set<SubException> subExceptions) {
        super(code, message, solution, subExceptions);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    public SystemException(Throwable cause, Set<SubException> subExceptions) {
        super(cause, subExceptions);
    }

    public SystemException(Throwable cause, String code,
                           Set<SubException> subExceptions) {
        super(cause, code, subExceptions);
    }

    public SystemException(Throwable cause, String code, String message,
                           Set<SubException> subExceptions) {
        super(cause, code, message, subExceptions);
    }

    public SystemException(Throwable cause, String code, String message,
                           String solution, Set<SubException> subExceptions) {
        super(cause, code, message, solution, subExceptions);
    }

}
