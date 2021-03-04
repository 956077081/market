package com.pht.sms.service;

import com.pht.cust.entity.Customer;
import com.pht.sms.dto.SmsRet;
import com.pht.sms.entity.SmsDetails;
import com.pht.sms.entity.SmsTemplate;

import java.util.Map;

public interface SmsDetailsService {
     SmsDetails sendSms(Customer customer, SmsTemplate smsTemplate, Map<String,Object> params);
     SmsRet sendSms(String tel, String content);

}
