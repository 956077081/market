package com.pht.cust.dto;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;


public class CustomerQueryParam {
    private String custName;
    private String idType;
    private String idNum;
    private String custType;
    private String profession;
    private String createTimeStart;
    private String createTimeEnd;

    public String getCustName() {
        return StringUtils.trim(custName);
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getIdType() {
        return StringUtils.trim(idType);
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNum() {
        return StringUtils.trim(idNum);
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getCustType() {
        return StringUtils.trim(custType);
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getProfession() {
        return StringUtils.trim(profession);
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCreateTimeStart() {
        return StringUtils.trim(createTimeStart);
    }

    public void setCreateTimeStart(String createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public String getCreateTimeEnd() {
        return StringUtils.trim(createTimeEnd);
    }

    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}
