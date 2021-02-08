package com.tvscredit.tvscredit.models.surrogates;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tvscredit.tvscredit.models.enums.Competition;
import com.tvscredit.tvscredit.models.enums.LocationCategory;
import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.models.person.Guarantor;

import javax.persistence.*;

import java.util.List;

@MappedSuperclass
public class BaseSurrogates {

    @Id
    private Long id;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Customer customer;

    private LocationCategory locationCategory;

    private Competition competition;

    private Float rating;

    @ElementCollection
    private List<Assets> assetsList;

    @ElementCollection
    private List<IncomeTaxReturn> taxReturns;

    @ElementCollection
    private List<SupplierBills> bills;

    @OneToOne
    private Guarantor guarantor;

    public Guarantor getGuarantor() {
        return guarantor;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setGuarantor(Guarantor guarantor) {
        this.guarantor = guarantor;
    }

    public LocationCategory getLocationCategory() {
        return locationCategory;
    }

    public void setLocationCategory(LocationCategory locationCategory) {
        this.locationCategory = locationCategory;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public List<SupplierBills> getBills() {
        return bills;
    }

    public void setBills(List<SupplierBills> bills) {
        this.bills = bills;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Assets> getAssetsList() {
        return assetsList;
    }

    public void setAssetsList(List<Assets> assetsList) {
        this.assetsList = assetsList;
    }

    public List<IncomeTaxReturn> getTaxReturns() {
        return taxReturns;
    }

    public void setTaxReturns(List<IncomeTaxReturn> taxReturns) {
        this.taxReturns = taxReturns;
    }
}
