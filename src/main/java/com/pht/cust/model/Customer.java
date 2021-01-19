package com.pht.cust.model;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private Long id;

    private String userCode;

    private String code;

    private String custName;

    private String custType;

    private String idType;

    private String idNum;

    private String lawName;

    private String lawNum;

    private Date registerTime;

    private String profession;

    private String address;

    private String lawMobile;

    private String phone;

    private Date updateTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

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

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
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

    public String getLawMobile() {
        return lawMobile;
    }

    public void setLawMobile(String lawMobile) {
        this.lawMobile = lawMobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userCode=").append(userCode);
        sb.append(", code=").append(code);
        sb.append(", custName=").append(custName);
        sb.append(", custType=").append(custType);
        sb.append(", idType=").append(idType);
        sb.append(", idNum=").append(idNum);
        sb.append(", lawName=").append(lawName);
        sb.append(", lawNum=").append(lawNum);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", profession=").append(profession);
        sb.append(", address=").append(address);
        sb.append(", lawMobile=").append(lawMobile);
        sb.append(", phone=").append(phone);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}