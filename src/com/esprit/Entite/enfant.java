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
    private int id_enfant;
    private String nom;
    private String prenom;
    private String date_naissance;
    private String adresse;
    private int age;
    private int id_parent;
    private int id_insc;
    Parent parent;

    public enfant() {
    }

    public enfant(int id_enfant, String nom, String prenom, String date_naissance, String adresse, int age, int id_parent, int id_insc) {
        this.id_enfant = id_enfant;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.age = age;
        this.id_parent = id_parent;
        this.id_insc = id_insc;
    }
    

    public enfant(int id_enfant, String nom, String prenom, String date_naissance, String adresse, int age, int id_parent) {
        this.id_enfant = id_enfant;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.age = age;
        this.id_parent = id_parent;
    }
    
    

    public enfant(int id_enfant, String nom, String prenom, String date_naissance, int id_parent) {
        this.id_enfant = id_enfant;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.id_parent = id_parent;
    }

    public int getId_parent() {
        return id_parent;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public enfant(String nom, String prenom, String date_naissance, String adresse, int age, int id_parent) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.age = age;
        this.id_parent = id_parent;
    }

    
    public enfant(String nom, String prenom, String date_naissance, String adresse, int age, Parent parent) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.age = age;
        this.parent= parent;
    }

    public enfant(int id_enfant, String nom, String prenom, String date_naissance) {
        this.id_enfant = id_enfant;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
    }
    

    public enfant(String nom, String prenom, String date_naissance, String adresse, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.age = age;
    }
  

    public enfant(int id_enfant, String nom, String prenom, String date_naissance, String adresse, int age, Parent parent) {
        this.id_enfant = id_enfant;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.age = age;
        this.parent= parent;
    }

    public int getId_insc() {
        return id_insc;
    }

    public void setId_insc(int id_insc) {
        this.id_insc = id_insc;
    }
    
    
    

    public int getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(int id_enfant) {
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
    
    public Parent getParent() {
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
