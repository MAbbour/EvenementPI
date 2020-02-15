/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

/**
 *
 * @author Acer
 */
public class Inscription_evenement {
    private int id_insc;
    private float prix;
    private int Id_enfant;
    private int Id_event;

    public Inscription_evenement() {
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
        return "Inscription_evenement{" + "id_insc=" + id_insc + ", prix=" + prix + ", Id_enfant=" + Id_enfant + ", Id_event=" + Id_event + '}';
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
