/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class Evenement {
      public int id_event;
    private String lieu;
    private String nom;
    private float prix;
    private int nb_places;
    private String date_event;
    private int id_insc;
    List<Inscription_evenement> listinseve;
    
    public Evenement() {        
        listinseve = new ArrayList<>();
    }

    public int getId_insc() {
        return id_insc;
    }

    public void setId_insc(int id_insc) {
        this.id_insc = id_insc;
    }

    public Evenement(int id_event, String lieu, String nom, float prix, int nb_places, String date_event, int id_insc) {
        this.id_event = id_event;
        this.lieu = lieu;
        this.nom = nom;
        this.prix = prix;
        this.nb_places = nb_places;
        this.date_event = date_event;
        this.id_insc = id_insc;
    }

    public Evenement(int id_event, String lieu, String nom, float prix, String date_event) {
        this.id_event = id_event;
        this.lieu = lieu;
        this.nom = nom;
        this.prix = prix;
        this.date_event = date_event;
    }
    

    public Evenement(int id_event, String lieu, String nom, float prix, int bn_places, String date_event) {
        listinseve = new ArrayList<>();
        this.id_event = id_event;
        this.lieu = lieu;
        this.nom = nom;
        this.prix = prix;
        this.nb_places = bn_places;
        this.date_event = date_event;
    }

    
    

    public Evenement(String lieu, String nom, float prix, int bn_places, String date_event) {
        listinseve = new ArrayList<>();
        this.lieu = lieu;
        this.nom = nom;
        this.prix = prix;
        this.nb_places = bn_places;
        this.date_event=date_event;
    }

    
     public Evenement(String lieu, String nom, float prix, String date_event) {
        listinseve = new ArrayList<>();
        this.lieu = lieu;
        this.nom = nom;
        this.prix = prix;
        
        this.date_event=date_event;
    }
    

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getBn_places() {
        return nb_places;
    }

    public void setBn_places(int bn_places) {
        this.nb_places = bn_places;
    }
    
    public String getDate_Event(){
        return this.date_event;
    }
    
    public void setDate_Event(String date_event){
        this.date_event = date_event;
    }
    public List<Inscription_evenement> getListinscant() {
        return listinseve;
    }

    public int getNb_places() {
        return nb_places;
    }

    public void setNb_places(int nb_places) {
        this.nb_places = nb_places;
    }

    public void setDate_event(String date_event) {
        this.date_event = date_event;
    }

    public void setListinseve(List<Inscription_evenement> listinseve) {
        this.listinseve = listinseve;
    }

    public String getDate_event() {
        return date_event;
    }

    public List<Inscription_evenement> getListinseve() {
        return listinseve;
    }
    
    

    @Override
    public String toString() {
        return "Evenement{" + "id_event=" + id_event + ", lieu=" + lieu + ", nom=" + nom + ", prix=" + prix + ", nb_places=" + nb_places + ", date_event=" + date_event + ", id_insc=" + id_insc + ", listinseve=" + listinseve + '}';
    }

    
    
}
