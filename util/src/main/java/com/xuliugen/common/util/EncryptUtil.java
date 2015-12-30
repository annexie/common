package com.xuliugen.common.util;

import com.xuliugen.common.constant.ConstString;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liugen.xu on 14/10/26.
 */
public class EncryptUtil {

    public static byte[] getSHA1Digest(String data) throws IOException {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            bytes = md.digest(data.getBytes(ConstString.STRING_ENCODING_UTF8));
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse);
        }
        return bytes;
    }

    /**
     * 对字符串进行MD5加密
     * @param data
     * @return 加密后的字符数组
     * @throws IOException
     */
    public static byte[] getMD5Digest(String data) throws IOException {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            bytes = md.digest(data.getBytes(ConstString.STRING_ENCODING_UTF8));
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse);
        }
        return bytes;
    }


    /**
     * 对二进制进行MD5加密
     * @param data
     * @return 加密后的字符数组
     * @throws IOException
     */
    public static byte[] getMD5Digest(byte[] data) throws IOException {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            bytes = md.digest(data);
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse);
        }
        return bytes;
    }


    /**
     * 对字符串进行MD5加密，返回加密后的字符串
     * @param data
     * @return 加密后的字符串
     * @throws IOException
     */
    public static String getMD5DigestInString(String data) throws IOException {
        return byte2hexNoUpperCase(getMD5Digest(data));
    }


    /**
     * 对二进制进行MD5加密，返回加密后的字符串
     * @param data
     * @return 加密后的字符串
     * @throws IOException
     */
    public static String getMD5DigestInBytes(byte[] data) throws IOException {
        return byte2hexNoUpperCase(getMD5Digest(data));
    }


    /**
     * 对二进制进行MD5加密，返回加密后的字符串
     * @param data
     * @return 加密后的字符串
     * @throws IOException
     */
    public static List<String> getMD5DigestListInBytes(List<byte[]> byteList) throws IOException {
        List<String> md5List = new ArrayList<String>();
        for (int i = 0; i < byteList.size(); i++) {
            byte[] byteDate = byteList.get(i);
            String md5 = byte2hexNoUpperCase(getMD5Digest(byteDate));
            md5List.add(md5);
        }
        return md5List;
    }


    /**
     * 二进制转十六进制字符串
     * @param bytes
     * @return
     */
    public static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }

    /**
     * 二进制转十六进制字符串
     * @param bytes
     * @return
     */
    public static String byte2hexNoUpperCase(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex);
        }
        return sign.toString();
    }
}
