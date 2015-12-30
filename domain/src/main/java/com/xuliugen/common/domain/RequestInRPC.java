package com.xuliugen.common.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * 进行RPC调用时的通用Request,为了分布式环境下通过traceId跟踪请求的调用链
 */
public class RequestInRPC<T> implements Serializable {

    /**
     * 用于记录日志的traceId,请求中加入traceId这个参数是为了分布式环境下通过traceId跟踪请求的调用链
     */
    private String traceId;

    /**
     * 原始请求参数
     */
    private T rawRequest;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public T getRawRequest() {
        return rawRequest;
    }

    public void setRawRequest(T rawRequest) {
        this.rawRequest = rawRequest;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
    }
}
