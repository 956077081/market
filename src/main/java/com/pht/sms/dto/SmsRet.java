package com.pht.sms.dto;

import lombok.Data;

@Data
public class SmsRet {
    private  boolean isSuceess =true;
    private String  status;//状态
    private String  send;//发送条数
    private String  Consumption;//消费金额
    private String  tmoney;//余额
    private String  id;//编号
    private String dsc;//描述
}
