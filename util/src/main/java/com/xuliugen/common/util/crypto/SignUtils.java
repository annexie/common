package com.xuliugen.common.util.crypto;

import com.xuliugen.common.constant.ConstString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.*;

/**
 * @ClassName:SignUtils
 * @Description: 签名工具类
 * @Author Albert
 * @Date:2013-1-21 上午9:53:51
 * @Remarks:
 * @Version:V1.1
 */
public class SignUtils {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(SignUtils.class);

    /**
     * 签名算法:<br/>
     * 使用<code>secret</code>对paramValues按以下算法进行签名： <br/>
     * uppercase(hex(sha1(secretkey1value1key2value2...secret))
     * @param paramValues 参数名和参数值对应的Map
     * @param secret
     * @return
     */
    public static String sign(Map<String, String> paramValues, String secret) {
        return sign(paramValues, null, secret);
    }

    /**
     * 签名算法:<br/>
     * 使用<code>secret</code>对paramValues按以下算法进行签名： <br/>
     * uppercase(hex(sha1(secretkey1value1key2value2...secret))
     * @param paramValueMap       参数名和参数值对应的Map
     * @param ignoreParamNameList 不参与签名运算的参数名
     * @param secret
     * @return
     */
    public static String sign(Map<String, String> paramValueMap,
                              List<String> ignoreParamNameList, String secret) {

        String sign = null;

        try {
            StringBuilder sb = new StringBuilder();
            List<String> paramNames = new ArrayList<String>(paramValueMap.size());
            paramNames.addAll(paramValueMap.keySet());
            if (ignoreParamNameList != null && ignoreParamNameList.size() > 0) {
                for (String ignoreParamName : ignoreParamNameList) {
                    paramNames.remove(ignoreParamName);
                }
            }
            Collections.sort(paramNames);

            sb.append(secret);
            for (String paramName : paramNames) {
                sb.append(paramName).append(paramValueMap.get(paramName));
            }
            sb.append(secret);
            byte[] sha1Digest = MD5EncryptUtil.getSHA1Digest(sb.toString());
            sign = MD5EncryptUtil.byte2hex(sha1Digest);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return sign;
    }

    /**
     * WeiXin签名校验
     * @param token
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @return
     */
    public static String signForWeiXin(String token, String timestamp, String nonce) {
        // 对token、timestamp和nonce按字典排序
        String[] paramArr = new String[]{token, timestamp, nonce};
        Arrays.sort(paramArr);

        // 将排序后的结果拼接成一个字符串
        String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);

        String signString = null;
        try {
            MessageDigest md = MessageDigest.getInstance(ConstString.ENCRYPT_TYPE_SHA_1);
            // 对接后的字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            signString = MD5EncryptUtil.byte2hexNoUpperCase(digest);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return signString;
    }

    public static String utf8Encoding(String value, String sourceCharsetName) {
        try {
            return new String(value.getBytes(sourceCharsetName),
                    ConstString.STRING_ENCODING_UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().toUpperCase();
    }
}
