package com.pht.sms.controller;

import com.pht.common.CommonResult;
import com.pht.sms.dto.SmsCrtContent;
import com.pht.sms.service.SmsTemplateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sms")
public class SmsController {
    @Autowired
    private SmsTemplateService smsTemplateService;
    @RequestMapping("/getTemContent")
    public CommonResult getSmsTemplateContent(@RequestBody SmsCrtContent smsCrtContent) {
        List<Map<String, Object>> params = smsCrtContent.getParams();
        Map<String,Object> param = new HashMap<>();
        if(params != null){
            param=params.get(0);
        }
        String content= smsTemplateService.getSmsTemplateContent(smsCrtContent.getTemplate(),param);
      return CommonResult.success(StringUtils.trimToEmpty(content));
    }

    @RequestMapping("/send")
    public CommonResult send(@RequestBody SmsCrtContent smsCrtContent){
        return  CommonResult.success("");
    }
}
