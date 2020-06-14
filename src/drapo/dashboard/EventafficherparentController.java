/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import com.esprit.Entite.Evenement;
import com.esprit.Service.ServiceEvenement;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class EventafficherparentController implements Initializable {

    @FXML
    private JFXButton deconnecter;
    @FXML
    private ImageView refresh;
    @FXML
    private JFXButton ajout;
    @FXML
    private VBox pnl_scroll;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            refreshNodes();
        } catch (IOException ex) {
            Logger.getLogger(EventafficherparentController.class.getName()).log(Level.SEVERE, null, ex);
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
    
}
