package com.tvscredit.tvscredit.models.surrogates;

import com.tvscredit.tvscredit.models.Customer;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class InstantLoanSurrogates extends BaseSurrogates{

    @OneToOne
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
