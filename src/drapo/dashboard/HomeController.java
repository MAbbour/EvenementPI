/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author oXCToo
 */
public class HomeController implements Initializable {
    
    
      @FXML
    private VBox pnl_scroll;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        // refreshNodes();
    }    


    @FXML
    private void changergestionevenement1(ActionEvent event) {
        
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

   

    @FXML
    private void front(ActionEvent event) {
        
                           try {
              Node node = (Node) event.getSource();
              Stage stage = (Stage) node.getScene().getWindow();
              //stage.setMaximized(true);
              stage.close();
              Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Eventafficher.fxml")));
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @FXML
    private void changerinscription(ActionEvent event) {
        
                 try {
              Node node = (Node) event.getSource();
              Stage stage = (Stage) node.getScene().getWindow();
              //stage.setMaximized(true);
              stage.close();
              Scene scene = new Scene(FXMLLoader.load(getClass().getResource("gestion_inscription_parent.fxml")));
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    


    }

    
   
        


  

    
    
    
    

