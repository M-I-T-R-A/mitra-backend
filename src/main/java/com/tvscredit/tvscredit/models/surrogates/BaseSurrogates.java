package com.tvscredit.tvscredit.models.surrogates;

import com.tvscredit.tvscredit.models.person.Guarantor;

public class BaseSurrogates {

    private LocationCategory locationCategory;
    private Competition competition;
    private Float rating;
    private Guarantor guarantor;

    public Guarantor getGuarantor() {
        return guarantor;
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
}
