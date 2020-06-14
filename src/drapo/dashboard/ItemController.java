/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import com.esprit.Entite.Evenement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class ItemController implements Initializable {


   private Evenement selectedEvenement;
    
    @FXML private Label Id_eventLabel;
    @FXML private Label LieuLabel;
    @FXML private Label NomLabel;
    @FXML private Label PrixLabel;
    @FXML private Label Nb_placesLabel;
    @FXML private Label dayLabel;

  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }  
    
  
    
    //this method accept a person to initialize the wiew 
    
    public void initData(Evenement evenement){
        selectedEvenement = evenement;
        Id_eventLabel.setText(Integer.toString(selectedEvenement.getId_event()));
        LieuLabel.setText(selectedEvenement.getLieu());
        NomLabel.setText(selectedEvenement.getNom());
        PrixLabel.setText(Float.toString(selectedEvenement.getPrix()));
        Nb_placesLabel.setText(Integer.toString(selectedEvenement.getBn_places()));
        dayLabel.setText(selectedEvenement.getDate_Event());
    }
    
   

    @FXML
    private void back(ActionEvent event) {
        
          try {
              Node node = (Node) event.getSource();
              Stage stage = (Stage) node.getScene().getWindow();
              //stage.setMaximized(true);
              stage.close();
              Scene scene = new Scene(FXMLLoader.load(getClass().getResource("gestion_evenement.fxml")));
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
      
      
    
}
