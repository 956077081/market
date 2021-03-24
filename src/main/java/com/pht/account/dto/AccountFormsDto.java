package com.pht.account.dto;


import java.util.List;
import java.util.Map;
public class AccountFormsDto {
    List<String> xtimes;

    List<List> payMoney;//打款
    List<List> reduceMoney;//扣款
    List<List> remainMoney;//剩余
    List<String> payNum;

    public List<String> getPayNum() {
        return payNum;
    }

    public void setPayNum(List<String> payNum) {
        this.payNum = payNum;
    }

    public List<String> getXtimes() {
        return xtimes;
    }

    public void setXtimes(List<String> xtimes) {
        this.xtimes = xtimes;
    }

    public List<List> getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(List<List> payMoney) {
        this.payMoney = payMoney;
    }

    public List<List> getReduceMoney() {
        return reduceMoney;
    }

    public void setReduceMoney(List<List> reduceMoney) {
        this.reduceMoney = reduceMoney;
    }

    public List<List> getRemainMoney() {
        return remainMoney;
    }

    public void setRemainMoney(List<List> remainMoney) {
        this.remainMoney = remainMoney;
    }
}
