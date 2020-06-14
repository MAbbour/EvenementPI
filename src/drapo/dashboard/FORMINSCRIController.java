/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import com.esprit.Entite.Evenement;
import com.esprit.Entite.Inscription_evenement;
import com.esprit.Entite.enfant;
import com.esprit.Service.ServiceEvenement;
import com.esprit.Service.ServiceInscription_evenement;
import com.esprit.Service.ServiceParent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class FORMINSCRIController implements Initializable {

    private TextField tnomenf;
    @FXML
    private TextField tid;
    private TableColumn<?, ?> idd;
    private TextField tld;
     private TextField tev;
    private TableView<?> tabenfant;
    private TableColumn<?, ?> coln;
    
    private TableColumn<?, ?> cold;
    private TableColumn<?, ?> colid;
    
    ObservableList oblist = FXCollections.observableArrayList();
    private ListView<String> listView;
   ObservableList<String> items = FXCollections.observableArrayList();
  //  @FXML
  //  private TableColumn<?, ?> coladr;
 //   @FXML
  //  private TableColumn<?, ?> colage;
  //  @FXML
  //  private TextField tadr;
   // @FXML
   // private TextField tage;
    private TextField tidpar;
    private TableColumn<?, ?> colpre;
    private TextField tprenenf;
    @FXML
    private Label id_event;
    @FXML
    private TextField tnom;
    @FXML
    private TextField tprenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ServiceParent serm= new ServiceParent();
            ArrayList<enfant> arrmn = (ArrayList<enfant>) serm.readAllEnfant2(7);
            ObservableList obs2 = FXCollections.observableArrayList(arrmn);
            tabenfant.setItems(obs2);
            colid.setCellValueFactory(new PropertyValueFactory<>("id"));
            coln.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colpre.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            idd.setCellValueFactory(new PropertyValueFactory<>("id_parent"));
            cold.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));
            //coladr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            //colage.setCellValueFactory(new PropertyValueFactory<>("age"));
        } catch (SQLException ex) {
            Logger.getLogger(FORMINSCRIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                 
       listView.setItems(items);
       Connection Conn = null;

       try {
           Conn = DriverManager.getConnection("jdbc:mysql://localhost/minimiracle2", "root", "");
           System.out.println("Verbonden met de database");
       } catch (SQLException e) {
             System.out.println(e.getMessage());
             System.out.println("Verbinding met de database is mislukt.");
       }

       Statement stmt = null;
       ResultSet rs = null;
       try {
           stmt = Conn.createStatement();
           rs = stmt.executeQuery("SELECT nom FROM evenement");

           while (rs.next()) {
               items.add(rs.getString(1));
               System.out.println(rs.getString(1));
               
           }
       } catch (SQLException e) {

       }
       

            
    }    

  /*  @FXML
    private void inscrireenfant(ActionEvent event) {
    }

    private void remplirnomenfant(MouseEvent event) {
        
        
        
        enfant en = (enfant) tabenfant.getSelectionModel().getSelectedItem();
            String i = Integer.toString(en.getId_enfant());
            tid.setText(i);
            String i2 = en.getNom();
            tnomenf.setText(i2);
            String i3 = Integer.toString(en.getId_parent());
            tidpar.setText(i);
            String i4 = en.getDate_naissance();
            tld.setText(i4);
            String i5 = en.getPrenom();
            tprenenf.setText(i5);
         //   String i5 = en.getAdresse();
          //  tadr.setText(i5);
          //  String i6 = Integer.toString(en.getAge());
          //  tage.setText(i6);
            /*
            enfant men2 = (enfant) tabenfant.getSelectionModel().getSelectedItem();
            String i85 = Integer.toString(men2.getId_enfant());
            idtttt.setText(i85);*/
        
        //}

    private void remplirchamp(MouseEvent event) {
        
         String men = listView.getSelectionModel().getSelectedItem();
        
        tev.setText(men);
        
    }
    }
    

