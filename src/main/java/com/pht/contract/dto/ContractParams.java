package com.pht.contract.dto;

import com.pht.account.entity.AccountMoneyDetails;
import com.pht.contract.entity.Contractdetails;
import com.pht.cust.entity.Customer;

public class ContractParams {
    private Contractdetails contractdetails;
    private AccountMoneyDetails account;
    private Customer customer;

    public Contractdetails getContractdetails() {
        return contractdetails;
    }

    public void setContractdetails(Contractdetails contractdetails) {
        this.contractdetails = contractdetails;
    }

    public AccountMoneyDetails getAccount() {
        return account;
    }

    public void setAccount(AccountMoneyDetails account) {
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
