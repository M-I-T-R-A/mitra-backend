package com.tvscredit.tvscredit.dto.customer;

import com.tvscredit.tvscredit.models.Address;
import com.tvscredit.tvscredit.models.enums.Gender;

public class CustomerBasicDTO {
    private Long id;

    private String name;

    private Enum<Gender> gender;

    private String phoneNumber;

    private Double annualIncome;

    private String aadhar;

    private String pan;

    private Double electricityBill;

    private Address residenceAddress;

    private String aadharCardImageUrl;

    private String panCardImageUrl;

    private String electricityBillImageUrl;

    private Integer cibilScore;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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

    public Enum<Gender> getGender() {
        return gender;
    }

    public void setGender(Enum<Gender> gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public Double getElectricityBill() {
        return electricityBill;
    }

    public void setElectricityBill(Double electricityBill) {
        this.electricityBill = electricityBill;
    }

    public Address getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(Address residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getAadharCardImageUrl() {
        return aadharCardImageUrl;
    }

    public void setAadharCardImageUrl(String aadharCardImageUrl) {
        this.aadharCardImageUrl = aadharCardImageUrl;
    }

    public String getPanCardImageUrl() {
        return panCardImageUrl;
    }

    public void setPanCardImageUrl(String panCardImageUrl) {
        this.panCardImageUrl = panCardImageUrl;
    }

    public String getElectricityBillImageUrl() {
        return electricityBillImageUrl;
    }

    public void setElectricityBillImageUrl(String electricityBillImageUrl) {
        this.electricityBillImageUrl = electricityBillImageUrl;
    }

    public Integer getCibilScore() {
        return cibilScore;
    }

    public void setCibilScore(Integer cibilScore) {
        this.cibilScore = cibilScore;
    }
}
