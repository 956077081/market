package com.pht.sms.dto;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;


public class SmsCrtContent {
    private String phone;
    private String template;
    private List<Map<String,Object>> params;
    private List<String> paramTyps;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTemplate() {
        return StringUtils.trimToEmpty(template);
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public List<Map<String, Object>> getParams() {
        return params;
    }

    public void setParams(List<Map<String, Object>> params) {
        this.params = params;
    }

    public List<String> getParamTyps() {
        return paramTyps;
    }

    public void setParamTyps(List<String> paramTyps) {
        this.paramTyps = paramTyps;
    }
}
