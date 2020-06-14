/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import com.esprit.Entite.Inscription_evenement;
import com.esprit.Entite.Parent;
import com.esprit.Entite.enfant;
import com.esprit.Service.ServiceEvenement;
import com.esprit.Service.ServiceInscription_evenement;
import com.esprit.Service.ServiceParent;
import com.esprit.Utils.JavamailUtil_1;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */


public class FormulaireInscriptionController implements Initializable {

    @FXML
    private ListView<String> listView;
    
    
    

    
    
 ObservableList oblist = FXCollections.observableArrayList();
    
   ObservableList<String> items = FXCollections.observableArrayList();
    @FXML
    private AnchorPane tev;
    @FXML
    private TextField teven;
    @FXML
    private TextField idev;
    @FXML
    private TableView<?> tabenfant;
    @FXML
    private TableColumn<?, ?> coli;
    @FXML
    private TableColumn<?, ?> coln;
    @FXML
    private TableColumn<?, ?> colp;
    @FXML
    private TableColumn<?, ?> cola;
    @FXML
    private TextField tnom;
    @FXML
    private TextField tprenom;
    @FXML
    private TextField tdate;
    @FXML
    private TextField tid;
    @FXML
    private TextField tprix;
    @FXML
    private DatePicker dat;
   
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
           coli.setCellValueFactory(new PropertyValueFactory<>("id_enfant"));
           coln.setCellValueFactory(new PropertyValueFactory<>("nom"));
           colp.setCellValueFactory(new PropertyValueFactory<>("prenom"));
           cola.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));
           
           
           
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
           // TODO
       } catch (SQLException ex) {
             Logger.getLogger(FormulaireInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }    

    @FXML
    private void remplir(MouseEvent event) {
        String men = listView.getSelectionModel().getSelectedItem();
        
        teven.setText(men);
        ServiceEvenement serev = new ServiceEvenement();
        int id = serev.getIdEvenement(men);
        String sid = Integer.toString(id);
        idev.setText(sid);
        Float prix = serev.getPrixEvenement(men);
        String sprix = Float.toString(prix);
        tprix.setText(sprix);
        
    }

    @FXML
    private void remplirevenement(MouseEvent event) {
        enfant en = (enfant) tabenfant.getSelectionModel().getSelectedItem();
            String i = Integer.toString(en.getId_enfant());
            tid.setText(i);
            String i2 = en.getNom();
            tnom.setText(i2);
            String i3 =  en.getPrenom();
            tprenom.setText(i2);
            String i4 =  en.getDate_naissance();
            tdate.setText(i4);
       
        
    }

    @FXML
    private void inscrireevenement(ActionEvent event) {
     
        try {
            String e = tid.getText();
            String p = tprix.getText();
            String d = idev.getText();
            int idenf= Integer.parseInt(e);
            float pri= Float.parseFloat(p);
            int idev =Integer.parseInt(d);
           
         
            
             String date = dat.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
            ServiceInscription_evenement serinsc= new ServiceInscription_evenement();
            Inscription_evenement in = new Inscription_evenement(pri, idenf, idev,date);
            
           // Inscription_evenement in = new Inscription_evenement(idenf, pri, date, pre, eve)
           
           //Inscription_evenement in = new Inscription_evenement(pri, idenf, idev,date,pre,eve);
            serinsc.ajouter2(in);
            
            JavamailUtil_1 mail = new JavamailUtil_1();
            
            try {
                mail.sendMail("maroua.abbour@esprit.tn");
            } catch (Exception ex) {
                Logger.getLogger(FormulaireInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormulaireInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void retour(ActionEvent event) {
        
                 try {
              Node node = (Node) event.getSource();
              Stage stage = (Stage) node.getScene().getWindow();
              //stage.setMaximized(true);
              stage.close();
              Scene scene = new Scene(FXMLLoader.load(getClass().getResource("gestion_inscription.fxml")));
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(AjouterEvenementController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @FXML
    private void vider(ActionEvent event) {
        
           tnom.clear();
        tprenom.clear();
        tprix.clear();
        tdate.clear();
        teven.clear();
        tid.clear();
        idev.clear();
        dat.setValue(null);
    }
    
    
    
    
    
    
    
    }
        
        
       
    
    

