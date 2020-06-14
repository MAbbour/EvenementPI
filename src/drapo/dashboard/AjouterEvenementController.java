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
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class AjouterEvenementController implements Initializable {

    
    
    @FXML private TextField firstNameTextField;
    @FXML private TextField lieuTextField;
    @FXML private TextField prixTextField;
    @FXML private TextField nb_placesTextField;
    @FXML private DatePicker date_eventDatePicker;
    
    @FXML private Button AjouterButton;
    @FXML private Button ViderButton;
    
     @FXML
    private JFXDatePicker FinPicker;
    
    
    public EventHandler<KeyEvent> numeric_Validation(final Integer max_Lengh) {
    return new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent e) {
            TextField txt_TextField = (TextField) e.getSource();                
            if (txt_TextField.getText().length() >= max_Lengh) {                    
                e.consume();
            }
            if(e.getCharacter().matches("[0-9.]")){ 
                if(txt_TextField.getText().contains(".") && e.getCharacter().matches("[.]")){
                    e.consume();
                }else if(txt_TextField.getText().length() == 0 && e.getCharacter().matches("[.]")){
                    e.consume(); 
                }
            }else{
                e.consume();
            }
        }
    };
}
    
    public EventHandler<KeyEvent> letter_Validation(final Integer max_Lengh) {
    return new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent e) {
            TextField txt_TextField = (TextField) e.getSource();                
            if (txt_TextField.getText().length() >= max_Lengh) {                    
                e.consume();
            }
            if(e.getCharacter().matches("[A-Za-z]")){ 
            }else{
                e.consume();
            }
        }
    };
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nb_placesTextField.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
        firstNameTextField.addEventFilter(KeyEvent.KEY_TYPED , letter_Validation(10));
        lieuTextField.addEventFilter(KeyEvent.KEY_TYPED , letter_Validation(10));
        prixTextField.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(10));
    }    
    
    
    
    
    @FXML
    public void insertData(ActionEvent event) throws SQLException{
        LocalDate Date = date_eventDatePicker.getValue();
        String lieu = lieuTextField.getText();
        String nom = firstNameTextField.getText();
        int prix =Integer.parseInt(prixTextField.getText());
        int nb_places = Integer.parseInt(nb_placesTextField.getText());
        String date= Date.toString();
        
        /*
              LocalDate ld = FinPicker.getValue();

            Date today = new Date();

            Date d = java.sql.Date.valueOf(ld);
            if (today.compareTo(d) > 0) {
                System.out.println("saisir la date de nouveau");
                JOptionPane.showMessageDialog(null, "la date doit etre superieure a la \n date d'aujourd hui");
            }else{*/
                
          
        
        Evenement evenement = new Evenement();
        evenement.setLieu(lieu);
        evenement.setNom(nom);
        evenement.setPrix(prix);
        evenement.setBn_places(nb_places);
        evenement.setDate_Event(date);
        
        
        
        ServiceEvenement serm= new ServiceEvenement();
        
        serm.ajouter(evenement);
         
        
    
    }
    
    @FXML
    public void vider(){
        firstNameTextField.clear();
        lieuTextField.clear();
        prixTextField.clear();
        nb_placesTextField.clear();
        date_eventDatePicker.setValue(null);
        
    }

    @FXML
    private void retourner(ActionEvent event) {
           try {
              Node node = (Node) event.getSource();
              Stage stage = (Stage) node.getScene().getWindow();
              //stage.setMaximized(true);
              stage.close();
              Scene scene = new Scene(FXMLLoader.load(getClass().getResource("gestion_evenement.fxml")));
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(Gestion_evenementController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
}
