package com.xuliugen.common.util;

import java.util.UUID;

/**
 * Created by xuliugen on 15/10/18.
 */
public class UUIDUtils {

    /**
     * 产生一个不含有‘-’的32为UUID字符串
     * @return
     */
    public static String generate32UUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
