package com.tvscredit.tvscredit.models.loans;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Date;

@Entity
public class ApprovedInstantLoan {

    @Id
    @GeneratedValue
    private Long id;

    @JsonBackReference
    @OneToOne
    private InstantLoan instantLoan;

    private Double approvedAmount;

    private Float rateOfInterest;

    private Float timeFactor;

    private Date startDate;

    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InstantLoan getInstantLoan() {
        return instantLoan;
    }

    public void setInstantLoan(InstantLoan instantLoan) {
        this.instantLoan = instantLoan;
    }

    public Double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(Double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public Float getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(Float rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public Float getTimeFactor() {
        return timeFactor;
    }

    public void setTimeFactor(Float timeFactor) {
        this.timeFactor = timeFactor;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
