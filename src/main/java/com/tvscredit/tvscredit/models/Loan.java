package com.tvscredit.tvscredit.models;

import javax.persistence.*;

@Entity
public class Loan{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Customer customer;

    private String demandedAmount;

    private Boolean approval;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDemandedAmount() {
        return demandedAmount;
    }

    public void setDemandedAmount(String demandedAmount) {
        this.demandedAmount = demandedAmount;
    }

    public Boolean getApproval() {
        return approval;
    }

    public void setApproval(Boolean approval) {
        this.approval = approval;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", customer=" + customer +
                ", demandedAmount='" + demandedAmount + '\'' +
                ", approval=" + approval +
                '}';
    }
}