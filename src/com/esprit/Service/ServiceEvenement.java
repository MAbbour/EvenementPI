
package com.esprit.Service;

import com.esprit.IService.IService;
import com.esprit.Entite.Evenement;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceEvenement implements IService<Evenement>{
     private Connection con;
    private Statement ste;

    public ServiceEvenement() {
        con = DataBase.getInstance().getConnection();
    }
    
    
    

    @Override
    public void ajouter(Evenement t) throws SQLException {
        //Date d1 = new Date();
        String requete = "INSERT INTO `evenement` (`lieu`, `nom`, `prix`, `nb_places`,`date_event`) VALUES (?,?,?,?,?)";
           
        if (t.getNom() != null) {
                PreparedStatement pst = con.prepareStatement(requete);
                pst.setString(1, t.getLieu());
                pst.setString(2, t.getNom());
                pst.setFloat(3, t.getPrix());
                pst.setInt(4, t.getBn_places());
                pst.setString(5, t.getDate_Event());

                pst.executeUpdate();
                 
    }

        
    }
     
    @Override
    public boolean delete(Evenement t) throws SQLException {
        if (t.getId_event()!= 0) {
            PreparedStatement pre = con.prepareStatement("delete from evenement where id_enfant = ?");
            pre.setInt(1, t.getId_event());

            pre.executeUpdate();

        }

        return true;
    }
     public void delete1(int id_event) {
              try {
            if(id_event != 0){
                
                PreparedStatement pstm = con.prepareStatement("delete from evenement where id_event=?");
                pstm.setInt(1, id_event);
                int i = pstm.executeUpdate();
                System.out.println(i+"Data deleted succefully");
                
            }
            
        } catch (Exception e) {
        }
        
    }

    @Override
    public boolean update(Evenement t) throws SQLException {
        
        String requete = "update evenement set lieu=?, nom=?, prix=?, nb_places=?, date_event=? where id_event=?";
         if (t.getId_event()!= 0) {
                PreparedStatement pst = con.prepareStatement(requete);
                pst.setString(1, t.getLieu());
                pst.setString(2, t.getNom());
                pst.setFloat(3, t.getPrix());
                pst.setInt(4, t.getBn_places());
                pst.setString(5, t.getDate_Event());
                pst.setInt(6, t.getId_event());
                

              pst.executeUpdate();
               

            }
         return true;
    }
    
       public String listEvenement(){
        String mail="";
        try {
            
            String requete2 = "SELECT * FROM evenement";
            PreparedStatement pst = con.prepareStatement(requete2);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                mail +="\n----------\n";
                Evenement a = new Evenement();
                a.setId_event(rs.getInt(1));
                a.setLieu(rs.getString(2));
                a.setNom(rs.getString(3));
                a.setPrix(rs.getFloat(4));
                a.setBn_places(rs.getInt(5));
                a.setDate_Event(rs.getString(6));
                
                mail +="L'evenement:";
                mail +="\n  Lieu = " + a.getLieu();
                mail +="\n  Nom = " + a.getNom();
                mail +="\n  Prix = " + a.getPrix();
                mail +="\n  Nombre de places = " + a.getBn_places();
                mail +="\n  Date = " + a.getDate_Event();
                
                /*
                mail +="\n  Les enfants qui vont participer sont : ";
                List<Enfant> KidList = IdEnfants();
                for (Enfant en : KidList) {
                    if (idList.contains(en.getIdEnfant())) {
                        mail +="\n      l'enfant " + en.getIdEnfant() + " " + en.getNom() + " " + en.getPrenom();
                    }
                }
                List<Animateur> animList = IdAnimateurs();
                mail +="\n  Les animateurs sont : ";
                for (Animateur an : animList) {
                    if (idList1.contains(an.getAnimID())) {
                        mail +="\n      l'animateur " + an.getAnimID() + " " + an.getNom() + " " + an.getPrenom();
                    }
                }*/
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mail;
    }

    @Override
    public List<Evenement> readAll() throws SQLException {
        List<Evenement> evenements = new ArrayList<>();
        Evenement evenement = null;
         
            PreparedStatement pstm = con.prepareStatement("select * from evenement ");
            
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                evenement = new Evenement();
                evenement.setId_event(rs.getInt(1));
                evenement.setLieu(rs.getString(2));
                evenement.setNom(rs.getString(3));
                evenement.setPrix(rs.getFloat(4));
                evenement.setBn_places(rs.getInt(5));
                evenement.setDate_Event(rs.getString(6));
                evenements.add(evenement);
                
            }
            return evenements;
    }
     public ArrayList<Evenement> chercher(String besoin, String caractere){
         
         ArrayList<Evenement> evenements = new ArrayList<>();
        String requete = "select * from evenement where " + besoin + " LIKE '" + caractere + "%'";
        /*
        
        try {
            Statement st = con.createStatement();
            st.executeQuery(requete);
            ResultSet rs = st.executeQuery(requete);
            rs.last();
            int nbRow = rs.getRow();
            if(nbRow != 0){
                System.out.println("Evenement trouvée");
                System.out.println(this.getEvenement(rs.getInt(1)));
            }else{
                System.out.println("Evenement non trouvée");
            }
        } catch (Exception ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
         try {
            PreparedStatement pst2 = con.prepareStatement(requete);
            pst2.executeQuery();
            System.out.println("recherche done");

            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Evenement a = new Evenement();
                a.setId_event(rs.getInt(1));
                a.setLieu(rs.getString(2));
                a.setNom(rs.getString(3));
                a.setPrix(rs.getFloat(4));
                a.setBn_places(rs.getInt(5));
                a.setDate_Event(rs.getString(6));
                
                evenements.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenements;
    }
     public Evenement getEvenement(int id_event) {
        Evenement evenement = null;
        try {
            PreparedStatement pstm = con.prepareStatement("select * from evenement where id_event = ?");
            pstm.setInt(1, id_event);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                evenement = new Evenement();
                evenement.setId_event(rs.getInt(1));
                evenement.setLieu(rs.getString(2));
                evenement.setNom(rs.getString(3));
                evenement.setPrix(rs.getFloat(4));
                evenement.setBn_places(rs.getInt(5));
                evenement.setDate_Event(rs.getString(6));
                
            }
        } catch (Exception e) {
            
        }
        return evenement;
    }
     
       public Evenement getEvenement2(int id_insc) {
        Evenement evenement = null;
        try {
            PreparedStatement pstm = con.prepareStatement("select * from evenement where id_insc = ?");
            pstm.setInt(1, id_insc);
            ResultSet rs = pstm.executeQuery();
             
            while(rs.next()){
                evenement = new Evenement();
                //evenement.setId_event(rs.getInt(1));
               // evenement.setLieu(rs.getString(2));
             evenement.setNom(rs.getString(3));
                //evenement.setPrix(rs.getFloat(4));
                //evenement.setBn_places(rs.getInt(5));
                //evenement.setDate_Event(rs.getString(6));
                
            }
        } catch (Exception e) {
            
        }
         
        return evenement;
    }
       
       public int getIdEvenement(String nom){
        
         int i = 0;
        try {
            PreparedStatement pstm = con.prepareStatement("select * from evenement where nom = ?");
            pstm.setString(1, nom);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){ 
                i=rs.getInt(1);
                
            }
        } catch (Exception e) {
            
        }
        return i;
       }
       
         public Float getPrixEvenement(String nom){
        
         Float k = null;
        try {
            PreparedStatement pstm = con.prepareStatement("select * from evenement where nom = ?");
            pstm.setString(1, nom);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){ 
                k=rs.getFloat(4);
                
            }
        } catch (Exception e) {
            
        }
         return k ;
        
       }
       
       
     
     
        public void trierEvenement(String o) {
        try {

            String requete2 = "select * from evenement order by '" +o+"'";
            
            PreparedStatement pst = con.prepareStatement(requete2);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Evenement ev = new Evenement();
                ev.setId_event(rs.getInt(1));
                ev.setLieu(rs.getString(2));
                ev.setNom(rs.getString(3));
                ev.setPrix(rs.getFloat(4));
                ev.setBn_places(rs.getInt(5));
                ev.setDate_Event(rs.getString(6));
                
                System.out.println(ev);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
}
