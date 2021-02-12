package com.tvscredit.tvscredit.models.loans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tvscredit.tvscredit.models.enums.Approval;
import com.tvscredit.tvscredit.models.person.Customer;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
public class InstantLoan {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Customer customer;

    private Double demandedAmount;

    private Approval approval = Approval.WAITING;
    
    @OneToOne(mappedBy = "instantLoan")
    private ApprovedInstantLoan approvedInstantLoan;

    public ApprovedInstantLoan getApprovedInstantLoan() {
        return approvedInstantLoan;
    }

    public void setApprovedInstantLoan(ApprovedInstantLoan approvedInstantLoan) {
        this.approvedInstantLoan = approvedInstantLoan;
    }

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

    public Double getDemandedAmount() {
        return demandedAmount;
    }

    public void setDemandedAmount(Double demandedAmount) {
        this.demandedAmount = demandedAmount;
    }

    public Approval getApproval() {
        return approval;
    }

    public void setApproval(Approval approval) {
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