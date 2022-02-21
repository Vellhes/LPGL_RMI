package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connexion.Connexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class InscriptionController {


    @FXML
    private Button btn_menu;

    @FXML
    private Button btn_valider;

    @FXML
    private TextField tf_mail;

    @FXML
    private TextField tf_mdp;

    @FXML
    private TextField tf_nom;

    @FXML
    private TextField tf_prenom;
	
    PreparedStatement stm;
    Alert alert;
    Stage stage;
    
    @FXML
    void panelAccueil(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("../fxml/accueil.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.setTitle("OBehrLantz");
    	stage.setScene(new Scene(root,600,400));
    	stage.show();
    }
    
    @FXML
    void ajoutClient() {
    	String mail, mdp, nom, prenom;
    	mail = tf_mail.getText();
    	mdp = tf_mdp.getText();
    	nom = tf_nom.getText();
    	prenom = tf_prenom.getText();
    	if(mail.isEmpty() || mdp.isEmpty() || prenom.isEmpty() || nom.isEmpty()) {
    		alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Informations incomplètes");
	        alert.setHeaderText(null);
	    	alert.setContentText("Veuillez remplir tous les champs");
	    	alert.showAndWait();
    	}
    	else {
    		try {
    			Connection cnx = Connexion.creeConnexion();
    			stm = cnx.prepareStatement("INSERT INTO `rmi`.`Client` (`IDClient`, `NomClient`, `PrenomClient`, `AdresseClient`, `CP`, `Ville`, `AdresseClient2`, `Mobile`, `Mail`, `Mdp`) VALUES (0,?,?,'',0,'','','',?,?);");
    			stm.setString(1, mail);
    			stm.setString(2, mdp);
    			stm.setString(3, nom);
    			stm.setString(4, prenom);
    			stm.executeUpdate();
    			alert = new Alert(AlertType.CONFIRMATION);
    			alert.setTitle("Client Ajouté");
    	        alert.setHeaderText(null);
    	    	alert.setContentText("Le client "+nom+" "+prenom+" a bien été ajouté !");
    	    	alert.showAndWait();
    		} catch (SQLException e) {
    			alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Erreur");
    	        alert.setHeaderText(null);
    	    	alert.setContentText("Impossible d'ajouter le client " + e);
    	    	alert.showAndWait();
    		}
    	}
    }
}
