/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

/**
 *
 * @author User
 */
public class enfant {
    private String id_enfant;
    private String nom;
    private String prenom;
    private String date_naissance;
    private String adresse;
    private int age;
    Parent parent;

    public enfant() {
    }

    public enfant(String nom, String prenom, String date_naissance, String adresse, int age, Parent parent) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.age = age;
        this.parent= parent;
    }

    public enfant(String nom, String prenom, String date_naissance, String adresse, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.age = age;
    }
  

    public enfant(String id_enfant, String nom, String prenom, String date_naissance, String adresse, int age, Parent parent) {
        this.id_enfant = id_enfant;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.age = age;
        this.parent= parent;
    }

    public String getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(String id_enfant) {
        this.id_enfant = id_enfant;
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

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public Object getParent() {
        return parent;
    }
    public void setParent(Parent p){
        this.parent = parent;
    }

    

    @Override
    public String toString() {
        return "Enfant{" + "id_enfant=" + id_enfant + ", nom=" + nom + ", prenom=" + prenom + ", date_naissance=" + date_naissance + ", adresse=" + adresse + ", age=" + age + ",parent"+ parent+'}';
    }


}
