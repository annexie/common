package com.xuliugen.common.domain;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ValidationException;

/**
 * 集错误和正确响应于一体
 * Created by Albert.Liu on 15/9/8.
 */
public class Response<T> {

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

    public Response(Exception e) {
        logger.error(e.getMessage(), e);
        if (e instanceof ValidationException || e instanceof IllegalArgumentException) {
            this.code = CodeEnum.PARAM_INVALID.code;
            this.msg = e.getMessage();
        } else {
            this.code = CodeEnum.UNKNOWN.code;
            this.msg = e.getMessage();
        }
    }

    public Response(Error e) {
        logger.error(e.getMessage(), e);
        this.code = CodeEnum.UNKNOWN.code;
        this.msg = e.getMessage();
    }


    public Response(Exception e, Integer code) {
        logger.error(e.getMessage(), e);
        this.code = code;
        this.msg = e.getMessage();
    }

    public Response(Error e, Integer code) {
        logger.error(e.getMessage(), e);
        this.code = code;
        this.msg = e.getMessage();
    }

    /**
     * @param data
     */
    public Response(T data) {
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

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
