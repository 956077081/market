package com.pht.sms.service.imp;

import com.pht.common.CommonDict;
import com.pht.config.frame.QMENV;
import com.pht.cust.entity.Customer;
import com.pht.sms.constant.SmsDict;
import com.pht.sms.dao.SmsDetailsDao;
import com.pht.sms.dto.SmsRet;
import com.pht.sms.entity.SmsDetails;
import com.pht.sms.entity.SmsTemplate;
import com.pht.sms.service.SmsDetailsService;
import com.pht.config.utils.PersistentUtil;
import com.pht.config.utils.QmDataConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class SmsDetailsServiceImp implements SmsDetailsService {
    @Autowired
    private SmsDetailsDao smsDetailsDao;
    @Autowired
    private SmsTemplateServiceImp smsTemplateServiceImp;

    @Async
    @Override
    public SmsDetails sendSms(Customer customer, SmsTemplate smsTemplate, Map<String, Object> params) {
        SmsDetails smsDetails = new SmsDetails();
        smsDetails.setCode(PersistentUtil.getBizEntity(SmsDetails.class));
        smsDetails.setCustCode(customer.getCode());
        smsDetails.setStatus(SmsDict.CALC_TYPE_DIR);
        smsDetails.setTelPhone(customer.getPhone());
        smsDetails.setTemplateParam(QmDataConvertUtils.obj2JsonStr(params));
        smsDetails.setSmsTemplateCode(smsTemplate.getCode());
        smsDetails.setOperateName(QMENV.getUser().userName);
        String content = smsTemplateServiceImp.calcContent(smsTemplate.getCode(), params);
        smsDetails.setContent(content);
        try {
            SmsRet smsRet = sendSms(smsDetails.getTelPhone(), content);
            smsDetails.setStatus(smsRet.isSuceess() ? CommonDict.SUCCESS : CommonDict.ERROR);
            smsDetails.setSmsSend(smsRet.getSend());
            smsDetails.setSmsStatus(smsRet.getStatus());
            if (StringUtils.isNotBlank(smsRet.getTmoney())) {
                smsDetails.setTmoney(new BigDecimal(smsRet.getTmoney()));
            }
            if (StringUtils.isNotBlank(smsRet.getConsumption())) {
                smsDetails.setConsumption(new BigDecimal(smsRet.getConsumption()));
            }
            smsDetails.setSsmId(smsRet.getId());
            smsDetails.setDsc(smsRet.getDsc());
            smsDetails.setStatus(smsRet.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
            smsDetails.setStatus(CommonDict.ERROR);
        }
        smsDetailsDao.insert(smsDetails);
        return smsDetails;
    }

    public SmsRet sendSms(String tel, String content) {

        return null;
    }
}
