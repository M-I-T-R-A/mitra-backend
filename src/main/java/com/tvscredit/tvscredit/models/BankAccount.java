package com.tvscredit.tvscredit.models;

import com.tvscredit.tvscredit.models.person.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue
    private Long id;

    private Long ifsc;

    @ManyToOne
    private Customer customer;

    private String accountNumber;

    @ElementCollection
    private List<String> bankStatementImageUrls;

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

    public List<String> getBankStatementImageUrls() {
        return bankStatementImageUrls;
    }

    public void setBankStatementImageUrls(List<String> bankStatementImageUrls) {
        this.bankStatementImageUrls = bankStatementImageUrls;
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
                ", bankStatementImageUrl='" + bankStatementImageUrls + '\'' +
                ", currentValue=" + currentValue +
                '}';
    }
}
