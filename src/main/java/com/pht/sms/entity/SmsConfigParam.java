package com.pht.sms.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 短信模板参数(SmsConfigParam)实体类
 *
 * @author pht
 * @since 2021-03-31 22:54:20
 */
public class SmsConfigParam implements Serializable {
    private static final long serialVersionUID = 870779582752780196L;
    /**
    * 自增id
    */
    private Long id;
    /**
    * 参数名称
    */
    private String param;
    /**
    * 计算脚本
    */
    private String calSql;
    /**
    * 计算方式
    */
    private String calType;
    /**
    * 描述
    */
    private String dsc;
    /**
    * 创建时间
    */
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getCalSql() {
        return calSql;
    }

    public void setCalSql(String calSql) {
        this.calSql = calSql;
    }

    public String getCalType() {
        return calType;
    }

    public void setCalType(String calType) {
        this.calType = calType;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}