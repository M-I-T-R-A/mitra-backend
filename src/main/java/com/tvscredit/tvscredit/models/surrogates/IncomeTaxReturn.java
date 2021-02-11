package com.tvscredit.tvscredit.models.surrogates;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Date;

@Embeddable
public class IncomeTaxReturn {
    private Date date;
    private Double tax;

    @Column(columnDefinition="TEXT")
    private String itrDocumentUrl;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getItrDocumentUrl() {
        return itrDocumentUrl;
    }

    public void setItrDocumentUrl(String itrDocumentUrl) {
        this.itrDocumentUrl = itrDocumentUrl;
    }
}
