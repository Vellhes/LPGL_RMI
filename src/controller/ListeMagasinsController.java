package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import connexion.Connexion;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import magasin.Magasin;

public class ListeMagasinsController implements Initializable {

    @FXML
    private Label lbl_bienvenue;

    @FXML
    private ComboBox<Magasin> combo_magasins;

    @FXML
    private Button btn_go;

    Statement stm;
    ResultSet res;
    Alert alert;
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Connection cnx = Connexion.creeConnexion();
			stm = cnx.createStatement();
			res = stm.executeQuery("SELECT * FROM `magasin`");
			ArrayList<Magasin> listeMagasins = new ArrayList<>();
			while(res.next()) {
				Magasin magasin = new Magasin();
				String hote = "rmi://"+res.getString("AdresseMagasin")+":"+res.getInt("PortMagasin")+"/"+res.getString("NomMagasin");
				magasin.setAdresse(hote);
				magasin.setNom(res.getString("NomMagasin"));
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
}
