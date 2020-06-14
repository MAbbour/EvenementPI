/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import com.esprit.Entite.Evenement;
import com.esprit.Entite.Inscription_evenement;
import com.esprit.Service.ServiceEvenement;
import com.esprit.Service.ServiceInscription_evenement;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class Home_Parent_frontController implements Initializable {
    
        Parent root;
    private int idparent;
    

    public Home_Parent_frontController(int idparent) {
        this.idparent = idparent;
    }

    public int getIdparent() {
        return idparent;
    }

    public void setIdparent(int idparent) {
        this.idparent = idparent;
    }

    @FXML
    private JFXButton deconnecter;
    @FXML
    private ImageView refresh;
    @FXML
    private JFXButton ajout;
    @FXML
    private JFXButton home;
    @FXML
    private VBox pnl_scroll;

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
          /*  try {
                refreshNodes();
            } catch (IOException ex) {
                Logger.getLogger(Home_Parent_frontController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
    }   
    /*
    
       private void refreshNodes() throws IOException
    {/*
            try {
                pnl_scroll.getChildren().clear();
                
                Node [] nodes = new  Node[200];
                ServiceEvenement enf= new ServiceEvenement();
                List<Evenement> Enflist = enf.readAll();
                int i=0;
                for(Evenement a :Enflist)
                    
                    
                {
                    
                    String monAutreString = Float.toString(a.getPrix());
                    EventController enfCon = new EventController(a.getLieu(),a.getNom(),monAutreString , a.getDate_Event());
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("event.fxml"));
                    loader.setController(enfCon);
                    nodes[i] = loader.load();
                    pnl_scroll.getChildren().add(nodes[i]);
                    i++;
                      
                }   } catch (SQLException ex) {
                Logger.getLogger(Home_Parent_frontController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        
        
       /*   pnl_scroll.getChildren().clear();
        
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
    }*/

    @FXML
    private void deconnecter(MouseEvent event) {
        
          if (event.getSource() == deconnecter) {
            //login here
                try {
                    //add you loading or delays - ;-)
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Login_parent.fxml")));
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            }
    }

    @FXML
    private void refresh(MouseEvent event) throws IOException {
        // refreshNodes();
    }
    
     @FXML
    private void changerinscription(ActionEvent event) {
        
        
        
                 try {
              Node node = (Node) event.getSource();
              Stage stage = (Stage) node.getScene().getWindow();
              //stage.setMaximized(true);
              stage.close();
              Scene scene = new Scene(FXMLLoader.load(getClass().getResource("gestion_inscription.fxml")));
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
   
    
}
