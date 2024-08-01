package com.helloIftekhar.springJwt.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Intervention")
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Matiere matiere ;

    @ManyToOne
    private Intervenant intervenant ;

    @ManyToOne
    private User user ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_deb" )
    private Date date_deb ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_fin")
    private Date date_fin ;

    @Column(name = "details")
    private String details ;

    @Column(name = "bilan")
    private String bilan ;

    @Column(name = "note")
    private int note ;

    public String getBilan() {
        return bilan;
    }

    public void setBilan(String bilan) {
        this.bilan = bilan;
    }

    public Date getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(Date date_deb) {
        this.date_deb = date_deb;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Intervenant getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
