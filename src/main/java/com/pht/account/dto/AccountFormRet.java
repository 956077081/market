package com.pht.account.dto;

import java.util.List;

public class AccountFormRet {
    private List<String> xtimes;

    private List<String> payMoney;//打款

    private List<String> reduceMoney;//扣款

    private List<String> remainMoney;//剩余
    private List<String> payNum;//打款次数

    public List<String> getXtimes() {
        return xtimes;
    }

    public void setXtimes(List<String> xtimes) {
        this.xtimes = xtimes;
    }

    public List<String> getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(List<String> payMoney) {
        this.payMoney = payMoney;
    }

    public List<String> getReduceMoney() {
        return reduceMoney;
    }

    public void setReduceMoney(List<String> reduceMoney) {
        this.reduceMoney = reduceMoney;
    }

    public List<String> getRemainMoney() {
        return remainMoney;
    }

    public void setRemainMoney(List<String> remainMoney) {
        this.remainMoney = remainMoney;
    }

    public List<String> getPayNum() {
        return payNum;
    }

    public void setPayNum(List<String> payNum) {
        this.payNum = payNum;
    }
}
