package com.pht.sms.service.imp;

import com.pht.base.frame.LoggerFormator;
import com.pht.sms.dao.SmsTemplateDao;
import com.pht.sms.entity.SmsTemplate;
import com.pht.sms.service.SmsTemplateService;
import com.pht.config.utils.PersistentUtil;
import com.pht.config.utils.StringBaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class SmsTemplateServiceImp  implements SmsTemplateService {
    private static LoggerFormator logger = LoggerFormator.getLogger(SmsTemplateServiceImp.class);
    @Autowired
    private SmsTemplateDao smsTemplateDao;

    @Override
    public SmsTemplate crtSmsTemplate(String content, String calcType) {
        SmsTemplate template = new SmsTemplate();
        template.setContent(content);
        template.setCode(PersistentUtil.getBizEntity(SmsTemplate.class));
        template.setCalcType(calcType);
        template.setCreateTime(new Date());
        template.setUpdateTime(new Date());
        smsTemplateDao.insert(template);
        return template;
    }


    /***
     * 暂只提供 直接映射
     * @param templateCode
     * @param param
     * @return
     */
    @Override
    public String calcContent(String templateCode, Map<String, Object> param) {
        SmsTemplate smsTemplate = smsTemplateDao.getByCode(templateCode);
        String content = smsTemplate.getContent();
        content = StringBaseUtil.handleDollarNamedParamByRegex(content, param);
        return content;
    }

}
