package com.tvscredit.tvscredit.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Documents {

    private String name;

    @Column(columnDefinition="TEXT")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
