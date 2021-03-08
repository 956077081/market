package com.pht.account.dto;

import com.pht.account.entity.AccountMoneyDetails;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
public class AccountMoneyParam {

    /**
     * 合同编号
     */
    @NotEmpty
    private String contractCode;

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
    @NotEmpty
    private String type;
}
