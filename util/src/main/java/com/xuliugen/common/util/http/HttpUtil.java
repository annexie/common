package com.xuliugen.common.util.http;

import com.alibaba.fastjson.JSONObject;
import com.xuliugen.common.constant.ConstString;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.lang.StringUtils;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

/**
 * HTTP工具类
 */
public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * 连接超时时间
     */
    private static final Integer CON_TIME_OUT_MINIS = 3 * 1000;

    /**
     * 读取数据超时时间
     */
    private static final Integer READ_TIME_OUT_MINIS = 3 * 1000;

    /**
     * 执行Get请求
     * @param url
     * @param paramKeyAndValueMap
     * @return
     */
    public static String get(String url, Map<String, Object> paramKeyAndValueMap) {
        url = url + "?" + convertParamMapToStringWithEncode(paramKeyAndValueMap);
        logger.debug(url);
        return getWithEncodeURL(url);
    }

    /**
     * 使用没有UTF-8编码的URL执行Get请求
     * @param url
     * @return
     */
    public static String getWithoutEncodeURL(String url) {
        String response = null;
        try {
            response = get(url, CON_TIME_OUT_MINIS, READ_TIME_OUT_MINIS, true);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return response;
    }

    /**
     * 使用没有UTF-8编码的URL执行Get请求
     * @param url
     * @param paramKeyAndValueMap
     * @return
     */
    public static String getWithoutEncodeURL(String url, Map<String, Object> paramKeyAndValueMap) {
        url = url + "?" + convertParamMapToStringWithEncode(paramKeyAndValueMap);
        String response = null;
        try {
            response = get(url, CON_TIME_OUT_MINIS, READ_TIME_OUT_MINIS, true);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return response;
    }

    /**
     * 使用没有UTF-8编码的URL执行Get请求
     * @param url
     * @param paramKeyAndValueMap
     * @param connTimeoutMinis
     * @param readTimeoutMinis
     * @param gzipFlag
     * @return
     */
    public static String getWithoutEncodeURL(String url, Map<String, Object> paramKeyAndValueMap, int connTimeoutMinis,
                                             int readTimeoutMinis, boolean gzipFlag) throws Exception {
        url = url + "?" + convertParamMapToStringWithEncode(paramKeyAndValueMap);
        String response = get(url, connTimeoutMinis, readTimeoutMinis, gzipFlag);
        return response;
    }


    /**
     * 发起HTTP Get请求
     * @param urlNotEncode     没有UTF-8编码的URL
     * @param connTimeoutMinis 连接超时时间
     * @param readTimeoutMinis 读取数据超时时间
     * @param gzipFlag         传输的数据是否经过gip压缩
     * @return
     */
    public static String get(String urlNotEncode, int connTimeoutMinis, int readTimeoutMinis, boolean gzipFlag) throws Exception {
        GetMethod method = new GetMethod(urlNotEncode);
        method.setFollowRedirects(true);
        if (gzipFlag) {
            method.setRequestHeader("Accept-Encoding", "gzip,deflate");
        }
        HttpClient httpClient = new HttpClient();
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(connTimeoutMinis);
        httpClient.getHttpConnectionManager().getParams().setSoTimeout(readTimeoutMinis);
        try {
            int code = httpClient.executeMethod(method);
            if (code == 200) {
                InputStream in = method.getResponseBodyAsStream();
                Header contentEncoding = method.getResponseHeader("Content-Encoding");

                BufferedReader reader = null;
                if (contentEncoding != null) {
                    String gzip = contentEncoding.getValue();
                    if (gzip.toLowerCase().indexOf("gzip") != -1) {
                        in = new GZIPInputStream(in);
                        reader = new BufferedReader(new InputStreamReader(in, getCharSet(method)));
                    } else {
                        reader = new BufferedReader(new InputStreamReader(in, getCharSet(method)));
                    }
                } else {
                    reader = new BufferedReader(new InputStreamReader(in, getCharSet(method)));
                }

                String s = "";
                StringBuilder sb = new StringBuilder();
                while ((s = reader.readLine()) != null) {
                    sb.append(s);
                }
                reader.close();
                return sb.toString();
            } else {
                logger.warn("get url:" + urlNotEncode + " return:" + code);
            }
        } finally {
            method.releaseConnection();
            httpClient.getHttpConnectionManager().closeIdleConnections(0);
        }
        return null;
    }

    /**
     * @param httpURLEncode :请求URL，URL已经UTF-8编码过
     * @return 返回结果
     */
    private static String getWithEncodeURL(String httpURLEncode) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        try {
            URL url = new URL(httpURLEncode);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod(ConstString.HTTP_GET);
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, ConstString.STRING_ENCODING_UTF8));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public static String get(String url) {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        String responseText = null;
        try {
            HttpResponse res = client.execute(httpGet);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                responseText = EntityUtils.toString(entity, ConstString.STRING_ENCODING_UTF8);
                logger.debug(responseText);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return responseText;
    }

    /**
     * 以流的形式传输文本
     * @param url
     * @param inputText
     * @return
     */
    public static String postWithText(String url, String inputText) {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        String responseText = null;
        try {
            StringEntity s = new StringEntity(inputText);
            s.setContentEncoding(ConstString.STRING_ENCODING_UTF8);
            s.setContentType("application/json");
            post.setEntity(s);

            HttpResponse res = client.execute(post);
            logger.debug("HttpResponse-" + res);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                responseText = EntityUtils.toString(entity, ConstString.STRING_ENCODING_UTF8);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return responseText;
    }

    /**
     * 以Key-Value传输请求参数
     * @param url
     * @param paramsMap
     * @return
     */
    public static String postWithKeyValueMap(String url, Map<String, Object> paramsMap) {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        String responseText = null;
        try {
            List<NameValuePair> formParamList = new ArrayList<NameValuePair>();
            for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && value != null) {//有的参数值确实为空字符串,所以只能判断是不是为null,不能判断是不是空字符串
                    formParamList.add(new BasicNameValuePair(key, value.toString()));
                }
            }
            logger.debug("postWithKeyValueMap Params-{}", JSONObject.toJSONString(formParamList));
            UrlEncodedFormEntity entity1 = new UrlEncodedFormEntity(formParamList, Consts.UTF_8);
            post.setEntity(entity1);

            HttpResponse res = client.execute(post);
            logger.debug("HttpResponse-" + res);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                responseText = EntityUtils.toString(entity, ConstString.STRING_ENCODING_UTF8);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        return responseText;
    }

    /**
     * 以一个Key和Value的形式传输请求参数
     * @param url
     * @param key
     * @param value
     * @return
     */
    public static String postWithOneKeyAndValue(String url, String key,
                                                String value) {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        String responseText = null;
        try {
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            formParams.add(new BasicNameValuePair(key, value));

            UrlEncodedFormEntity entity1 = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
            entity1.setContentType("application/json");
            post.setEntity(entity1);

            HttpResponse res = client.execute(post);
            logger.debug("HttpResponse-" + res);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                responseText = EntityUtils.toString(entity, ConstString.STRING_ENCODING_UTF8);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        return responseText;
    }

    /**
     * 以流的形式post普通文本
     * @param url
     * @param text
     * @param connectTimeout
     * @param readTimeout
     * @return
     */
    public static String postWithText(String url, String text, int connectTimeout, int readTimeout) {
        HttpClient httpClient = new HttpClient();
        HttpConnectionManagerParams manager = httpClient.getHttpConnectionManager().getParams();
        manager.setConnectionTimeout(connectTimeout);
        manager.setSoTimeout(readTimeout);
        PostMethod post = new PostMethod(url);
        String result = null;
        try {
            RequestEntity entity = new StringRequestEntity(text, "text/plain", ConstString.STRING_ENCODING_UTF8);
            post.setRequestEntity(entity);
            httpClient.executeMethod(post);
            int code = post.getStatusCode();
            if (code == org.apache.commons.httpclient.HttpStatus.SC_OK) {
                result = new String(post.getResponseBodyAsString());
            }
        } catch (Exception e) {
            logger.error("httpPostText error url = " + url, e);
        } finally {
            post.releaseConnection();
            httpClient.getHttpConnectionManager().closeIdleConnections(0);
        }
        return result;
    }

    /**
     * 以流的形式传输数据
     * @param url
     * @param text
     * @param contentType    数据类型：text,json
     * @param connectTimeout
     * @param readTimeout
     * @return
     */
    public static String postData(String url, String text, String contentType, int connectTimeout, int readTimeout) {
        HttpClient httpClient = new HttpClient();
        HttpConnectionManagerParams manager = httpClient.getHttpConnectionManager().getParams();
        manager.setConnectionTimeout(connectTimeout);
        manager.setSoTimeout(readTimeout);
        PostMethod post = new PostMethod(url);
        String result = null;
        try {
            RequestEntity entity = new StringRequestEntity(text, contentType, ConstString.STRING_ENCODING_UTF8);
            post.setRequestEntity(entity);
            httpClient.executeMethod(post);
            int code = post.getStatusCode();
            if (code == org.apache.commons.httpclient.HttpStatus.SC_OK) {
                result = new String(post.getResponseBodyAsString());
            }
        } catch (Exception e) {
            logger.error("httpPostText error url = " + url, e);
        } finally {
            post.releaseConnection();
            httpClient.getHttpConnectionManager().closeIdleConnections(0);
        }
        return result;
    }

    private static String getCharSet(String content) {
        String regex = ".*charset=([^;]*).*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find())
            return matcher.group(1);
        else
            return null;
    }

    private static String getCharSet(HttpMethod method) {
        Header charset = method.getResponseHeader("Content-Type");
        if (charset == null) {
            return ConstString.STRING_ENCODING_UTF8;
        }
        return StringUtils.defaultIfBlank(getCharSet(charset.getValue()), ConstString.STRING_ENCODING_UTF8);
    }

    public static String convertParamMapToStringWithEncode(Map<String, Object> paramKeyAndValueMap) {
        return convertParamMapToString(paramKeyAndValueMap, true);
    }

    public static String convertParamMapToString(Map<String, Object> paramKeyAndValueMap) {
        return convertParamMapToString(paramKeyAndValueMap, false);
    }

    private static String convertParamMapToString(Map<String, Object> paramKeyAndValueMap, boolean encode) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        int size = paramKeyAndValueMap.entrySet().size();
        for (Map.Entry<String, Object> entry : paramKeyAndValueMap.entrySet()) {
            i++;
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && value != null) {
                try {
                    if (encode) {
                        value = URLEncoder.encode(value.toString(), ConstString.STRING_ENCODING_UTF8);
                    }
                    if (i < size) {
                        stringBuffer.append(key + "=" + value + "&");
                    } else if (i == size) {
                        stringBuffer.append(key + "=" + value);
                    }
                } catch (UnsupportedEncodingException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return stringBuffer.toString();
    }

}
