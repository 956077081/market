package com.pht.contract.dto;

import com.pht.account.entity.AccountMoneyDetails;
import com.pht.contract.entity.Contractdetails;
import com.pht.cust.entity.Customer;

import java.util.List;
public class ContractViews {
    private Contractdetails contractdetails;

    private Customer customer;

    private List<AccountMoneyDetails> accountMoneyDetails;

    public Contractdetails getContractdetails() {
        return contractdetails;
    }

    public void setContractdetails(Contractdetails contractdetails) {
        this.contractdetails = contractdetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<AccountMoneyDetails> getAccountMoneyDetails() {
        return accountMoneyDetails;
    }

    public void setAccountMoneyDetails(List<AccountMoneyDetails> accountMoneyDetails) {
        this.accountMoneyDetails = accountMoneyDetails;
    }
}
