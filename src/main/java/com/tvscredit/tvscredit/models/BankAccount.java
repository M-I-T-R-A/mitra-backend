package com.tvscredit.tvscredit.models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue
    private Long id;

    private Long ifsc;

    private Customer customerId;

    private String accountNumber;

    private String bankStatementImageUrl;

    private String currentValue;

    public Long getIfsc() {
        return ifsc;
    }

    public void setIfsc(Long ifsc) {
        this.ifsc = ifsc;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankStatementImageUrl() {
        return bankStatementImageUrl;
    }

    public void setBankStatementImageUrl(String bankStatementImageUrl) {
        this.bankStatementImageUrl = bankStatementImageUrl;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "ifsc=" + ifsc +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankStatementImageUrl='" + bankStatementImageUrl + '\'' +
                ", currentValue='" + currentValue + '\'' +
                '}';
    }
}
