package com.helloIftekhar.springJwt.model;

import jakarta.persistence.*;
@Entity
@Table(name="Intervenant")
public class Intervenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "lvl_max")
    private Integer lvlMax;

    @Column(name = "lvl_min")
    private Integer lvlMin;

    @Column(name = "dispo")
    private int dispo;

    @Column(name = "nbInterventionFaite")
    private int nbInterventionFaite;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public int isDispo() {
        return dispo;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLvlMax() {
        return lvlMax;
    }

    public void setLvlMax(Integer lvlMax) {
        this.lvlMax = lvlMax;
    }

    public Integer getLvlMin() {
        return lvlMin;
    }

    public void setLvlMin(Integer lvlMin) {
        this.lvlMin = lvlMin;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getDispo() {
        return dispo;
    }

    public int getNbInterventionFaite() {
        return nbInterventionFaite;
    }

    public void setNbInterventionFaite(int nbInterventionFaite) {
        this.nbInterventionFaite = nbInterventionFaite;
    }
}
