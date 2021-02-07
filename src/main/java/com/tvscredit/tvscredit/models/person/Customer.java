package com.tvscredit.tvscredit.models.person;

import com.tvscredit.tvscredit.models.Loan;
import com.tvscredit.tvscredit.models.surrogates.InstantLoanSurrogates;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer extends Person{

    private Boolean haveCurrentLoan;

    @OneToMany(mappedBy = "customer")
    private List<Loan> allLoans;

    @OneToOne(mappedBy = "customer")
    private InstantLoanSurrogates instantLoanSurrogates;

    public Boolean getHaveCurrentLoan() {
        return haveCurrentLoan;
    }

    public void setHaveCurrentLoan(Boolean haveCurrentLoan) {
        this.haveCurrentLoan = haveCurrentLoan;
    }

    public List<Loan> getAllLoans() {
        return allLoans;
    }

    public void setAllLoans(List<Loan> allLoans) {
        this.allLoans = allLoans;
    }

    public InstantLoanSurrogates getInstantLoanSurrogates() {
        return instantLoanSurrogates;
    }

    public void setInstantLoanSurrogates(InstantLoanSurrogates instantLoanSurrogates) {
        this.instantLoanSurrogates = instantLoanSurrogates;
    }
}
