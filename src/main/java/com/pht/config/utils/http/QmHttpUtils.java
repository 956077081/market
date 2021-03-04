package com.pht.config.utils.http;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class QmHttpUtils {
    public static RespHttpParam sendHttpGet(ReqHttpParam reqHttpParam) {
        RespHttpParam respHttpParam = new RespHttpParam();
        try {
            String s = sendGet(reqHttpParam);
            respHttpParam.setRes(s);
        } catch (Exception e) {
            respHttpParam.setSuccess(false);
            e.printStackTrace();
        }
        return respHttpParam;
    }

    public static RespHttpParam sendHttpPost(ReqHttpParam reqHttpParam) {
        RespHttpParam respHttpParam = new RespHttpParam();
        try {
            String s = sendPost(reqHttpParam);
            respHttpParam.setRes(s);
        } catch (Exception e) {
            respHttpParam.setSuccess(false);
            e.printStackTrace();
        }
        return respHttpParam;
    }

    private static String sendGet(ReqHttpParam reqHttpParam) throws Exception {
        System.out.println("发送get请求，参数：" + JSONObject.toJSONString(reqHttpParam));
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        List<NameValuePair> paramNames = new ArrayList<>();
        if (reqHttpParam.getParam() != null && !reqHttpParam.getParam().isEmpty()) {
            reqHttpParam.getParam().forEach((key, value) -> {
                paramNames.add(new BasicNameValuePair(key, value));
            });
        }
        URI url = null;
        String res = "";
        try {
            url = new URIBuilder().setPath(reqHttpParam.getUrl()).setParameters(paramNames).build();
            HttpGet httpGet = new HttpGet(url);
            RequestConfig config = getRequetConfig();
            if (config != null) {
                httpGet.setConfig(config);
            }
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            System.out.println("响应状态|" + response.getStatusLine());
            System.out.println("内容长度/字节数|" + entity.getContentLength());
            res = EntityUtils.toString(entity);
            System.out.println("内容|" + res);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return res;
    }

    private static String sendPost(ReqHttpParam reqHttpParam) throws Exception {
        System.out.println("发送post请求，参数：" + JSONObject.toJSONString(reqHttpParam));
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        List<NameValuePair> paramNames = new ArrayList<>();
        if (reqHttpParam.getParam() != null && !reqHttpParam.getParam().isEmpty()) {
            reqHttpParam.getParam().forEach((key, value) -> {
                paramNames.add(new BasicNameValuePair(key, value));
            });
        }
        URI url = null;
        String res = "";
        try {
            url = new URIBuilder().setPath(reqHttpParam.getUrl()).setParameters(paramNames).build();//路由参数
            HttpPost httpPost = new HttpPost(url);
            RequestConfig config = getRequetConfig();
            if (config != null) {
                httpPost.setConfig(config);
            }
            if (reqHttpParam.getPostParam() != null && !reqHttpParam.getPostParam().isEmpty()) {//post表单参数
                httpPost.setEntity(new StringEntity(JSONObject.toJSONString(reqHttpParam.getPostParam())));
            }
            if (reqHttpParam.getHead() != null && !reqHttpParam.getHead().isEmpty()) {//请求头
                reqHttpParam.getHead().forEach((key, value) -> {
                    httpPost.addHeader(key, value);
                });
            }
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            System.out.println("响应状态|" + response.getStatusLine());
            System.out.println("内容长度/字节数|" + entity.getContentLength());
            res = EntityUtils.toString(entity, reqHttpParam.getRespCharSet());
            System.out.println("内容|" + res);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return res;
    }

    private static RequestConfig getRequetConfig() {
        // 配置信息
        RequestConfig requestConfig = RequestConfig.custom()
                // 设置连接超时时间(单位毫秒)
                .setConnectTimeout(5000)
                // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(5000)
                // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)
                // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(true).build();

        return requestConfig;
    }
}
