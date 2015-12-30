package com.xuliugen.common.exception.exception.business;

import com.xuliugen.common.exception.exception.ExceptionMessageConstants;
import com.xuliugen.common.exception.exception.system.SystemExceptionCodeConstants;
import com.xuliugen.common.exception.i18n.I18NManager;

/**
 * 操作异常
 * @author liugen.xu
 */
public class OperationException extends BusinessException {

    private static final long serialVersionUID = -1935488976921678886L;

    public OperationException() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param solution
     */
    public OperationException(String solution) {
        super.solution = solution;
        super.code = I18NManager
                .getMessage(SystemExceptionCodeConstants.OPERATION_EXCEPTION);
        super.message = I18NManager.getMessage(
                ExceptionMessageConstants.OPERATION_EXCEPTION, solution);
    }

    /**
     * @param solution
     * @param errorMessage
     */
    public OperationException(String solution, String errorMessage) {
        super.solution = solution;
        super.code = I18NManager
                .getMessage(SystemExceptionCodeConstants.OPERATION_EXCEPTION);
        super.message = I18NManager.getMessage(errorMessage, solution);
    }

    // /**
    // * @param solution
    // * @param code
    // * @param message
    // */
    // public OperationException(String solution, String code,
    // String message) {
    // super(solution, code, message);
    // // TODO Auto-generated constructor stub
    // }
    //
    // /**
    // * @param cause
    // */
    // public OperationException(Throwable cause) {
    // super(cause);
    // // TODO Auto-generated constructor stub
    // }
    //
    // /**
    // * @param cause
    // * @param message
    // */
    // public OperationException(Throwable cause, String message) {
    // super(cause, message);
    // // TODO Auto-generated constructor stub
    // }
    //
    // /**
    // * @param cause
    // * @param code
    // * @param message
    // */
    // public OperationException(Throwable cause, String code,
    // String message) {
    // super(cause, code, message);
    // // TODO Auto-generated constructor stub
    // }
    //
    // /**
    // * @param cause
    // * @param solution
    // * @param code
    // * @param message
    // */
    // public OperationException(Throwable cause, String solution,
    // String code, String message) {
    // super(cause, solution, code, message);
    // // TODO Auto-generated constructor stub
    // }

}
