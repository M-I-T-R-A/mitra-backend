package com.tvscredit.tvscredit.dto.bankaccount;

import com.tvscredit.tvscredit.models.person.Person;

import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

public class BankAccountDTO {

    private Long id;
    private Long ifsc;
    private String accountNumber;
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
}
