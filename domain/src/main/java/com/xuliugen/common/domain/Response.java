package com.xuliugen.common.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xuliugen.common.valueobject.IResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ValidationException;

/**
 * 响应领域实体
 */
public class Response<T> implements IResponse {

    private static final Logger logger = LoggerFactory.getLogger(Response.class);

    /**
     * 编码
     */
    private Integer code;

    /**
     * 描述信息
     */
    private String msg;

    private T data;

    /**
     * 无参构造函数，默认为成功
     */
    public Response() {
        this.code = CodeEnum.SUCCESS.code;
    }

    public Response(Integer code) {
        this.code = code;
    }

    public Response(String msg) {
        this.msg = msg;
    }

    public Response(Throwable throwable) {
        logger.error(throwable.getMessage(), throwable);
        if (throwable instanceof ValidationException || throwable instanceof IllegalArgumentException) {
            this.code = CodeEnum.PARAM_INVALID.code;
            this.msg = throwable.getMessage();
        } else {
            this.code = CodeEnum.UNKNOWN.code;
            this.msg = throwable.getMessage();
        }
    }

    public Response(Throwable throwable, Integer code) {
        logger.error(throwable.getMessage(), throwable);
        this.code = code;
        this.msg = throwable.getMessage();
    }

    /**
     * @param data
     */
    public Response(T data) {
        this.code = CodeEnum.SUCCESS.code;
        this.data = data;
    }

    /**
     * @param data
     */
    public Response(T data, String msg) {
        this.code = CodeEnum.SUCCESS.code;
        this.msg = msg;
        this.data = data;
    }

    public Response(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param businessResult the data to set
     */
    public void setData(T businessResult) {
        this.data = businessResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 处理是否成功
     * @return
     */
    public boolean isSuccess() {
        if (code != null) {
            return CodeEnum.SUCCESS.code == code;
        }
        return false;
    }

    /**
     * 编码枚举
     */
    public enum CodeEnum {

        SUCCESS(0, "成功"),

        PARAM(10000000, "参数错误"),
        PARAM_MISS(10010000, "参数缺失"),
        PARAM_INVALID(10020000, "参数不合法"),
        PARAM_INVALID_FORMAT(10020100, "参数格式错误"),
        PARAM_INVALID_OUT_OF_RANGE(10020200, "参数越界"),

        AUTHEN(11000000, "身份认证失败"),
        AUTHEN_SIGN(11010000, "签名验证失败"),

        AUTHOR(12000000, "权限认证失败"),

        UNKNOWN(99999999, "未知错误");

        public Integer code;
        public String msg;

        CodeEnum(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
    }
}
