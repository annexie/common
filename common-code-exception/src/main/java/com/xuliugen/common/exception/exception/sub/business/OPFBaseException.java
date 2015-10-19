/**
 *
 */
package com.xuliugen.common.exception.exception.sub.business;


/**
 * @ClassName:OPFBaseException
 * @Description: opf.core中所有异常的父类
 * @Author liugen.xu
 * @Date:2013-1-19 下午5:15:00
 * @Remarks:
 * @Version:V1.1
 */
public class OPFBaseException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -827989301971110161L;

    public String code = "";

    public OPFBaseException() {
        super();
    }

    public OPFBaseException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public OPFBaseException(String msg) {
        super(msg);
    }

    public OPFBaseException(Throwable throwable) {
        super(throwable);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
