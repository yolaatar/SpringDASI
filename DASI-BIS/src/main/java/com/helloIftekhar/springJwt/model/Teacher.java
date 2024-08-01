package com.helloIftekhar.springJwt.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Teacher")
public class Teacher extends Intervenant{
    @Column(name = "estab_type")
    private String establishment_type ;

    public String getEstablishment_type() {
        return establishment_type;
    }

    public void setEstablishment_type(String establishment_type) {
        this.establishment_type = establishment_type;
    }
}
