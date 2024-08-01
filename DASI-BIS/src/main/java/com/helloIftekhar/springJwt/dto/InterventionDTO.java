package com.helloIftekhar.springJwt.dto;

public class InterventionDTO {

    private String username ;  ;
    private String matiere ;
    private String details ;
    private String bilan ;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUsername() {
        return username ;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getBilan() {
        return bilan;
    }

    public void setBilan(String bilan) {
        this.bilan = bilan;
    }
}
