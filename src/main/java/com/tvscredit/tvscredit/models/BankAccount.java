package com.tvscredit.tvscredit.models;

import javax.persistence.*;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue
    private Long id;

    private Long ifsc;

    @ManyToOne
    private Customer customerId;

    private String accountNumber;

    private String bankStatementImageUrl;

    private Double currentValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", ifsc=" + ifsc +
                ", customerId=" + customerId +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankStatementImageUrl='" + bankStatementImageUrl + '\'' +
                ", currentValue=" + currentValue +
                '}';
    }
}
