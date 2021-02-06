package com.tvscredit.tvscredit.models;

import javax.persistence.*;

import java.util.List;

@Entity
public class PurchasedShop {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Shop shop;

    @ElementCollection
    private List<Documents> documents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Documents> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Documents> documents) {
        this.documents = documents;
    }
}
