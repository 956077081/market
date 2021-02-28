package com.pht.contract.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * contractdetails_tmp(ContractdetailsTmp)实体类
 *
 * @author makejava
 * @since 2021-02-27 22:58:32
 */
public class ContractdetailsTmp implements Serializable {
    private static final long serialVersionUID = 623631641268980558L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 编号
     */
    private String code;
    /**
     * 主合同编号
     */
    private String contractCode;
    /**
     * 合同名称
     */
    private String contractName;
    /**
     * 客户编号
     */
    private String custCode;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 合同结束时间
     */
    private Date endTime;
    /**
     * 期限
     */
    private String term;
    /**
     * 总金额
     */
    private BigDecimal totalMoney;
    /**
     * 合同状态
     */
    private String status;
    /**
     * 合同类型
     */
    private String type;
    /**
     * 备注
     */
    private String memo;
    /**
     * 操作类型
     */
    private String operate;
    /**
     * 客户经理编号
     */
    private String managerCode;
    /**
     * 操作人
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

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(String managerCode) {
        this.managerCode = managerCode;
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
