package com.pht.config.utils.http;

import java.util.Map;

public class ReqHttpParam {
    private String url;
    private Map<String, String> param;//请求参数
    private Map<String, Object> postParam;
    private Map<String, String> head;
    private String respCharSet = "UTF-8";

    public ReqHttpParam setUrl(String url) {
        this.url = url;
        return this;
    }

    public ReqHttpParam setRespCharSet(String respCharSet) {
        this.respCharSet = respCharSet;
        return this;
    }

    public ReqHttpParam setParam(Map<String, String> param) {
        this.param = param;
        return this;
    }

    public ReqHttpParam setHead(Map<String, String> head) {
        this.head = head;
        return this;
    }

    public ReqHttpParam setPostParam(Map<String, Object> postParam) {
        this.postParam = postParam;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public Map<String, String> getHead() {
        return head;
    }

    public String getRespCharSet() {
        return respCharSet;
    }

    public Map<String, Object> getPostParam() {
        return postParam;
    }
}
