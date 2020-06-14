/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

/**
 *
 * @author Acer
 */

import com.esprit.Entite.Evenement;
import com.esprit.Entite.Parent;
import com.esprit.Entite.enfant;

import com.esprit.IService.IService;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ServiceEnfant {
    
    private Connection con;
    private Statement ste;

    public ServiceEnfant() {
        con = DataBase.getInstance().getConnection();
    }

    
    public void ajouter(enfant p) throws SQLException {
        String requete = "insert into enfant ( nom, prenom, date_naissance, adresse, age, parent) values ( ?,?,?,?,?,?);";
        PreparedStatement pst = con.prepareStatement(requete);
        pst.setString(1, p.getNom());
        pst.setString(2, p.getPrenom());
        pst.setString(3, p.getDate_naissance());
        pst.setString(4, p.getAdresse());
        pst.setInt(5, p.getAge());
        pst.setInt(6, p.getId_parent());
       //pst.setInt(6, p.getParent());

        pst.executeUpdate();
    }

    /*
    public boolean delete(enfant t) throws SQLException {

        if (t.getId_enfant() != 0) {
            PreparedStatement pre = con.prepareStatement("delete from enfant where id_enfant = ?");
            pre.setInt(1, t.getId_enfant());

            pre.executeUpdate();

        }

        return true;

    }*/
    
     public void delete1(int id_enfant) {
              try {
            if(id_enfant != 0){
                
                PreparedStatement pstm = con.prepareStatement("delete from enfant where id_enfant=?");
                pstm.setInt(1, id_enfant);
                int i = pstm.executeUpdate();
                System.out.println(i+"Data deleted succefully");
                
            }
            
        } catch (Exception e) {
        }
        
    }

    
    public boolean update(enfant t) throws SQLException {
        String requete = "update enfant set nom=?, prenom=?, date_naissance=?, adresse=?, age=?, parent=? where id_enfant=?";
         if (t.getId_enfant() != 0) {
                PreparedStatement pst = con.prepareStatement(requete);
                pst.setString(1, t.getNom());
                pst.setString(2, t.getPrenom());
                pst.setString(3, t.getDate_naissance());
                pst.setString(4, t.getAdresse());
                pst.setInt(5, t.getAge());
                pst.setObject(6, t.getParent());
                pst.setInt(7, t.getId_enfant());

               pst.executeUpdate();
               

            }
         return true;
    }

    
    public List<enfant> readAll() throws SQLException {
        List<enfant> arr = new ArrayList<>();
        enfant e = null;
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from enfant");
        while(rs.next()){
                e = new enfant();
                e.setId_enfant(rs.getInt(1));
                e.setNom(rs.getString(2));
                e.setPrenom(rs.getString(3));
                e.setDate_naissance(rs.getString(4));
                e.setAdresse(rs.getString(5));
                e.setAge(rs.getInt(6));
                e.setParent(rs.getObject(7, Parent.class));
                arr.add(e);
                
            }
        return arr;
    }
    
      public void chercher(String nom){
        String requete = "select * from enfant where nom='"+nom+"'";
        
        try {
            Statement st = con.createStatement();
            st.executeQuery(requete);
            ResultSet rs = st.executeQuery(requete);
            rs.last();
            int nbRow = rs.getRow();
            if(nbRow != 0){
                System.out.println("enfant trouvée");
            }else{
                System.out.println("enfant non trouvée");
            }
        } catch (Exception ex) {
            Logger.getLogger(ServiceEnfant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public enfant getEnfant(int id_enfant) {
        enfant enfant = null;
        try {
            PreparedStatement pstm = con.prepareStatement("select * from enfant where id_enfant = ?");
            pstm.setInt(1, id_enfant);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                enfant = new enfant();
                enfant.setId_enfant(rs.getInt(1));
                enfant.setNom(rs.getString(2));
                enfant.setPrenom(rs.getString(3));
                //enfant.setDate_naissance(rs.getString(4));
                //enfant.setAdresse(rs.getString(5));
                //enfant.setAge(rs.getInt(6));
                //enfant.setParent(rs.getObject(7, Parent.class));
                
            }
        } catch (Exception e) {
            
        }
        return enfant;
    }
            public enfant getEnfant2(int id_insc) {
        enfant enfant = null;
        try {
            PreparedStatement pstm = con.prepareStatement("select * from enfant where id_insc = ?");
            pstm.setInt(1, id_insc);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                enfant = new enfant();
                enfant.setId_enfant(rs.getInt(1));
                enfant.setNom(rs.getString(2));
                enfant.setPrenom(rs.getString(3));
                enfant.setDate_naissance(rs.getString(4));
                enfant.setAdresse(rs.getString(5));
                enfant.setAge(rs.getInt(6));
                //enfant.setParent(rs.getObject(7, Parent.class));
                
            }
        } catch (Exception e) {
            
        }
        return enfant;
    }

}

    

