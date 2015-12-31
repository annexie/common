package com.xuliugen.common.exception.exception.sub.business;

/**
 * @ClassName:RequestAuthenticationException
 * @Description: 身份验证异常
 * @Author liugen.xu
 * @Date:2013-1-20 下午7:15:07
 * @Remarks:
 * @Version:V1.1
 */
public class RequestAuthenticationException extends RequestCheckingException {

    private static final long serialVersionUID = -8633852296712491459L;

    /**
     * 身份验证异常
     */
    public RequestAuthenticationException() {
        super("You do not have permission to operate");
    }

    /**
     * @param msg
     * @param throwable
     */
    public RequestAuthenticationException(String msg, Throwable throwable) {
        super(msg, throwable);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param msg
     */
    public RequestAuthenticationException(String msg) {
        super(msg);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param throwable
     */
    public RequestAuthenticationException(Throwable throwable) {
        super(throwable);
        // TODO Auto-generated constructor stub
    }

}
