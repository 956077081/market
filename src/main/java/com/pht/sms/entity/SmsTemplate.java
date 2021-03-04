package com.pht.sms.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (SmsTemplate)实体类
 *
 * @author makejava
 * @since 2021-03-04 11:05:50
 */
public class SmsTemplate implements Serializable {
    private static final long serialVersionUID = -88357444058184266L;

    private Long id;
    private String code;
    private String content;
    private String calcType;//计算方式0直接映射
    private Date createTime;
    private Date updateTime;


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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCalcType() {
        return calcType;
    }

    public void setCalcType(String calcType) {
        this.calcType = calcType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
