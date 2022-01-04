package controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnexionController {

    @FXML
    private Button btn_log;

    @FXML
    private Button btn_return;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_mdp;

    private Stage stage;
    
    @FXML
    private void panelAccueil(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("../fxml/accueil.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.setTitle("OBehrLantz");
    	stage.setScene(new Scene(root,600,400));
    	stage.show();
    }
    
}