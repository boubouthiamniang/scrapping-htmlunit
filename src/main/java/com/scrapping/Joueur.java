package com.scrapping;

public class Joueur {
    String nom;
    String id;
    int cote;
    int coteRapide;

    public Joueur(String nom, String id, int cote, int coteRapide) {
        this.nom=nom;
        this.id=id;
        this.cote=cote;
        this.coteRapide=coteRapide;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getCote() {
        return cote;
    }
    public void setCote(int cote) {
        this.cote = cote;
    }
    public int getCoteRapide() {
        return coteRapide;
    }
    public void setCoteRapide(int coteRapide) {
        this.coteRapide = coteRapide;
    }

    
}
