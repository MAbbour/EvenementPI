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
        String requete = "insert into Inscription_evenement (prix, id_event, id_enfant) values (?,?,?)";
        
            PreparedStatement pst = con.prepareStatement(requete);

            pst.setFloat(1, t.getPrix());
            pst.setInt(2, t.getId_enfant());
            pst.setInt(3, t.getId_event());

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
            Inscription_evenement e = new Inscription_evenement();
            e.setId_insc(rs.getInt(1));
            e.setPrix(rs.getFloat(2));

            arr.add(e);

        }
        return arr;
    }

  

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
                //     Inscription_evenement.setId_parent(rs.getInt(3));
                //   Inscription_evenement.setId_event(rs.getInt(4));

            }
        } catch (Exception e) {

        }
        return Inscription_evenement;
    }

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
    }

}
