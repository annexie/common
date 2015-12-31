package com.xuliugen.common.exception.exception.sub.business;

/**
 * @ClassName:AuthenticationException
 * @Description: 请求信息验证异常，细分为：身份验证异常、权限验证异常
 * @Author liugen.xu
 * @Date:2013-1-20 下午5:21:45
 * @Remarks:
 * @Version:V1.1
 */
public class RequestCheckingException extends OPFBaseException {

    private static final long serialVersionUID = 7480068909056066539L;

    public RequestCheckingException() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param msg
     * @param throwable
     */
    public RequestCheckingException(String msg, Throwable throwable) {
        super(msg, throwable);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param msg
     */
    public RequestCheckingException(String msg) {
        super(msg);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param throwable
     */
    public RequestCheckingException(Throwable throwable) {
        super(throwable);
        // TODO Auto-generated constructor stub
    }


}
