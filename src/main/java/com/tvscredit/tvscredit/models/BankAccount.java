package com.tvscredit.tvscredit.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.models.person.Person;

import javax.persistence.*;
import java.util.List;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue
    private Long id;

    private Long ifsc;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer person;

    private String accountNumber;

    @Column(columnDefinition="TEXT")
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Customer person) {
        this.person = person;
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
                ", customerId=" + person +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankStatementImageUrl='" + bankStatementImageUrls + '\'' +
                ", currentValue=" + currentValue +
                '}';
    }
}
