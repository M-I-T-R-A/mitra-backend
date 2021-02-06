package com.tvscredit.tvscredit.models;

import javax.persistence.*;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue
    private Long id;

    private Long ifsc;

    @ManyToOne
    private Customer customer;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customerId) {
        this.customer = customerId;
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
                ", customerId=" + customer +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankStatementImageUrl='" + bankStatementImageUrl + '\'' +
                ", currentValue=" + currentValue +
                '}';
    }
}
