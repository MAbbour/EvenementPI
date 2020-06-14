package com.esprit.Service;

import com.esprit.Entite.Inscription_evenement;
import com.esprit.Entite.enfant;
import com.esprit.Entite.Evenement;
import com.esprit.Entite.Parent;
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

public class ServiceInscription_evenement implements IService<Inscription_evenement> {

    private Connection con;
    private Statement ste;

    public ServiceInscription_evenement() {
        con = DataBase.getInstance().getConnection();

    }
    
    

    @Override
    public void ajouter(Inscription_evenement t) throws SQLException {
        String requete = "insert into Inscription_evenement (prix,id_enfant, id_event, date_insc, nom_enfant, nom_evenemment) values (?,?,?,?,?,?)";
        
            PreparedStatement pst = con.prepareStatement(requete);

            pst.setFloat(1, t.getPrix());
            pst.setInt(2, t.getId_enfant());
            pst.setInt(3, t.getId_event());
            pst.setString(4, t.getDate_insc());
            pst.setString(5, t.getNom_enfant());
            pst.setString(6, t.getNom_evenemment());

            pst.executeUpdate();
            System.out.println("Inscription ajouté !");
        
    }
    
     public void ajouter2(Inscription_evenement t) throws SQLException {
        String requete = "insert into Inscription_evenement (prix,id_enfant, id_event, date_insc) values (?,?,?,?)";
        
            PreparedStatement pst = con.prepareStatement(requete);

            pst.setFloat(1, t.getPrix());
            pst.setInt(2, t.getId_enfant());
            pst.setInt(3, t.getId_event());
            pst.setString(4, t.getDate_insc());
           
            pst.executeUpdate();
            System.out.println("Inscription ajouté !");
        
    }
    
    

    @Override
    public boolean delete(Inscription_evenement t) throws SQLException {
        if (t.getId_insc() != 0) {
            PreparedStatement pre = con.prepareStatement("delete from Inscription_evenement where id_insc = ?");
            pre.setInt(1, t.getId_insc());

            pre.executeUpdate();
            

        }

        return true;
    }

    public void delete(int id_insc) {
        try {
            if (id_insc != 0) {

                PreparedStatement pstm = con.prepareStatement("delete from Inscription_evenement where id_insc=?");
                pstm.setInt(1, id_insc);
                int i = pstm.executeUpdate();
                System.out.println(i + "Data deleted succefully");

            }

        } catch (Exception e) {
        }

    }

    @Override
    public boolean update(Inscription_evenement t) throws SQLException {
        String requete = "update inscription_evenement set  prix=?  where id_insc=? ";
        
            PreparedStatement pst = con.prepareStatement(requete);
            pst.setFloat(1, t.getPrix());
           
            pst.setInt(2, t.getId_insc());

            pst.executeUpdate();

        
        return true;
    }

    @Override
    public List<Inscription_evenement> readAll() throws SQLException {
        List<Inscription_evenement> arr = new ArrayList<>();
       
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from Inscription_evenement");
        while (rs.next()) {
            Inscription_evenement e = new Inscription_evenement(rs.getInt(1),rs.getFloat(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
          /*  e.setId_insc(rs.getInt(1));
            e.setPrix(rs.getFloat(2));
            e.setId_enfant(rs.getInt(3));
            e.setId_event(rs.getInt(4));
            e.setDate_insc(rs.getString(5));
            e.setNom_enfant(rs.getString(3));
            e.setNom_evenemment(rs.getString(4));*/

            arr.add(e);

        }
        return arr;
    }

       public List<Inscription_evenement> cherchertouteinscription1enfant(int id_enfant) throws SQLException {
        List<Inscription_evenement> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from Inscription_evenement where id_enfant='" + id_enfant + "' order by date_insc");
        while (rs.next()) {
            int id = rs.getInt(1);
            Float ide = rs.getFloat(2);
            int idc = rs.getInt(3);
            int nbj = rs.getInt(4);
            String pri = rs.getString(5);
            

            Inscription_evenement p = new Inscription_evenement(id, ide, idc, nbj, pri);
            arr.add(p);
        }
        return arr;
    }
  
/*
    public void chercher1(String Id_insc) {
        String requete = "select * from inscription_evenement where id_insc=?";

        try {
            Statement st = con.createStatement();
            st.executeQuery(requete);
            ResultSet rs = st.executeQuery(requete);
            rs.last();
            int nbRow = rs.getRow();
            if (nbRow != 0) {
                System.out.println("inscription trouvée");
            } else {
                System.out.println("inscription non trouvée");
            }
        } catch (Exception ex) {
            Logger.getLogger(ServiceInscription_evenement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */

    public Inscription_evenement getInscription(int id_insc) {
        Inscription_evenement Inscription_evenement = null;
        try {
            PreparedStatement pstm = con.prepareStatement("select * from Inscription_evenement where id_insc = ?");
            pstm.setInt(1, id_insc);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Inscription_evenement = new Inscription_evenement();
                Inscription_evenement.setId_insc(rs.getInt(1));
                Inscription_evenement.setPrix(rs.getFloat(2));
                Inscription_evenement.setId_enfant(rs.getInt(3));
                Inscription_evenement.setId_event(rs.getInt(4));

            }
        } catch (Exception e) {

        }
        return Inscription_evenement;
    }
    
    
     public String getInscription2(int id_insc) {
         String mail="";
        try {
            
            String requete2 = "select * from Inscription_evenement where id_insc = ?";
            PreparedStatement pst = con.prepareStatement(requete2);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                mail +="\n----------\n";
                Inscription_evenement a = new Inscription_evenement();
                a.setId_insc(rs.getInt(1));
                a.setPrix(rs.getFloat(2));
                a.setId_enfant(rs.getInt(3));
                a.setId_event(rs.getInt(4));
                a.setDate_insc(rs.getString(5));
                a.setNom_enfant(rs.getString(6));
                a.setNom_evenemment(rs.getString(7));
                
                mail +="L'inscription:";
                mail +="\n  Nom de l'enfant = " + a.getNom_enfant();
                mail +="\n  Nom de l'événement = " + a.getNom_evenemment();
                mail +="\n  Prix = " + a.getPrix();
               mail +="\n  Date = " + a.getDate_insc();
                
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
    

/*
    public void chercher(int Id_event) {
         String requete = "select * from inscription_evenement where id_event='"+Id_event+"'";
         
         

        try {
            Statement st = con.createStatement();
            st.executeQuery(requete);
            ResultSet rs = st.executeQuery(requete);
            rs.last();
            int nbRow = rs.getRow();
            if (nbRow != 0) {
                
                System.out.println("inscription trouvée");
                ServiceEvenement se = new ServiceEvenement();
                System.out.println(se.getEvenement(Id_event));
            } else {
                System.out.println("inscription non trouvée");
            }
        } catch (Exception ex) {
            Logger.getLogger(ServiceInscription_evenement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    public List<Inscription_evenement> rechercheIdEvent(int Id_event) throws SQLException {
        List<Inscription_evenement> arr = new ArrayList<>();
       String requete = "select * from inscription_evenement where id_event='"+Id_event+"'";
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(requete);
        while (rs.next()) {
            Inscription_evenement e = new Inscription_evenement();
            e.setId_insc(rs.getInt(1));
            e.setPrix(rs.getFloat(2));
            e.setId_enfant(rs.getInt(3));
            e.setId_event(rs.getInt(4));
            e.setDate_insc(rs.getString(5));

            arr.add(e);

        }
        return arr;
    }
       public List<Inscription_evenement> rechercheIdInscri(int id_insc) throws SQLException {
        List<Inscription_evenement> arr = new ArrayList<>();
         
         String requete = "select * from inscription_evenement where id_insc='"+id_insc+"'";
       
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(requete);
        while (rs.next()) {
            Inscription_evenement e = new Inscription_evenement();
            e.setId_insc(rs.getInt(1));
            e.setPrix(rs.getFloat(2));

            arr.add(e);

        }
        return arr;
    }
    
       
       
    public List<String> affichtsinscri() {
        try {

            String requete2 = "select  enfant.nom, enfant.prenom, evenement.nom from Inscription_evenement,enfant, evenement where enfant.id_insc=evenement.id_insc";
            List<String> arr = new ArrayList<>();
            PreparedStatement pst = con.prepareStatement(requete2);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
                String nom = rs.getString(1);
                String prenom = rs.getString(2);
                String nm = nom + " " + prenom;
                String nom2 = rs.getString(3);
                
                arr.add(nm);
                arr.add(nom2);

            }
            return arr;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;

    }
       
       
       
       
       
       

}
