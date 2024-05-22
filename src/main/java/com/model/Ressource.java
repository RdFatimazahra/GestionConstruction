package com.model;

public class Ressource {
    private int idRessource;
    private String nomRessource;
    private String type;
    private int quantite;
    private String nomFournisseur;
    private int idTache;

    // Constructeurs
    public Ressource() {}

    public Ressource(String nomRessource, String type, int quantite, String nomFournisseur, int idTache) {
        this.nomRessource = nomRessource;
        this.type = type;
        this.quantite = quantite;
        this.nomFournisseur = nomFournisseur;
        this.idTache = idTache;
    }

    // Getters et Setters
    public int getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(int idRessource) {
        this.idRessource = idRessource;
    }

    public String getNomRessource() {
        return nomRessource;
    }

    public void setNomRessource(String nomRessource) {
        this.nomRessource = nomRessource;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public int getIdTache() {
        return idTache;
    }

    public void setIdTache(int idTache) {
        this.idTache = idTache;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Ressource{" +
                "idRessource=" + idRessource +
                ", nomRessource='" + nomRessource + '\'' +
                ", type='" + type + '\'' +
                ", quantite=" + quantite +
                ", nomFournisseur='" + nomFournisseur + '\'' +
                ", idTache=" + idTache +
                '}';
    }
}
