package Métier;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author p1522867
 */
public class Compte implements Serializable {
    private int id;
    private String nom;
    private String prenom;
    private String pseudo;
    private String mdp;

    public Compte() {
    }

    public Compte(int id, String nom, String prenom, String pseudo, String mdp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Compte{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + ", mdp=" + mdp + '}';
    }
    
    

    
}
