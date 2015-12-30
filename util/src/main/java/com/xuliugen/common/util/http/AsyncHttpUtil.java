package com.xuliugen.common.util.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步HTTP工具类
 */
public class AsyncHttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(AsyncHttpUtil.class);


    private AsyncHttpUtil() {

    }

    private static AsyncHttpUtil instance = new AsyncHttpUtil();

    public static AsyncHttpUtil getInstance() {
        return instance;
    }

    public String simpleQuery(String url) {
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        logger.info("request url {}", url);
        HttpGet request = new HttpGet(url);
        String s = null;
        try {
            client.start();
            Future<HttpResponse> future = client.execute(request, null);
            HttpResponse response = future.get(5, TimeUnit.SECONDS);
            final HttpEntity entity = response.getEntity();
            s = EntityUtils.toString(entity);
        } catch (Exception e) {
            logger.info("request:" + request.getRequestLine(), e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return s;
    }


    public Map<Integer, String> queryMore(String url, String[] params) throws Exception {
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000).build();
        CloseableHttpAsyncClient client = HttpAsyncClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();
        int len = params.length;
        final Map<Integer, String> map = new HashMap<Integer, String>();
        try {
            client.start();
            final HttpGet[] requests = new HttpGet[len];
            for (int i = 0; i < len; i++) {
                requests[i] = getMethod(url, params[i]);
            }

            final CountDownLatch latch = new CountDownLatch(len);
            for (int i = 0; i < len; i++) {
                final HttpGet request = requests[i];
                final int j = i;
                client.execute(request, new FutureCallback<HttpResponse>() {
                    public void completed(final HttpResponse response) {
                        latch.countDown();
                        //logger.info(request.get + "->" + response.getStatusLine());
                        try {
                            String s = EntityUtils.toString(response.getEntity());
                            logger.info("detail result {}", s);
                            map.put(j, s);
                        } catch (IOException e) {
                            logger.info(request.getRequestLine().toString(), e);
                        }
                    }

                    public void failed(final Exception ex) {
                        latch.countDown();
                        logger.info("detail fail");
                    }

                    public void cancelled() {
                        latch.countDown();
                        logger.info("detail cancel");
                    }

                });
            }
            latch.await(10, TimeUnit.SECONDS);
            logger.info("finish tasks size:{}, result size:{}", len, map.size());
        } finally {
            client.close();
        }
        return map;
    }

    //public String queryList(List<>)

    //public void buildUri(List<BasicNameValuePair> params, String url) throws Exception {
    //    URIBuilder builder = new URIBuilder();
    //    builder.setScheme("http")
    //            .setHost("www.google.com")
    //            .setPath("/search")
    //            .setParameter("q", "httpclie")
    //            .setParameter("btnG", "Googl")
    //            .setParameter("aq", "f")
    //            .setParameter("oq", "")
    //            .build();
    //
    //    builder.addParameter()
    //
    //    List<NameValuePair> list = new ArrayList<NameValuePair>();
    //}

    public HttpGet getMethod(String url, String param) {
        HttpGet get = new HttpGet(url + "?" + param);
        //get.releaseConnection();
        return get;
    }

    public String buildParam(String[] names, String[] values) {
        StringBuilder stringBuilder = new StringBuilder();
        int len = names.length;
        for (int i = 0; i < len; i++) {
            stringBuilder.append(names[i]).append("=").append(values[i]);
            if (i != len - 1) {
                stringBuilder.append("&");
            }
        }
        return stringBuilder.toString();
    }
}
