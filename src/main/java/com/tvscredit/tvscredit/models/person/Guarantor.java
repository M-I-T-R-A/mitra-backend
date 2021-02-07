package com.tvscredit.tvscredit.models.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Guarantor extends Person {

    private Boolean isWorthy;

    public Boolean getWorthy() {
        return isWorthy;
    }

    public void setWorthy(Boolean worthy) {
        isWorthy = worthy;
    }
}
