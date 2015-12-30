/**
 * Copyright(C) 2012-2016 All Rights
 * Reserved.
 */
package com.xuliugen.common.exception.exception.sub.business;

/**
 * @ClassName:RequestFormatException
 * @Description: 请求参数格式异常
 * @Author liugen.xu
 * @Date:2013-1-19 下午4:40:43
 * @Remarks:
 * @Version:V1.1
 */
public class RequestFormatException extends RequestParameterException {

    /**
     *
     */
    private static final long serialVersionUID = -412139754163211866L;

    /**
     *
     */
    public RequestFormatException() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param msg
     * @param throwable
     */
    public RequestFormatException(String msg, Throwable throwable) {
        super(msg, throwable);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param msg
     */
    public RequestFormatException(String msg) {
        super(msg);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param throwable
     */
    public RequestFormatException(Throwable throwable) {
        super(throwable);
        // TODO Auto-generated constructor stub
    }

}
