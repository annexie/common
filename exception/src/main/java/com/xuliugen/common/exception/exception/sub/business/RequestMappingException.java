/**
 * Copyright(C) 2012-2016 All Rights
 * Reserved.
 */
package com.xuliugen.common.exception.exception.sub.business;


/**
 * @ClassName:RequestMappingException
 * @Description: 请求的参数向Java对象映射过程中出现的异常
 * @Author liugen.xu
 * @Date:2013-1-19 下午4:39:56
 *
 * @Remarks:
 * @Version:V1.1
 */
public class RequestMappingException extends RequestParameterException {

    /**
     *
     */
    private static final long serialVersionUID = -4189987809081742431L;

    /**
     *
     */
    public RequestMappingException() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param msg
     * @param throwable
     */
    public RequestMappingException(String msg, Throwable throwable) {
        super(msg, throwable);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param msg
     */
    public RequestMappingException(String msg) {
        super(msg);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param throwable
     */
    public RequestMappingException(Throwable throwable) {
        super(throwable);
        // TODO Auto-generated constructor stub
    }


}
