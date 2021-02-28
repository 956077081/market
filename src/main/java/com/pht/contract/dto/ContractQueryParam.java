package com.pht.contract.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ContractQueryParam {
    private String custName;
    private String idType;
    private String idNum;
    private String status;
    private String startEndTime;//合同到期开始时间
    private String endEndTime;//合同到期结束时间
    private String operatorName;
    private String currPage;
    private String pageSize;
}
