package com.tvscredit.tvscredit.dto.loan;

import com.tvscredit.tvscredit.models.enums.Approval;
import com.tvscredit.tvscredit.models.person.Customer;

import javax.persistence.ManyToOne;

public class InstantLoanDTO {

    private Long id;
    private Double demandedAmount;
    private Approval approval;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
