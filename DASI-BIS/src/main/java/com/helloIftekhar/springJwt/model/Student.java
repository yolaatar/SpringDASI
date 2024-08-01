package com.helloIftekhar.springJwt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "etudiant")
public class Student extends Intervenant {
    @Column(name = "university")
    private String university ;

    @Column(name = "speciality")
    private String speciality ;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
