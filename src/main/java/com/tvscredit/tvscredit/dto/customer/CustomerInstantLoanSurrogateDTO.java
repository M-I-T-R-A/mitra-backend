package com.tvscredit.tvscredit.dto.customer;

import com.tvscredit.tvscredit.models.surrogates.InstantLoanSurrogates;

public class CustomerInstantLoanSurrogateDTO {

    private Long id;
    private InstantLoanSurrogates instantLoanSurrogates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InstantLoanSurrogates getInstantLoanSurrogates() {
        return instantLoanSurrogates;
    }

    public void setInstantLoanSurrogates(InstantLoanSurrogates instantLoanSurrogates) {
        this.instantLoanSurrogates = instantLoanSurrogates;
    }
}
