package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class ConnexionController {

    @FXML
    private Button btn_log;

    @FXML
    private Button btn_return;

    @FXML
    private TextField tf_mail;

    @FXML
    private TextField tf_mdp;

    PreparedStatement stm;
    Alert alert;
    private Stage stage;
    
    @FXML
    private void panelAccueil(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("../fxml/accueil.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.setTitle("OBehrLantz");
    	stage.setScene(new Scene(root,600,400));
    	stage.show();
    }
    
    @FXML
    private void chercheClient(ActionEvent event) throws IOException {
    	String mail, mdp;
    	mail = tf_mail.getText();
    	mdp = tf_mdp.getText();
    	if(mail.isEmpty() || mdp.isEmpty()) {
    		alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Informations incomplètes");
	        alert.setHeaderText(null);
	    	alert.setContentText("Veuillez remplir tous les champs");
	    	alert.showAndWait();
    	}
    	else {
    		try {
    			Connection cnx = Connexion.creeConnexion();
    			stm = cnx.prepareStatement("SELECT * FROM `client` WHERE Mail = ? AND Mdp = ?;");
    			stm.setString(1, mail);
    			stm.setString(2, mdp);
    			ResultSet res = stm.executeQuery();
    			if(res.next()) {
    				alert = new Alert(AlertType.CONFIRMATION);
        			alert.setTitle("Connecté");
        	        alert.setHeaderText(null);
        	    	alert.setContentText("Utilisateur connecté !");
        	    	alert.showAndWait();
        	    	Parent root = FXMLLoader.load(getClass().getResource("../fxml/liste_magasins.fxml"));
        	    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	    	stage.setTitle("Liste des magasins");
        	    	stage.setScene(new Scene(root,600,400));
        	    	stage.show();
    			}
    			else {
    				alert = new Alert(AlertType.WARNING);
        			alert.setTitle("Utilisateur Introuvable");
        	        alert.setHeaderText(null);
        	    	alert.setContentText("Impossible de trouver l'utilisateur correspondant à ces identifiants.");
        	    	alert.showAndWait();
    			}
    		}catch(SQLException e) {
    			alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Erreur");
    	        alert.setHeaderText(null);
    	    	alert.setContentText("Impossible de se connecter : " + e);
    	    	alert.showAndWait();
    		}
    	}
    }
    
}