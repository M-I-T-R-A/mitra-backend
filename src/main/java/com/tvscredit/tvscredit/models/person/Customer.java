package com.tvscredit.tvscredit.models.person;

import com.tvscredit.tvscredit.models.BankAccount;
import com.tvscredit.tvscredit.models.loans.InstantLoan;
import com.tvscredit.tvscredit.models.surrogates.InstantLoanSurrogates;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer extends Person{

    private Boolean haveCurrentLoan;

    private Integer status;

    @OneToMany(mappedBy = "customer")
    private List<InstantLoan> allLoans;

    @OneToOne(mappedBy = "customer")
    private InstantLoanSurrogates instantLoanSurrogates;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<BankAccount> allBankAccounts;

    public Boolean getHaveCurrentLoan() {
        return haveCurrentLoan;
    }

    public void setHaveCurrentLoan(Boolean haveCurrentLoan) {
        this.haveCurrentLoan = haveCurrentLoan;
    }

    public List<InstantLoan> getAllLoans() {
        return allLoans;
    }

    public Integer getStatus() {
        return status;
    }

    public List<BankAccount> getAllBankAccounts() {
        return allBankAccounts;
    }

    public void setAllBankAccounts(List<BankAccount> allBankAccounts) {
        this.allBankAccounts = allBankAccounts;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setAllLoans(List<InstantLoan> allLoans) {
        this.allLoans = allLoans;
    }

    public InstantLoanSurrogates getInstantLoanSurrogates() {
        return instantLoanSurrogates;
    }

    public void setInstantLoanSurrogates(InstantLoanSurrogates instantLoanSurrogates) {
        this.instantLoanSurrogates = instantLoanSurrogates;
    }
}
