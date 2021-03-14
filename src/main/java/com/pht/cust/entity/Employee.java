package com.pht.cust.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 员工(Employee)实体类
 *
 * @author pht
 * @since 2021-03-14 13:16:31
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 729905289379470433L;
    /**
    * 自增id
    */
    private Long id;
    /**
    * 用户编号
    */
    private String userCode;
    /**
    * 员工编号
    */
    private String code;

    /**
     *工牌编号
     */
    private String cardNum;
    /**
    * 客户名称
    */
    private String custName;
    /**
    * 客户类型
    */
    private String custType;
    /**
    * 证件类型
    */
    private String idType;
    /**
    * 证件号码
    */
    private String idNum;


    private String phone;
    /**
    * 更新时间
    */
    private Date updateTime;
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
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

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}