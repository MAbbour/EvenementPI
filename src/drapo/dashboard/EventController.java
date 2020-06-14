/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import com.esprit.Entite.Evenement;
import com.esprit.Service.ServiceEvenement;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
//import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class EventController implements Initializable {
    
   /*
    
    public String lieu;
    public String nom;
    public String prix;
    public String date_event;*/
    @FXML
    private Label LieuLabel;
    @FXML
    private Label PrixLabel;
    @FXML
    private Label NomLabel;
    @FXML
    private Label dayLabel;
    @FXML
    private Label idLabel;
    
   
/*
    public EventController(String lieu, String nom, String prix, String date_event) {
        this.lieu = lieu;
        this.nom = nom;
        this.prix = prix;
        this.date_event = date_event;
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

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getDate_event() {
        return date_event;
    }

    public void setDate_event(String date_event) {
        this.date_event = date_event;
    }


    private Label Lieu1Label;
    private Label Nom1Label;
    private Label Prix1Label;
    private Label day1Label;
    
       
       
          */
   
    private Evenement selectedEvenement;

   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //afficher_item();
    }    
    /*
      public void initData(Evenement evenement){
        
            //selectedEvenement = evenement;
            Evenement evenement1 = new Evenement();
            //Id_eventLabel.setText(Integer.toString(selectedEvenement.getId_event()));
            
            Lieu1Label.setText(evenement1.getLieu());
            Nom1Label.setText(evenement1.getNom());
            Prix1Label.setText(Float.toString(evenement1.getPrix()));
            //Nb_placesLabel.setText(Integer.toString(selectedEvenement.getBn_places()));
            day1Label.setText(evenement1.getDate_Event());
        
    }*/
    
  /*
     public void afficher_item(){
        
        Lieu1Label.setText(lieu);
        Nom1Label.setText(nom);
        Prix1Label.setText(String.valueOf(prix));
        day1Label.setText(date_event);
    }*/
    

  

    @FXML
    private void inscription(ActionEvent event) {
        
           try {
              Node node = (Node) event.getSource();
              Stage stage = (Stage) node.getScene().getWindow();
              //stage.setMaximized(true);
              stage.close();
              Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Item_inscri_event.fxml")));
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
      
      
    
   
  
    
}
