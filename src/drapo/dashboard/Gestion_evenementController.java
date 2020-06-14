/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import com.esprit.Entite.Evenement;
import com.esprit.Service.ServiceEvenement;
import com.esprit.Utils.DataBase;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class Gestion_evenementController implements Initializable {

   
     @FXML private TableView<?> tableView;
    @FXML private TableColumn<?, ?> firstNameColumn;
    @FXML private TableColumn<?, ?> lieuColumn;
    @FXML private TableColumn<?, ?> prixColumn;
    @FXML private TableColumn<Evenement, Integer> nb_placesColumn;
    @FXML private TableColumn<Evenement, String> date_eventColumn;
    
    
    @FXML private Button afficher;
    
    
    private Button detail;
    @FXML
    private VBox pnl_scroll;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
    }
    
     public void userClickedOnTable(){
        this.detail.setDisable(false);
    }
    
    
    
      @FXML
    private void changeScreenButton(ActionEvent event) {
          try {
              Node node = (Node) event.getSource();
              Stage stage = (Stage) node.getScene().getWindow();
              //stage.setMaximized(true);
              stage.close();
              Scene scene = new Scene(FXMLLoader.load(getClass().getResource("AjouterEvenement.fxml")));
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(AjouterEvenementController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
         @FXML
    private void changeScreenButton1(ActionEvent event) throws IOException {
        
          try {
              Node node = (Node) event.getSource();
              Stage stage = (Stage) node.getScene().getWindow();
              //stage.setMaximized(true);
              stage.close();
              Scene scene = new Scene(FXMLLoader.load(getClass().getResource("UpdateDelete.fxml")));
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(UpdateDeleteController.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    
    }
    
         @FXML
    private void changeScreenHome(ActionEvent event) {
          try {
              Node node = (Node) event.getSource();
              Stage stage = (Stage) node.getScene().getWindow();
              //stage.setMaximized(true);
              stage.close();
              Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Home.fxml")));
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
/*
    @FXML
    private void ajouterEvent(ActionEvent event) {
        try {
            
            
            String e = lieuTextField.getText();
            String p = firstNameTextField.getText();
            int z =Integer.parseInt(prixTextField.getText());
            
            int a = Integer.parseInt(nb_placesTextField.getText());
            String m = date_eventDatePicker.getValue().toString();

            /*
            Evenement evenement = new Evenement(lieuTextField.getText(), firstNameTextField.getText(),
                                     prixTextField.getLength(),nb_placesTextField.getLength(),
                                     date_eventDatePicker.getDayCellFactory().toString());
            
            *//*
            String dat = date_eventDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Evenement eve = new Evenement(e, m, z, a, dat);
         
            
            ServiceEvenement serm= new ServiceEvenement();
            
            serm.ajouter(eve);
            
            ArrayList<Evenement> arrmen = (ArrayList<Evenement>) serm.readAll();
            ObservableList obs = FXCollections.observableArrayList(arrmen);
            tableView.setItems(obs);
           // firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
           /* lieuColumn.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
            nb_placesColumn.setCellValueFactory(new PropertyValueFactory<>("nb_places"));
            date_eventColumn.setCellValueFactory(new PropertyValueFactory<>("date_event"));*/
    /*
        } catch (SQLException ex) {
            Logger.getLogger(Gestion_evenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
           }*/

   

    @FXML
    private void afichertout(ActionEvent event) {
        
             
        try {
              ServiceEvenement se = new ServiceEvenement();
              ArrayList<Evenement> pl = (ArrayList<Evenement>) se.readAll();
            ObservableList obs = FXCollections.observableArrayList(pl);
            tableView.setItems(obs);
            lieuColumn.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
            nb_placesColumn.setCellValueFactory(new PropertyValueFactory<>("nb_places"));
            date_eventColumn.setCellValueFactory(new PropertyValueFactory<>("date_event"));
            
        } catch (Exception e) {
        }
       
    }

    @FXML
    private void changerDetail(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Item.fxml"));
       
       Parent tableViewParent = loader.load();
       Scene tableViewScene = new Scene (tableViewParent);
       
       
       //access the controler and call the method
       
       ItemController controller = loader.getController();
       controller.initData((Evenement) tableView.getSelectionModel().getSelectedItem());
       // this line gets the stage information
       
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
       
       window.setScene(tableViewScene);
       window.show();
     
       
    }

    @FXML
    private void home(ActionEvent event) {
        
                   try {
              Node node = (Node) event.getSource();
              Stage stage = (Stage) node.getScene().getWindow();
              //stage.setMaximized(true);
              stage.close();
              Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Eventafficher.fxml")));
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(AjouterEvenementController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

              
              
             
              
    
}
