package com.tvscredit.tvscredit.dto.customer;

import com.tvscredit.tvscredit.models.BankAccount;
import com.tvscredit.tvscredit.models.loans.InstantLoan;
import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.models.shop.Shop;
import com.tvscredit.tvscredit.models.surrogates.InstantLoanSurrogates;

import java.util.List;

public class CustomerDetailDTO {
    private Customer customer;
    private List<InstantLoan> allLoans;
    private InstantLoanSurrogates instantLoanSurrogates;
    private List<BankAccount> allBankAccounts;
    private Shop shop;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<InstantLoan> getAllLoans() {
        return allLoans;
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

    public List<BankAccount> getAllBankAccounts() {
        return allBankAccounts;
    }

    public void setAllBankAccounts(List<BankAccount> allBankAccounts) {
        this.allBankAccounts = allBankAccounts;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
