package com.tvscredit.tvscredit.models.person;

import com.tvscredit.tvscredit.models.Address;
import com.tvscredit.tvscredit.models.BankAccount;
import com.tvscredit.tvscredit.models.enums.Gender;

import javax.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Gender gender;

    private String phoneNumber;

    private Double annualIncome;

    private String aadhar;

    private String pan;

    private Double electricityBill;

    private Address residenceAddress;

    @Column(columnDefinition="TEXT")
    private String aadharCardFrontImageUrl;

    @Column(columnDefinition="TEXT")
    private String aadharCardBackImageUrl;

    @Column(columnDefinition="TEXT")
    private String panCardImageUrl;

    @Column(columnDefinition="TEXT")
    private String electricityBillImageUrl;

    private Integer cibilScore;

    private Boolean isVerified;

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public Integer getCibilScore() {
        return cibilScore;
    }

    public String getAadharCardBackImageUrl() {
        return aadharCardBackImageUrl;
    }

    public void setAadharCardBackImageUrl(String aadharCardBackImageUrl) {
        this.aadharCardBackImageUrl = aadharCardBackImageUrl;
    }

    public void setCibilScore(Integer cibilScore) {
        this.cibilScore = cibilScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGender(Gender gender) {
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

    public String getAadharCardFrontImageUrl() {
        return aadharCardFrontImageUrl;
    }

    public void setAadharCardFrontImageUrl(String aadharCardFrontImageUrl) {
        this.aadharCardFrontImageUrl = aadharCardFrontImageUrl;
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

}
