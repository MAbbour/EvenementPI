/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import com.esprit.Entite.Evenement;
import com.esprit.Service.ServiceEvenement;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class UpdateDeleteController implements Initializable {

    
    @FXML private TextField firstNameTextField;
    @FXML private TextField lieuTextField;
    @FXML private TextField prixTextField;
    @FXML private TextField nb_placesTextField;
    private TextField date_eventTextField;
    @FXML private TextField id_eventTextField;
    @FXML private Button modifierButton;
    
    @FXML private Button supprimerButton;
    @FXML
    private TableView<Evenement> tabev;
    @FXML
    private TableColumn<?, ?> collieu;
    @FXML
    private TableColumn<?, ?> colnom;
    @FXML
    private TableColumn<?, ?> colpri;
    @FXML
    private TableColumn<?, ?> colnbp;
    @FXML
    private TableColumn<?, ?> coldate;
    @FXML
    private TableColumn<?, ?> colid;
    @FXML
    private DatePicker dateev;
    @FXML
    private ComboBox<String> searchbox;
    @FXML
    private TextField searchtext;
    @FXML
    private Button searchbutton;
    @FXML
    private Pane pnl_scroll;
    
    
    
    
    
    
    
    @FXML
    public void getEvenements(ActionEvent event) throws IOException, SQLException{
        String id_event = id_eventTextField.getText();
        int id = Integer.parseInt(id_event);
        
        
        
        ServiceEvenement serm= new ServiceEvenement();
        Evenement evenement =  serm.getEvenement(id);
        
        lieuTextField.setText(evenement.getLieu());
        firstNameTextField.setText(evenement.getNom());
        prixTextField.setText(String.valueOf(evenement.getPrix()));
        nb_placesTextField.setText(String.valueOf(evenement.getBn_places()));
        date_eventTextField.setText(evenement.getDate_Event());
        
        
        
    }
    

    
    @FXML
    public void supprimer(ActionEvent event) throws IOException{
        String id_event = id_eventTextField.getText();
        int id = Integer.parseInt(id_event);
        
        ServiceEvenement serm= new ServiceEvenement();
        serm.delete1(id);
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ServiceEvenement se = new ServiceEvenement();
            ArrayList<Evenement> pl = (ArrayList<Evenement>) se.readAll();
            ObservableList obs = FXCollections.observableArrayList(pl);
            tabev.setItems(obs);
            colid.setCellValueFactory(new PropertyValueFactory<>("id_event"));
            collieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colpri.setCellValueFactory(new PropertyValueFactory<>("prix"));
            colnbp.setCellValueFactory(new PropertyValueFactory<>("nb_places"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("date_event"));
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        ObservableList<String> list = FXCollections.observableArrayList("lieu","nom","prix","nb_places","date_event");
        
        searchbox.setItems(list);
        
        nb_placesTextField.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));
        firstNameTextField.addEventFilter(KeyEvent.KEY_TYPED , letter_Validation(10));
        lieuTextField.addEventFilter(KeyEvent.KEY_TYPED , letter_Validation(10));
        prixTextField.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(10));
        
        
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

    @FXML
    private void remplirchamp(MouseEvent event) {
        Evenement men = tabev.getSelectionModel().getSelectedItem();
        String i = Integer.toString(men.getId_event());
        id_eventTextField.setText(i);
        lieuTextField.setText(men.getLieu());
        firstNameTextField.setText(men.getNom());
        String p = Float.toString(men.getPrix());
        prixTextField.setText(p);
        String t = Integer.toString(men.getBn_places());
        nb_placesTextField.setText(t);
        dateev.setPromptText(men.getDate_Event());
        
    }

    @FXML
    private void modifierEvenement(ActionEvent event) throws SQLException {
        
        
        
        String id_event = id_eventTextField.getText();
        int id = Integer.parseInt(id_event);
        
        String lieu = lieuTextField.getText();
        
        String nom = firstNameTextField.getText();
        
        String prix = prixTextField.getText();
        Float price = Float.parseFloat(prix);
        
        String nb_places = nb_placesTextField.getText();
        int nombre = Integer.parseInt(nb_places);
        
        String date = dateev.getValue().toString();
        
        Evenement evenement = new Evenement();
        evenement.setId_event(id);
        evenement.setLieu(lieu);
        evenement.setNom(nom);
        evenement.setPrix(price);
        evenement.setBn_places(nombre);
        evenement.setDate_Event(date);
        
       ServiceEvenement serm= new ServiceEvenement();
        boolean status = serm.update(evenement);
        
        if(status == true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("alert");
            alert.setHeaderText("information");
            alert.setContentText("evenement bien modifier !");
            alert.showAndWait();
        }else{
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("alert");
            alert.setHeaderText("information");
            alert.setContentText("evenement non modifier !");
            alert.showAndWait();
            
        }
        
        
        
        
    
    }

    @FXML
    private void vider(ActionEvent event) {
        
        firstNameTextField.clear();
        lieuTextField.clear();
        prixTextField.clear();
        nb_placesTextField.clear();
        dateev.setValue(null);
    }

    @FXML
    private void search_click(ActionEvent event) {
        
        String caractere = searchtext.getText();
        String besoin = searchbox.getValue().toString();
        
        
        //ServiceEvenement serm= new ServiceEvenement();
        
        //serm.chercher(besoin, caractere);
        
        
        
        
             ServiceEvenement se = new ServiceEvenement();
        try {
              ArrayList<Evenement> pl = (ArrayList<Evenement>) se.chercher(besoin, caractere);
            ObservableList obs = FXCollections.observableArrayList(pl);
            tabev.setItems(obs);
            collieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colpri.setCellValueFactory(new PropertyValueFactory<>("prix"));
            colnbp.setCellValueFactory(new PropertyValueFactory<>("nb_places"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("date_event"));
            
        } catch (Exception e) {
        }
    
    }


    }
    

