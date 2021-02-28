package com.pht.cust.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class Customer implements Serializable {
    private Long id;

    private String  operatorCode;

    private String  operatorName;

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

    private String email;
    private BigDecimal registerMoney;
    private String status;
    private static final long serialVersionUID = 1L;
}