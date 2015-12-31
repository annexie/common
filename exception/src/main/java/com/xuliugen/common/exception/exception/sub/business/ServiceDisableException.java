package com.xuliugen.common.exception.exception.sub.business;

/**
 * @author liugen.xu
 */
public class ServiceDisableException extends OPFBaseException {

    private static final long serialVersionUID = 1550687018398356455L;

    public ServiceDisableException() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param msg
     * @param throwable
     */
    public ServiceDisableException(String msg, Throwable throwable) {
        super(msg, throwable);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param msg
     */
    public ServiceDisableException(String msg) {
        super(msg);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param throwable
     */
    public ServiceDisableException(Throwable throwable) {
        super(throwable);
        // TODO Auto-generated constructor stub
    }

}
