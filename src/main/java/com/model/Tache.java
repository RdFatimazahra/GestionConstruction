package com.model;

import java.util.Date;

import java.util.Date;

public class Tache {
    private int idTache;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private int idProjet;
    private String statut;

    // Constructeurs
    public Tache() {}

    public Tache( String description, Date dateDebut, Date dateFin, int idProjet, String statut) {
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idProjet = idProjet;
        this.statut = statut;
    }

    // Getters et Setters
    public int getIdTache() {
        return idTache;
    }

    public void setIdTache(int idTache) {
        this.idTache = idTache;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Tache{" +
                "idTache=" + idTache +
                ", description='" + description + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", idProjet=" + idProjet +
                ", statut='" + statut + '\'' +
                '}';
    }
}
