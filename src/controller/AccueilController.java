package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AccueilController {


    @FXML
    private Button btn_connexion;

    @FXML
    private Button btn_inscription;

    @FXML
    private Button btn_listeMagasins;
    
    private Stage stage;
	
    @FXML
    private void switchConnexion(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("../fxml/connexion.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.setTitle("Connexion");
    	stage.setScene(new Scene(root,600,400));
    	stage.show();
    }
    
    @FXML
    private void switchInscription(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("../fxml/inscription.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.setTitle("Inscription");
    	stage.setScene(new Scene(root,600,400));
    	stage.show();
    }
    
}
