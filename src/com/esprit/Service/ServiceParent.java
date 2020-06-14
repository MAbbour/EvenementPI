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

public class ServiceParent {
     private Connection con;
    private Statement ste;

    public ServiceParent() {
        con = DataBase.getInstance().getConnection();

    }
    
    public void ajouter(Parent t) throws SQLException {
             String requete = "insert into parent (nom, prenom, mail, tel, nb_enfant, mdp) values (?,?,?,?,?,?)";
        if (t.getNom() != null) {
                PreparedStatement pst = con.prepareStatement(requete);
                pst.setString(1, t.getNom());
                pst.setString(2, t.getPrenom());
                pst.setString(3, t.getMail());
                pst.setInt(4, t.getTel());
                pst.setInt(5, t.getNb_enfant());
                pst.setString(6, t.getMdp());

                pst.executeUpdate();
    }

        
    }

   /*
    public boolean delete(Parent t) throws SQLException {
        if (t.getId_parent()!= 0) {
            PreparedStatement pre = con.prepareStatement("delete from parent");
            pre.setInt(1, t.getId_parent());

            pre.executeUpdate();

        }

        return true;
    }*/
    
          public List<enfant> readAllEnfant2(int i) throws SQLException {
    List<enfant> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from enfant WHERE parent ='" + i + "' ");
     while (rs.next()) {                
               int id_enfant=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               String date_naissance=rs.getString("date_naissance");
               String adresse=rs.getString(5);
               int age= rs.getInt(6);
               int id_parent= rs.getInt(7);
               
               enfant p=new enfant(id_enfant, nom, prenom, date_naissance, adresse, age, id_parent);
     arr.add(p);
     }
    return arr;
    }
     public void delete1(int id_parent) {
              try {
            if(id_parent != 0){
                
                PreparedStatement pstm = con.prepareStatement("delete from parent where id_parent=?");
                pstm.setInt(1, id_parent);
                int i = pstm.executeUpdate();
                System.out.println(i+"Data deleted succefully");
                
            }
            
        } catch (Exception e) {
        }
        
    }

   
    public boolean update(Parent t) throws SQLException {
        String requete = "update parent set  nom=?, prenom=?, mail=?, tel=?, nb_enfant=?, mdp=? where id_parent=?";
         if (t.getId_parent()!= 0) {
                PreparedStatement pst = con.prepareStatement(requete);
                pst.setString(1, t.getNom());
                pst.setString(2, t.getPrenom());
                pst.setString(3, t.getMail());
                pst.setInt(4, t.getTel());
                pst.setInt(5, t.getNb_enfant());
                pst.setString(6, t.getMdp());
                pst.setInt(7, t.getId_parent());
              
               pst.executeUpdate();
               

            }
         return true;
    }

    
    public List<Parent> readAll() throws SQLException {
        List<Parent> parents = new ArrayList<>();
        Parent parent = null;
         
            PreparedStatement pstm = con.prepareStatement("select * from parent ");
            
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                parent = new Parent();
                parent.setId_parent(rs.getInt(1));
                parent.setNom(rs.getString(2));
                parent.setPrenom(rs.getString(3));
                parent.setMail(rs.getString(4));
                parent.setTel(rs.getInt(5));
                parent.setNb_enfant(rs.getInt(6));
                parent.setMdp(rs.getString(7));
                parents.add(parent);
                
            }
            return parents;
    }
         public void chercher(String nom){
        String requete = "select * from parent where nom='"+nom+"'";
        
        try {
            Statement st = con.createStatement();
            st.executeQuery(requete);
            ResultSet rs = st.executeQuery(requete);
            rs.last();
            int nbRow = rs.getRow();
            if(nbRow != 0){
                System.out.println("parent trouvée");
            }else{
                System.out.println("parent non trouvée");
            }
        } catch (Exception ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
         public Parent getParent(int id_parent) {
        Parent parent = null;
        try {
            PreparedStatement pstm = con.prepareStatement("select * from parent where id_parent = ?");
            pstm.setInt(1, id_parent);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                parent = new Parent();
                parent.setId_parent(rs.getInt(1));
                parent.setNom(rs.getString(2));
                parent.setPrenom(rs.getString(3));
                parent.setMail(rs.getString(4));
                parent.setTel(rs.getInt(5));
                parent.setNb_enfant(rs.getInt(6));
                parent.setMdp(rs.getString(7));
                
            }
        } catch (Exception e) {
            
        }
        return parent;
    }
}
