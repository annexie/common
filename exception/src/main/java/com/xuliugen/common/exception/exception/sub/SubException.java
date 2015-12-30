package com.xuliugen.common.exception.exception.sub;

/**
 * @author liugen.xu
 */
public class SubException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 2548627170033598649L;

    /**
     * 子异常编码对应的i18n配置文件中的key
     */
    public String code;

    /**
     * 子异常信息
     */
    public String message;

    /**
     * 子异常解决方法
     */
    public String solution;

    /**
     * 用于拼接message的变量
     */
    public Object[] messageParameters;

    /**
     * 用于拼接Solution的变量
     */
    public Object[] solutionParameters;

    /**
     *
     */
    public SubException() {
        super();
    }

    /**
     * @param message
     */
    public SubException(String message) {
        super(message);
    }

    public SubException(Object[] messageParameters) {
        super();
        this.messageParameters = messageParameters;
    }

    /**
     * @param subExceptions
     */
    public SubException(Object[] messageParameters, Object[] solutionParameters) {
        super();
        this.messageParameters = messageParameters;
        this.solutionParameters = solutionParameters;
    }

    public SubException(String code, Object[] messageParameters) {
        super();
        this.code = code;
        this.messageParameters = messageParameters;
    }

    public SubException(String code, Object[] messageParameters,
                        Object[] solutionParameters) {
        super();
        this.code = code;
        this.messageParameters = messageParameters;
        this.solutionParameters = solutionParameters;
    }

    /**
     * @param code
     * @param message
     */
    public SubException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * @param code
     * @param message
     * @param solution
     */
    public SubException(String code, String message, String solution) {
        super(message);
        this.code = code;
        this.message = message;
        this.solution = solution;
    }

    /**
     * @param cause
     */
    public SubException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
