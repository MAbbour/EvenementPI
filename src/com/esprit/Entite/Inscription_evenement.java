/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import com.esprit.Service.ServiceEnfant;
import com.esprit.Service.ServiceEvenement;

/**
 *
 * @author Acer
 */
public class Inscription_evenement {
    private int id_insc;
    private float prix;
    private int Id_enfant;
    private int Id_event;
    private String date_insc;
    private String nom_enfant;
    private String nom_evenemment;
    
    public Inscription_evenement() {
    }

    public Inscription_evenement(int id_insc, float prix, String date_insc, String nom_enfant, String nom_evenemment) {
        this.id_insc = id_insc;
        this.prix = prix;
        this.date_insc = date_insc;
        this.nom_enfant = nom_enfant;
        this.nom_evenemment = nom_evenemment;
    }

    public Inscription_evenement(float prix, int Id_enfant, int Id_event, String date_insc, String nom_enfant, String nom_evenemment) {
        this.prix = prix;
        this.Id_enfant = Id_enfant;
        this.Id_event = Id_event;
        this.date_insc = date_insc;
        this.nom_enfant = nom_enfant;
        this.nom_evenemment = nom_evenemment;
    }
    
    

    public Inscription_evenement(int id_insc, float prix, int Id_enfant, int Id_event,String date_insc, String nom_enfant, String nom_evenemment) {
        this.id_insc = id_insc;
        this.prix = prix;
        this.Id_enfant = Id_enfant;
        this.Id_event = Id_event;
        this.date_insc = date_insc;
        
        ServiceEnfant serv = new ServiceEnfant();
        String nom = serv.getEnfant(Id_enfant).getNom()+" "+serv.getEnfant(Id_enfant).getPrenom();
        this.nom_enfant = nom;
        
        
        ServiceEvenement seven = new ServiceEvenement();
        String nomev = seven.getEvenement(Id_event).getNom();
        this.nom_evenemment = nomev;
    }

    public Inscription_evenement(int id_insc, float prix, int Id_enfant, int Id_event, String date_insc) {
        this.id_insc = id_insc;
        this.prix = prix;
        this.Id_enfant = Id_enfant;
        this.Id_event = Id_event;
        this.date_insc = date_insc;
        ServiceEnfant serv = new ServiceEnfant();
        String nom = serv.getEnfant(Id_enfant).getNom()+" "+serv.getEnfant(Id_enfant).getPrenom();
        this.nom_enfant = nom;
        
        
        ServiceEvenement seven = new ServiceEvenement();
        String nomev = seven.getEvenement(Id_event).getNom();
        this.nom_evenemment = nomev;
    }

    public Inscription_evenement(float prix, int Id_enfant, int Id_event, String date_insc) {
        this.prix = prix;
        this.Id_enfant = Id_enfant;
        this.Id_event = Id_event;
        this.date_insc = date_insc;
    }

   
    
    

    public String getDate_insc() {
        return date_insc;
    }

    public void setDate_insc(String date_insc) {
        this.date_insc = date_insc;
    }
    
    
    

    public String getNom_enfant() {
        return nom_enfant;
    }

    public void setNom_enfant(String nom_enfant) {
        this.nom_enfant = nom_enfant;
    }

    public String getNom_evenemment() {
        return nom_evenemment;
    }

    public void setNom_evenemment(String nom_evenemment) {
        this.nom_evenemment = nom_evenemment;
    }
    
    

    public Inscription_evenement(int id_insc, float prix) {
        this.id_insc = id_insc;
        this.prix = prix;
    }
    

    public Inscription_evenement(float prix, int Id_enfant, int Id_event) {
        this.prix = prix;
        this.Id_enfant = Id_enfant;
        this.Id_event = Id_event;
    }
    

    public Inscription_evenement(int id_insc, float prix, int Id_enfant, int Id_event) {
        this.id_insc = id_insc;
        this.prix = prix;
        this.Id_enfant = Id_enfant;
        this.Id_event = Id_event;
    }

    public int getId_insc() {
        return id_insc;
    }

    public void setId_insc(int id_insc) {
        this.id_insc = id_insc;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId_enfant() {
        return Id_enfant;
    }

    public void setId_enfant(int Id_enfant) {
        this.Id_enfant = Id_enfant;
    }

    public int getId_event() {
        return Id_event;
    }

    public void setId_event(int Id_event) {
        this.Id_event = Id_event;
    }

    @Override
    public String toString() {
        return "Inscription_evenement{" + "id_insc=" + id_insc + ", prix=" + prix + ", Id_enfant=" + Id_enfant + ", Id_event=" + Id_event + ", date_insc=" + date_insc + ", nom_enfant=" + nom_enfant + ", nom_evenemment=" + nom_evenemment + '}';
    }

      

    

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscription_evenement other = (Inscription_evenement) obj;
        if (this.id_insc != other.id_insc) {
            return false;
        }
        if (this.Id_enfant != other.Id_enfant) {
            return false;
        }
        if (this.Id_event != other.Id_event) {
            return false;
        }
        return true;
    }

    
    
}
