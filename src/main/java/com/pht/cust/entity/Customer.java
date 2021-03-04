package com.pht.cust.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 客户表(Customer)实体类
 *
 * @author makejava
 * @since 2021-03-01 21:33:48
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = -33801555674796176L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 编号
     */
    private String code;
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
    /**
     * 客户状态 01 有效
     */
    private String status;
    /**
     * 法人名称
     */
    private String lawName;
    /**
     * 法人证件号码
     */
    private String lawNum;
    /**
     * 法人手机号码
     */
    private String lawMobile;
    /**
     * 注册时间
     */
    private Date registerTime;
    /**
     * 注册资金
     */
    private BigDecimal registerMoney;
    /**
     * 行业
     */
    private String profession;
    /**
     * 地址
     */
    private String address;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 操作员编号
     */
    private String operatorCode;
    /**
     * 操作员名称
     */
    private String operatorName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLawName() {
        return lawName;
    }

    public void setLawName(String lawName) {
        this.lawName = lawName;
    }

    public String getLawNum() {
        return lawNum;
    }

    public void setLawNum(String lawNum) {
        this.lawNum = lawNum;
    }

    public String getLawMobile() {
        return lawMobile;
    }

    public void setLawMobile(String lawMobile) {
        this.lawMobile = lawMobile;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public BigDecimal getRegisterMoney() {
        return registerMoney;
    }

    public void setRegisterMoney(BigDecimal registerMoney) {
        this.registerMoney = registerMoney;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
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

}
