package com.helloIftekhar.springJwt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name= "Ohter")
public class Other extends Intervenant{
    private String activity ;

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

}
