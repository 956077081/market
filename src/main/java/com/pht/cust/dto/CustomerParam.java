package com.pht.cust.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class CustomerParam  {
    private Long id;
    @NotEmpty
    private String operatorCode;

    private String code;
    @NotEmpty
    private String custName;
    @NotEmpty
    private String custType;
    @NotEmpty
    private String idType;
    @NotEmpty
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
    private String email;
    private BigDecimal registerMoney;
}
