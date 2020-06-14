/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import drapo.dashboard.EventController;
import com.esprit.Entite.Evenement;
import com.esprit.Service.ServiceEvenement;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class EventafficherController implements Initializable {

    
    
     @FXML
    private VBox pnl_scroll;
     
     
       @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             refreshNodes();
         } catch (IOException ex) {
             //Logger.getLogger(EventafficherController.class.getName()).log(Level.SEVERE, null, ex);
             ex.getMessage();
         }
    }
     
       
        private void refreshNodes() throws IOException
    {
    
         pnl_scroll.getChildren().clear();
        
        Node [] nodes = new  Node[15];
        ServiceEvenement serv = new ServiceEvenement();
        List<Evenement> list = null;
         try {
             list = serv.readAll();
         } catch (SQLException ex) {
             Logger.getLogger(EventafficherController.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        for(int i = 0; i<10; i++)
        
        {
                nodes[i] = (Node)FXMLLoader.load(getClass().getResource("event.fxml"));
               pnl_scroll.getChildren().add(nodes[i]);
           
                }
                
       
    }

    @FXML
    private void gestionevenement(ActionEvent event) {
        
           try {
              Node node = (Node) event.getSource();
              Stage stage = (Stage) node.getScene().getWindow();
              //stage.setMaximized(true);
              stage.close();
              Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Home.fxml")));
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(AjouterEvenementController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
}
    
  
    

