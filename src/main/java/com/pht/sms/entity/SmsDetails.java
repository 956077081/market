package com.pht.sms.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 短信详情(SmsDetails)实体类
 *
 * @author makejava
 * @since 2021-03-04 16:34:54
 */
public class SmsDetails implements Serializable {
    private static final long serialVersionUID = 244275792138034883L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 编号
     */
    private String code;
    /**
     * 状态
     */
    private String status;
    /**
     * 客户编号
     */
    private String custCode;
    /**
     * 短信模板编号
     */
    private String smsTemplateCode;
    /**
     * 手机号码
     */
    private String telPhone;
    /**
     * 模板业务参数
     */
    private String templateParam;
    /**
     * 短信内容
     */
    private String content;
    /**
     * 短信响应状态
     */
    private String smsStatus;
    /**
     * 短信id
     */
    private String ssmId;
    /**
     * 扣费金额
     */
    private BigDecimal consumption;
    /**
     * 余额
     */
    private BigDecimal tmoney;
    /**
     * 发送条数
     */
    private String smsSend;
    /**
     * 描述
     */
    private String dsc;
    /**
     * 创建时间
     */
    private Date updateTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 操作人名称
     */
    private String operateName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getSmsTemplateCode() {
        return smsTemplateCode;
    }

    public void setSmsTemplateCode(String smsTemplateCode) {
        this.smsTemplateCode = smsTemplateCode;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getTemplateParam() {
        return templateParam;
    }

    public void setTemplateParam(String templateParam) {
        this.templateParam = templateParam;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus;
    }

    public String getSsmId() {
        return ssmId;
    }

    public void setSsmId(String ssmId) {
        this.ssmId = ssmId;
    }

    public BigDecimal getConsumption() {
        return consumption;
    }

    public void setConsumption(BigDecimal consumption) {
        this.consumption = consumption;
    }

    public BigDecimal getTmoney() {
        return tmoney;
    }

    public void setTmoney(BigDecimal tmoney) {
        this.tmoney = tmoney;
    }

    public String getSmsSend() {
        return smsSend;
    }

    public void setSmsSend(String smsSend) {
        this.smsSend = smsSend;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

}
