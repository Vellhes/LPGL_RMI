package controller;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import connexion.Connexion;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import magasin.Magasin;

public class ListeProduitsController implements Initializable{
	PreparedStatement stm;
    ResultSet res;
	Magasin magasin;
	@FXML
    private AnchorPane panePanier;
	@FXML
    private AnchorPane paneListeProduits;
	@FXML
    private Label lbl_magasin;
    @FXML
    private AnchorPane pane_prod;
    @FXML
    private ImageView img_produit;
    @FXML
    private Label lbl_nom;
    @FXML
    private Label lbl_prix;
    @FXML
    private Spinner<?> spin_quantite;
    @FXML
    private Button btn_ajouter;
    @FXML
    private AnchorPane pane_prod1;
    @FXML
    private ImageView img_produit1;
    @FXML
    private Label lbl_nom1;
    @FXML
    private Label lbl_prix1;
    @FXML
    private Spinner<?> spin_quantite1;
    @FXML
    private Button btn_ajouter1;
    @FXML
    private AnchorPane pane_prod3;
    @FXML
    private ImageView img_produit3;
    @FXML
    private Label lbl_nom3;
    @FXML
    private Label lbl_prix3;
    @FXML
    private Spinner<?> spin_quantite3;
    @FXML
    private Button btn_ajouter3;
    @FXML
    private AnchorPane pane_prod4;
    @FXML
    private ImageView img_produit4;
    @FXML
    private Label lbl_nom4;
    @FXML
    private Label lbl_prix4;
    @FXML
    private Spinner<?> spin_quantite4;
    @FXML
    private Button btn_ajouter4;
    @FXML
    private AnchorPane pane_prod2;
    @FXML
    private ImageView img_produit2;
    @FXML
    private Label lbl_nom2;
    @FXML
    private Label lbl_prix2;
    @FXML
    private Spinner<?> spin_quantite2;
    @FXML
    private Button btn_ajouter2;
    @FXML
    private AnchorPane pane_prod5;
    @FXML
    private ImageView img_produit5;
    @FXML
    private Label lbl_nom5;
    @FXML
    private Label lbl_prix5;
    @FXML
    private Spinner<?> spin_quantite5;
    @FXML
    private Button btn_ajouter5;
    @FXML
    private Button btn_validerArticle;
    @FXML
    private Button btn_supprArticle;
    @FXML
    private Button btn_validerPanier;
    @FXML
    private Button btn_panier;
    @FXML
    private ImageView img_article0;
    @FXML
    private Label lbl_nom0;
    @FXML
    private Label lbl_desc0;
    @FXML
    private Label lbl_prixTotal;
    @FXML
    private Spinner<Integer> spin_quantite0;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		paneListeProduits.setVisible(true);
		panePanier.setVisible(false);
		try {
			pane_prod.setVisible(false);
			pane_prod1.setVisible(false);
			pane_prod2.setVisible(false);
			pane_prod3.setVisible(false);
			pane_prod4.setVisible(false);
			pane_prod5.setVisible(false);
			magasin = ListeMagasinsController.magasin;
			Connection cnx;
			cnx = Connexion.creeConnexion();
			stm = cnx.prepareStatement("SELECT * FROM `magasin` WHERE IDMagasin = ?");
			stm.setInt(1, magasin.getIdentifiant());
			res = stm.executeQuery();
			if(res.next()) {
				lbl_magasin.setText(res.getString("NomMagasin"));
			}
			stm = cnx.prepareStatement("SELECT * FROM `produit` WHERE IDMagasin = ? LIMIT 0,6");
			stm.setInt(1, magasin.getIdentifiant());
			res = stm.executeQuery();
			if(res.next()) {
				pane_prod.setVisible(true);
				afficheProduit(img_produit,lbl_nom,lbl_prix,res.getString("Visuel"),res.getString("NomProduit"),res.getDouble("Prix"));
				if(res.next()) {
					pane_prod1.setVisible(true);
					afficheProduit(img_produit1,lbl_nom1,lbl_prix1,res.getString("Visuel"),res.getString("NomProduit"),res.getDouble("Prix"));
					if(res.next()) {
						pane_prod2.setVisible(true);
						afficheProduit(img_produit2,lbl_nom2,lbl_prix2,res.getString("Visuel"),res.getString("NomProduit"),res.getDouble("Prix"));
						if(res.next()) {
							pane_prod3.setVisible(true);
							afficheProduit(img_produit3,lbl_nom3,lbl_prix3,res.getString("Visuel"),res.getString("NomProduit"),res.getDouble("Prix"));
							if(res.next()) {
								pane_prod4.setVisible(true);
								afficheProduit(img_produit4,lbl_nom4,lbl_prix4,res.getString("Visuel"),res.getString("NomProduit"),res.getDouble("Prix"));
								if(res.next()) {
									pane_prod5.setVisible(true);
									afficheProduit(img_produit5,lbl_nom5,lbl_prix5,res.getString("Visuel"),res.getString("NomProduit"),res.getDouble("Prix"));
								}
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void afficheProduit(ImageView imgview, Label lblnom, Label lblprix,String img, String nom, double prix) {
		Image image = new Image("ressources/"+img);
		imgview.setImage(image);
		lblnom.setText(nom);
		lblprix.setText(""+prix);
	}
	
	@FXML
	private void affichePanier() {
		paneListeProduits.setVisible(false);
		panePanier.setVisible(true);
	}


}
