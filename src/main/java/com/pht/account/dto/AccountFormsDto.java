package com.pht.account.dto;


import java.util.List;
import java.util.Map;
public class AccountFormsDto {
    String xtimes;//日期
    String payMoney;//打款
    String reduceMoney;//扣款
    String remainMoney;//剩余
    String payNum;//打款次数

    public String getXtimes() {
        return xtimes;
    }

    public void setXtimes(String xtimes) {
        this.xtimes = xtimes;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    public String getReduceMoney() {
        return reduceMoney;
    }

    public void setReduceMoney(String reduceMoney) {
        this.reduceMoney = reduceMoney;
    }

    public String getRemainMoney() {
        return remainMoney;
    }

    public void setRemainMoney(String remainMoney) {
        this.remainMoney = remainMoney;
    }

    public String getPayNum() {
        return payNum;
    }

    public void setPayNum(String payNum) {
        this.payNum = payNum;
    }
}
