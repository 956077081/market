package com.pht.account.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 支付金额明细(AccountMoneyDetails)实体类
 *
 * @author makejava
 * @since 2021-03-03 20:21:07
 */
public class AccountMoneyDetails implements Serializable {
    private static final long serialVersionUID = 546230119135379012L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 账户编号
     */
    private String code;
    /**
     * 客户编号
     */
    private String custCode;
    /**
     * 合同编号
     */
    private String contractCode;
    /**
     * 打款状态
     */
    private String status;
    /**
     * 支付方式
     */
    private String payMethod;
    /**
     * 支付类型
     */
    private String payType;
    /**
     * 账户号码
     */
    private String accountNum;
    /**
     * 支付金额
     */
    private BigDecimal payMoney;
    /**
     * 1:打款
     * 0：扣款
     */
    private String type;
    /**
     * 操作人
     */
    private String operatorCode;
    /**
     * 操作员名称
     */
    private String operatorName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
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

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
