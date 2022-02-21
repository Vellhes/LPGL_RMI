package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import connexion.Connexion;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import magasin.Magasin;


public class ListeMagasinsController implements Initializable {

    @FXML
    private Label lbl_bienvenue;

    @FXML
    private ComboBox<Magasin> combo_magasins;

    @FXML
    private Button btn_go;

    public static Magasin magasin;
    Statement stm;
    ResultSet res;
    Alert alert;
    private Stage stage;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Connection cnx = Connexion.creeConnexion();
			stm = cnx.createStatement();
			res = stm.executeQuery("SELECT * FROM `magasin`");
			ArrayList<Magasin> listeMagasins = new ArrayList<>();
			while(res.next()) {
				magasin = new Magasin();
				String hote = "rmi://"+res.getString("AdresseMagasin")+":"+res.getInt("PortMagasin")+"/"+res.getString("NomMagasin");
				magasin.setAdresse(hote);
				magasin.setNom(res.getString("NomMagasin"));
				magasin.setIdentifiant(res.getInt("IDMagasin"));
				listeMagasins.add(magasin);
			}
			combo_magasins.setItems(FXCollections.observableArrayList(listeMagasins));
		}catch(SQLException e) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur");
	        alert.setHeaderText(null);
	    	alert.setContentText("Erreur de connexion à la base de données");
	    	alert.showAndWait();
		}
	}
	
	@FXML
	private void chargeMagasin(ActionEvent event) {
		Parent root;
		try {
			magasin = combo_magasins.getValue();
			root = FXMLLoader.load(getClass().getResource("../fxml/liste_produits1.fxml"));
			stage = new Stage();
	    	stage.setTitle(magasin.getNom());
	    	stage.setScene(new Scene(root,800,600));
	    	stage.show();
		} catch (IOException e) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur");
	        alert.setHeaderText(null);
	    	alert.setContentText("Impossible de charger la page du magasin : \n ");
	    	alert.showAndWait();
	    	e.printStackTrace();
		}
    	
	}
}
