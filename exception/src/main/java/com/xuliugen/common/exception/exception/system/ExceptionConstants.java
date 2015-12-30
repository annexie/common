/**
 * Aikaka.com.cn Inc.
 * Copyright(C) 2012-2016 All Rights
 * Reserved.
 */
package com.xuliugen.common.exception.exception.system;

/**
 * @ClassName:ExceptionMessageConstants
 * @Description: TODO
 * @Author liugen.xu
 * @Date:2012-5-30 下午10:08:43
 * @Remarks:
 * @Version:V1.1
 */
public interface ExceptionConstants {

    // 英文
    // JSON 'Key' exception
    public static final String ARGUEMENT_INVALID_POSITIVE_INTEGER = "Please input positive integer !";
    public static final String EXCEPTION_INFO_PARAMETER_JSONKEY = "' don't exist or spell error or the data type of JSON Value error";

    // JSON 'Value' exception
    public static final String EXCEPTION_TYPE_PARAMETER_JSONVALUE = "JSON Value exception:";
    public static final String EXCEPTION_TYPE_PARAMETER_JSONVALUE_SCOPE = "JSON Value scope exception:";
    public static final String EXCEPTION_TYPE_PARAMETER_JSONVALUE_LENGTH = "JSON Value length exception:";
    public static final String EXCEPTION_INFO_PARAMETER_JSONVALUE_REMIN = "'remin' must be greater than 0";
    public static final String EXCEPTION_INFO_PARAMETER_JSONVALUE_REMAX = "'remax' must be greater than 'remin'";
    public static final String EXCEPTION_INFO_PARAMETER_JSONVALUE_DATA_EMPTY = "'data' are empty";
    public static final String EXCEPTION_INFO_PARAMETER_JSONVALUE_DATA_ERROR = "the value of 'data' are all error";
    public static final String EXCEPTION_INFO_PARAMETER_JSONVALUE_VALUE_LENGTH = "the value of json key '%s' is too long";
    public static final String EXCEPTION_INFO_PARAMETER_JSONVALUE_VALUE_SCOPE = "the value of json key '%s' is too large";

    // JSON formate exception
    public static final String EXCEPTION_TYPE_PARAMETER_JSONFORMATE = "JSON string formate exception:";
    public static final String EXCEPTION_INFO_PARAMETER_JSONFORMATE = "JSON string formate exception,please check it";

    // Inentity infomation exception
    public static final String EXCEPTION_TYPE_IDENTITY = "Identity information exception: ";
    // public static final String EXCEPTION_TYPE_IDENTITY =
    // "Identity information exception:";
    public static final String EXCEPTION_INFO_IDENTITY_BUNINESSID = "BusinessId and storeId not match";
    public static final String EXCEPTION_INFO_IDENTITY_STOREID = "StoreId and frontServerId not match";
    public static final String EXCEPTION_INFO_IDENTITY_FRONTSERVERID = "FrontServerId error";
    public static final String EXCEPTION_INFO_IDENTITY_PASSWORD = "Password error";

    // Service request exception
    public static final String EXCEPTION_TYPE_SERVICE_REQUEST = "Service request exception:The service ";
    public static final String EXCEPTION_INFO_SERVICE_REQUEST = " don't exist ,please check it";

    // Request parameter empty
    public static final String EXCEPTION_TYPE_PARAMETER_EMPTY = "Parameter empty exception:";
    public static final String EXCEPTION_INFO_PARAMETER_EMPTY = "The Parameter is empty";

    // Character set parsing exception
    public static final String EXCEPTION_TYPE_CHARACTER = "Character set parsing exception:";
    public static final String EXCEPTION_INFO_CHARACTER = "Cannot parse the byte[] as UTF-8 string";

    // Connection exception
    public static final String EXCEPTION_TYPE_CONNECTION = "Connection exception: ";
    public static final String EXCEPTION_INFO_CONNECTION_RMDB = "cannot connect to mysql";
    public static final String EXCEPTION_INFO_CONNECTION_REDIS = "cannot connect to redis";

}
