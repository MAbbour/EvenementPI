
package com.esprit.Entite;

import java.util.ArrayList;
import java.util.List;

public class Parent {
    private String id_parent;
    private String nom;
    private String prenom;
    private String mail;
    private int tel;
    private int nb_enfant;
    private String mdp;
    List<enfant> listenf;
    List<Inscription_evenement> listEve;

    public Parent() {
        listenf = new ArrayList<>();
        listEve = new ArrayList<>();
    }

    public Parent(String nom, String prenom, String mail, int tel, int nb_enfant, String mdp) {
        listenf = new ArrayList<>();
        listEve = new ArrayList<>();
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.tel = tel;
        this.nb_enfant = nb_enfant;
        this.mdp = mdp;
    }

    public Parent(String id_parent, String nom, String prenom, String mail, int tel, int nb_enfant, String mdp) {
        listenf = new ArrayList<>();
        listEve = new ArrayList<>();
        this.id_parent = id_parent;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.tel = tel;
        this.nb_enfant = nb_enfant;
        this.mdp = mdp;
    }

    public String getId_parent() {
        return id_parent;
    }

    public void setId_parent(String id_parent) {
        this.id_parent = id_parent;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getNb_enfant() {
        return nb_enfant;
    }

    public void setNb_enfant(int nb_enfant) {
        this.nb_enfant = nb_enfant;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public void addenfant (enfant f){
        listenf.add(f);
    }

    @Override
    public String toString() {
        return "Parent{" + "id_parent=" + id_parent + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", tel=" + tel + ", nb_enfant=" + nb_enfant + ", mdp=" + mdp + ", listenf=" + listenf + ", listEve=" + listEve + '}';
    }

    
    
}
