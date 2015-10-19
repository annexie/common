/**
 *
 */
package com.xuliugen.common.exception.exception.sub.business;


import com.xuliugen.common.exception.exception.sub.SubException;

/**
 * @author liugen.xu
 */
public class ParameterInvalidMissingException extends SubException {

    /**
     *
     */
    private static final long serialVersionUID = -3552716858032429014L;

    /**
     *
     */
    public ParameterInvalidMissingException() {
        super.code = SubBusinessExceptionCodeConstants.PARAMETER_INVALID_MISSING;
    }

    /**
     * @param message
     */
    public ParameterInvalidMissingException(String message) {
        super(message);
        super.code = SubBusinessExceptionCodeConstants.PARAMETER_INVALID_MISSING;
    }

    /**
     * @param messageParameters
     */
    public ParameterInvalidMissingException(Object[] messageParameters) {
        super(messageParameters);
        super.code = SubBusinessExceptionCodeConstants.PARAMETER_INVALID_MISSING;
    }

    /**
     * @param messageParameters
     * @param solutionParameters
     */
    public ParameterInvalidMissingException(Object[] messageParameters,
                                            Object[] solutionParameters) {
        super(messageParameters, solutionParameters);
        super.code = SubBusinessExceptionCodeConstants.PARAMETER_INVALID_MISSING;
    }

    /**
     * @param code
     * @param messageParameters
     */
    public ParameterInvalidMissingException(String code,
                                            Object[] messageParameters) {
        super(code, messageParameters);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param code
     * @param messageParameters
     * @param solutionParameters
     */
    public ParameterInvalidMissingException(String code,
                                            Object[] messageParameters, Object[] solutionParameters) {
        super(code, messageParameters, solutionParameters);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param code
     * @param message
     */
    public ParameterInvalidMissingException(String code, String message) {
        super(code, message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param code
     * @param message
     * @param solution
     */
    public ParameterInvalidMissingException(String code, String message,
                                            String solution) {
        super(code, message, solution);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public ParameterInvalidMissingException(Throwable cause) {
        super(cause);
        super.code = SubBusinessExceptionCodeConstants.PARAMETER_INVALID_MISSING;
    }

}
