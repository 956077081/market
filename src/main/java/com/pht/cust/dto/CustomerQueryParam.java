package com.pht.cust.dto;

import lombok.Data;


@Data
public class CustomerQueryParam {
    private String custName;
    private String idType;
    private String idNum;
    private String custType;
    private String profession;
    private String createTimeStart;
    private String createTimeEnd;
}
