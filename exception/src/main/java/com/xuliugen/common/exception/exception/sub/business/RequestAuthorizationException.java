package com.xuliugen.common.exception.exception.sub.business;

/**
 * @ClassName:RequestAuthenticationException
 * @Description: 权限验证异常
 * @Author liugen.xu
 * @Date:2013-1-20 下午7:15:07
 *
 * @Remarks:
 * @Version:V1.1
 */
public class RequestAuthorizationException extends RequestCheckingException {

    private static final long serialVersionUID = -8633852296712491459L;

    public RequestAuthorizationException() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param msg
     * @param throwable
     */
    public RequestAuthorizationException(String msg, Throwable throwable) {
        super(msg, throwable);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param msg
     */
    public RequestAuthorizationException(String msg) {
        super(msg);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param throwable
     */
    public RequestAuthorizationException(Throwable throwable) {
        super(throwable);
        // TODO Auto-generated constructor stub
    }

}
