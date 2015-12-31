package com.xuliugen.common.exception.exception.sub.business;

import com.xuliugen.common.exception.exception.sub.SubException;

public class ParameterInvalidValueException extends SubException {

    private static final long serialVersionUID = -1518043233182641729L;

    public ParameterInvalidValueException() {
        super.code = SubBusinessExceptionCodeConstants.PARAMETER_INVALID_VALUE;
    }

    public ParameterInvalidValueException(Object[] messageParameters) {
        super(messageParameters);
        this.code = SubBusinessExceptionCodeConstants.PARAMETER_INVALID_VALUE;
    }

    public ParameterInvalidValueException(Object[] messageParameters,
                                          Object[] solutionParameters) {
        super(messageParameters, solutionParameters);
        super.code = SubBusinessExceptionCodeConstants.PARAMETER_INVALID_VALUE;
    }

    // public ParameterInvalidValueException(String code,
    // Set<SubException> subExceptions) {
    // super(code, subExceptions);
    // // TODO Auto-generated constructor stub
    // }
    //
    // public ParameterInvalidValueException(String code, String message) {
    // super(code, message);
    // // TODO Auto-generated constructor stub
    // }
    //
    // public ParameterInvalidValueException(String code, String message,
    // Set<SubException> subExceptions) {
    // super(code, message, subExceptions);
    // // TODO Auto-generated constructor stub
    // }
    //
    // public ParameterInvalidValueException(String code, String message,
    // String solution) {
    // super(code, message, solution);
    // // TODO Auto-generated constructor stub
    // }
    //
    // public ParameterInvalidValueException(String code, String message,
    // String solution, Set<SubException> subExceptions) {
    // super(code, message, solution, subExceptions);
    // // TODO Auto-generated constructor stub
    // }

    // public ParameterInvalidValueException(Throwable cause) {
    // super(cause);
    // super.code = SubBusinessExceptionCodeConstants.PARAMETER_INVALID_VALUE;
    // }
    //
    // public ParameterInvalidValueException(Throwable cause,
    // Set<SubException> subExceptions) {
    // super(cause, subExceptions);
    // super.code = SubBusinessExceptionCodeConstants.PARAMETER_INVALID_VALUE;
    // }
    //
    // public ParameterInvalidValueException(Throwable cause, String code,
    // Set<SubException> subExceptions) {
    // super(cause, code, subExceptions);
    // // TODO Auto-generated constructor stub
    // }
    //
    // public ParameterInvalidValueException(Throwable cause, String code,
    // String message, Set<SubException> subExceptions) {
    // super(cause, code, message, subExceptions);
    // // TODO Auto-generated constructor stub
    // }
    //
    // public ParameterInvalidValueException(Throwable cause, String code,
    // String message, String solution, Set<SubException> subExceptions) {
    // super(cause, code, message, solution, subExceptions);
    // // TODO Auto-generated constructor stub
    // }

}
