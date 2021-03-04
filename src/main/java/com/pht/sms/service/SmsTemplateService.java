package com.pht.sms.service;

import com.pht.sms.entity.SmsTemplate;

import java.util.Map;

public interface SmsTemplateService {
    SmsTemplate crtSmsTemplate(String content, String calcType);
    String calcContent(String templateCode, Map<String,Object> param);
}
