package com.pht.account.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 资金总额管理(AccountMoneySum)实体类
 *
 * @author makejava
 * @since 2021-03-03 21:08:01
 */
public class AccountMoneySum implements Serializable {
    private static final long serialVersionUID = -45271925560960807L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 合同编号
     */
    private String contractCode;
    /**
     * 客户编号
     */
    private String custCode;
    /**
     * 资金总额
     */
    private BigDecimal totalMoney;
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

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
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
