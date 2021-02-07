package com.tvscredit.tvscredit.models.surrogates;

import com.tvscredit.tvscredit.models.person.Customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class InstantLoanSurrogates extends BaseSurrogates{

    @Id
    private Long id;

    @OneToOne
    @MapsId
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
