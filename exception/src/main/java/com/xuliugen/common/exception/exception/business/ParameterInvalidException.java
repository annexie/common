package com.xuliugen.common.exception.exception.business;

import com.xuliugen.common.exception.exception.sub.SubException;

import java.util.Set;

/**
 * @author liugen.xu
 */
public class ParameterInvalidException extends BusinessException {

    private static final long serialVersionUID = -3230963066351537104L;

    public ParameterInvalidException() {
        super.code = BusinessExceptionCodeConstants.B_PARAMTER_INVALID;
    }

    /**
     * @param errorMessage
     */
    public ParameterInvalidException(String errorMessage) {
        super(errorMessage);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param subExceptions
     */
    public ParameterInvalidException(Set<SubException> subExceptions) {
        super(subExceptions);
        super.code = BusinessExceptionCodeConstants.B_PARAMTER_INVALID;
    }

    /**
     * @param errorCode
     * @param subExceptions
     */
    public ParameterInvalidException(String errorCode,
                                     Set<SubException> subExceptions) {
        super(errorCode, subExceptions);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param errorCode
     * @param errorMessage
     */
    public ParameterInvalidException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param errorCode
     * @param errorMessage
     * @param subExceptions
     */
    public ParameterInvalidException(String errorCode, String errorMessage,
                                     Set<SubException> subExceptions) {
        super(errorCode, errorMessage, subExceptions);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param errorCode
     * @param errorMessage
     * @param solution
     */
    public ParameterInvalidException(String errorCode, String errorMessage,
                                     String solution) {
        super(errorCode, errorMessage, solution);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param errorCode
     * @param errorMessage
     * @param solution
     * @param subExceptions
     */
    public ParameterInvalidException(String errorCode, String errorMessage,
                                     String solution, Set<SubException> subExceptions) {
        super(errorCode, errorMessage, solution, subExceptions);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public ParameterInvalidException(Throwable cause) {
        super(cause);
        super.code = BusinessExceptionCodeConstants.B_PARAMTER_INVALID;
    }

    /**
     * @param cause
     * @param subExceptions
     */
    public ParameterInvalidException(Throwable cause,
                                     Set<SubException> subExceptions) {
        super(cause, subExceptions);
        super.code = BusinessExceptionCodeConstants.B_PARAMTER_INVALID;
    }

    /**
     * @param cause
     * @param errorCode
     * @param subExceptions
     */
    public ParameterInvalidException(Throwable cause, String errorCode,
                                     Set<SubException> subExceptions) {
        super(cause, errorCode, subExceptions);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     * @param errorCode
     * @param errorMessage
     * @param subExceptions
     */
    public ParameterInvalidException(Throwable cause, String errorCode,
                                     String errorMessage, Set<SubException> subExceptions) {
        super(cause, errorCode, errorMessage, subExceptions);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     * @param errorCode
     * @param errorMessage
     * @param solution
     * @param subExceptions
     */
    public ParameterInvalidException(Throwable cause, String errorCode,
                                     String errorMessage, String solution,
                                     Set<SubException> subExceptions) {
        super(cause, errorCode, errorMessage, solution, subExceptions);
        // TODO Auto-generated constructor stub
    }

}
