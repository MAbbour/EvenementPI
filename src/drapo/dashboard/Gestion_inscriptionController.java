/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import com.esprit.Entite.Evenement;
import com.esprit.Entite.Inscription_evenement;
import com.esprit.Entite.enfant;
import com.esprit.Service.ServiceEnfant;
import com.esprit.Service.ServiceEvenement;
import com.esprit.Service.ServiceInscription_evenement;
import com.esprit.Service.ServiceParent;
import com.esprit.Utils.JavamailUtil_1;
import com.esprit.Utils.Pdf;
import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class Gestion_inscriptionController implements Initializable {

    
    @FXML private TableView<?> tableView2;
    private TableColumn<?, ?> id_inscColumn;
    
    @FXML private Button afficher_insc;
    @FXML
    private JFXButton activite;
    @FXML
    private VBox pnl_scroll;
    @FXML
    private TableColumn<?, ?> dateCol;
    @FXML
    private TableColumn<?, ?> enfcol;
    @FXML
    private TableColumn<?, ?> evcol;
    ObservableList oblist = FXCollections.observableArrayList();
    @FXML
    private TableColumn<?, ?> idcol;
    @FXML
    private TextField t11;
    @FXML
    private TableColumn<?, ?> prixcol;
    private void changeScreenHome1(ActionEvent event) {
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            
            
            
            
            
            ServiceInscription_evenement serm= new ServiceInscription_evenement();
            ArrayList<Inscription_evenement> arrmn = (ArrayList<Inscription_evenement>) serm.readAll();
            ObservableList obs2 = FXCollections.observableArrayList(arrmn);
            tableView2.setItems(obs2);
           // obs2 = tableView2.getSelectionModel().getSelectedItems();
            
            
            enfcol.setCellValueFactory(new PropertyValueFactory<>("nom_enfant"));
            evcol.setCellValueFactory(new PropertyValueFactory<>("nom_evenemment"));
            idcol.setCellValueFactory(new PropertyValueFactory<>("id_insc"));
            dateCol.setCellValueFactory(new PropertyValueFactory<>("date_insc"));
            prixcol.setCellValueFactory(new PropertyValueFactory<>("prix"));
            
        } catch (SQLException ex) {
            Logger.getLogger(Gestion_inscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
/*
    @FXML
    private void afficherinscription(ActionEvent event) {
        
                ServiceInscription_evenement se = new ServiceInscription_evenement();
               //Evenement ev = new Evenement();
                //enfant en = new enfant();
        try {
            
          // String id_insc = id_inscColumn.getText();
           // int id = Integer.parseInt(id_insc);
            
              ArrayList<Inscription_evenement> pl = (ArrayList<Inscription_evenement>) se.readAll();
            ObservableList obs = FXCollections.observableArrayList(pl);
            tableView2.setItems(obs);
            id_inscColumn.setCellValueFactory(new PropertyValueFactory<>("id_insc"));
            prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
            
            /*
            int prenom = se.getInscription(id).getId_enfant();
            String prenom1 = en.getPrenom();
            
            String nom = se.rechercheIdEvent(ev.getId_event()).get(3).toString();
            */
        /*    nom_eventColumn.setCellValueFactory(new PropertyValueFactory<>("Id_enfant"));
            nom_enfantColumn.setCellValueFactory(new PropertyValueFactory<>("Id_event"));
            
        } catch (Exception e) {
        }
    }*/

    @FXML
    private void retournerHome(ActionEvent event) {
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
    
 

    

  

    @FXML
    private void afficherinscription(ActionEvent event) throws SQLException {
        
          
        
                ServiceInscription_evenement se = new ServiceInscription_evenement();
                oblist.addAll(se.readAll());
                ArrayList<String> listnomenf = (ArrayList<String>) se.affichtsinscri();
                 ObservableList obs = FXCollections.observableArrayList(listnomenf);
           
              //ArrayList<Inscription_evenement> pl = (ArrayList<Inscription_evenement>) se.affichtsinscri();
            //ObservableList obs = FXCollections.observableArrayList(pl);
           // tableView2.setItems(obs);
            //id_inscColumn.setCellValueFactory(new PropertyValueFactory<>("id_insc"));
            //prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
            //nom_eventColumn.setCellValueFactory(new PropertyValueFactory<>("id_enfant"));
            //nom_enfantColumn.setCellValueFactory(new PropertyValueFactory<>("id_event"));
           // dateCol.setCellValueFactory(new PropertyValueFactory<>("Date_insc"));
            enfcol.setCellValueFactory(new PropertyValueFactory<>("nom_enfant"));
            evcol.setCellValueFactory(new PropertyValueFactory<>("nom_evenement"));
            
            
           
           /* 
            ServiceEvenement serv = new ServiceEvenement();
           
            String p = id_inscColumn.getText();
            int z =Integer.parseInt(p);
          
           
             String pl2 = serv.getEvenement2(z).getNom();
             ObservableList obs2 = FXCollections.observableArrayList(pl2);
             tableView2.setItems(obs2);
             nom_eventColumn.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
             
             
             ServiceEnfant serv2 = new ServiceEnfant();
             
             String pl3 = serv2.getEnfant2(3).getNom()+" "+serv2.getEnfant2(z).getPrenom();
             ObservableList obs3 = FXCollections.observableArrayList(pl3);
             tableView2.setItems(obs3);
             nom_enfantColumn.setCellValueFactory(new PropertyValueFactory<>("nom_enfant"));*/
       
        
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

    @FXML
    private void ajouter(ActionEvent event) {
        
           try {
              Node node = (Node) event.getSource();
              Stage stage = (Stage) node.getScene().getWindow();
              //stage.setMaximized(true);
              stage.close();
              Scene scene = new Scene(FXMLLoader.load(getClass().getResource("formulaireInscription.fxml")));
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(AjouterEvenementController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @FXML
    private void supprimerinscri(ActionEvent event) {
       
        try {
            ServiceInscription_evenement serinsc = new ServiceInscription_evenement();
        int i = Integer.parseInt(idcol.getText());
        serinsc.delete(i);
        } catch (Exception e) {
            e.getMessage();
 
        
        
    }

    }

    @FXML
    private void remplir(MouseEvent event) {
        
        
               Inscription_evenement men = (Inscription_evenement) tableView2.getSelectionModel().getSelectedItem();
        String i = Integer.toString(men.getId_insc());
       // idcol.setText(i);
        t11.setText(i);
       // enfcol.setText(i);
        //prixcol.setText(i);  
       // evcol.setText(i);
   
    }

    @FXML
    private void pdf(ActionEvent event) throws SQLException, DocumentException, IOException
{
      
        Pdf pdf=new  Pdf();
       int z = Integer.parseInt(t11.getText());
      // float p = Float.parseFloat(prixcol.getText());
       //String j = enfcol.getText();
       //String l = evcol.getText();
          pdf.pdf(z);
       
    }




    }
    
    
    
    



  
        
        
  
    
    



