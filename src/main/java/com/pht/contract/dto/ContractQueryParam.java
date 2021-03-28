package com.pht.contract.dto;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;


public class ContractQueryParam {
    private String custName;
    private String idType;
    private String idNum;
    private String status;
    private String isOverTime;
    private String startEndTime;//合同到期开始时间
    private String endEndTime;//合同到期结束时间
    private String operatorName;
    private String currPage;
    private String pageSize;
    private String contractName;
    private Date curTime;//当前时间
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

    public String getStatus() {
        return StringUtils.trim(status);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartEndTime() {
        return StringUtils.trim(startEndTime);
    }

    public void setStartEndTime(String startEndTime) {
        this.startEndTime = startEndTime;
    }

    public String getEndEndTime() {
        return StringUtils.trim(endEndTime);
    }

    public void setEndEndTime(String endEndTime) {
        this.endEndTime = endEndTime;
    }

    public String getOperatorName() {
        return StringUtils.trim(operatorName);
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getCurrPage() {
        return StringUtils.trim(currPage);
    }

    public void setCurrPage(String currPage) {
        this.currPage = currPage;
    }

    public String getPageSize() {
        return StringUtils.trim(pageSize);
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getContractName() {
        return StringUtils.trim(contractName);
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getIsOverTime() {
        return StringUtils.trim(isOverTime);
    }

    public void setIsOverTime(String isOverTime) {
        this.isOverTime = isOverTime;
    }

    public Date getCurTime() {
        return curTime;
    }

    public void setCurTime(Date curTime) {
        this.curTime = curTime;
    }
}
