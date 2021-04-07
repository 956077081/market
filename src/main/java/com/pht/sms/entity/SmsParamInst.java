package com.pht.sms.entity;

import java.io.Serializable;

/**
 * 短信特殊参数(SmsParamInst)实体类
 *
 * @author pht
 * @since 2021-03-31 22:54:41
 */
public class SmsParamInst implements Serializable {
    private static final long serialVersionUID = 664120422672534033L;
    /**
    * 自增id
    */
    private Long id;
    /**
    * 短信实例编号
    */
    private String smsDetailsCode;
    /**
    * 英文名称
    */
    private String name;
    /**
    * 描述
    */
    private String dsc;
    /**
    * 值
    */
    private String value;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSmsDetailsCode() {
        return smsDetailsCode;
    }

    public void setSmsDetailsCode(String smsDetailsCode) {
        this.smsDetailsCode = smsDetailsCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}