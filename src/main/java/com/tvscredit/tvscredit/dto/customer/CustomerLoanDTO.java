package com.tvscredit.tvscredit.dto.customer;

import com.tvscredit.tvscredit.dto.loan.InstantLoanDTO;

public class CustomerLoanDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private InstantLoanDTO instantLoanDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public InstantLoanDTO getInstantLoanDTO() {
        return instantLoanDTO;
    }

    public void setInstantLoanDTO(InstantLoanDTO instantLoanDTO) {
        this.instantLoanDTO = instantLoanDTO;
    }
}
