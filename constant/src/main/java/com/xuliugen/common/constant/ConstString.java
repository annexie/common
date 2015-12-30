package com.xuliugen.common.constant;

/**
 * Created by albertliu on 14-9-16.
 */
public interface ConstString {

    String STRING_ENCODING_UTF8 = "UTF-8";

    String APPLICATION_XML = "application/xml";

    String APPLICATION_JSON = "application/json";

    String APP_JSON_UTF_8 = APPLICATION_JSON + ConstPunctuation.SEMICOLON + "charset=" + STRING_ENCODING_UTF8;

    String APP_XML_UTF_8 = APPLICATION_XML + ConstPunctuation.SEMICOLON + "charset=" + STRING_ENCODING_UTF8;

    String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";

    String HTTP_GET = "GET";
    String HTTP_POST = "POST";
    String HTTP_PUT = "PUT";
    String HTTP_DELETE = "DELETE";

    String PARAM = "param";

    String SUCCESS = "Success";

    String ALL = "ALL";

    String ABOLISH_DATE = "8888-01-01 00:00:00";

    String FILE_PATH_SEP_WIN = "\\";

    String FILE_PATH_SEP_NO_WIN = "/";

    String ENCRYPT_TYPE_SHA_1 = "SHA-1";

    /**
     * dev环境
     */
    String ENV_DEV = "dev";

    /**
     * beta环境
     */
    String ENV_BETA = "beta";

    /**
     * prod环境
     */
    String ENV_PROD = "prod";

    /**
     * 日志跟踪ID
     */
    String TRACE_ID = "traceId";

}
