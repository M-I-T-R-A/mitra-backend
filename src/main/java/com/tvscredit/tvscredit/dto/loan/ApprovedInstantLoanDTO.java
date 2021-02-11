package com.tvscredit.tvscredit.dto.loan;

import com.tvscredit.tvscredit.models.loans.ApprovedInstantLoan;

public class ApprovedInstantLoanDTO extends InstantLoanDTO{
    private ApprovedInstantLoan approvedInstantLoan;

    public ApprovedInstantLoan getApprovedInstantLoan() {
        return approvedInstantLoan;
    }

    public void setApprovedInstantLoan(ApprovedInstantLoan approvedInstantLoan) {
        this.approvedInstantLoan = approvedInstantLoan;
    }
}
